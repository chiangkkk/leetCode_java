package org.chiangkai;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ChiangKai
 * @date 2023/1/13
 */
@Slf4j
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException, IOException {
        int totals = 100000000;
        int segment = 20 ;
        // 写入5亿条数据
        // 开启20个线程
        ExecutorService service = Executors.newFixedThreadPool(segment);
        AtomicInteger incr = new AtomicInteger(0);
        CountDownLatch downLatch = new CountDownLatch(segment);
        long s = System.currentTimeMillis();
        for(int j=0;j<segment;j++) {
            service.execute(()->{
                RandomAccessFile acf;
                FileChannel fc = null ;
                try {
                    String fName = "D:\\tmp_" + incr.getAndIncrement()+".txt";
                    acf = new RandomAccessFile(fName, "rw");
                    fc = acf.getChannel();
                    int offset = 0;
                    for (int i = 0; i < totals/segment/10000; i++) { //25000000
                        //每次写1w个 数字
                        StringBuilder sb = new StringBuilder();
                        for (int k=0;k<10000;k++) {
                            sb.append(new Random().nextInt(10000000) + "\n");
                        }
                        byte[] bs = sb.toString().getBytes();
                        MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, bs.length);
                        mbuf.put(bs);
                        offset = offset + bs.length;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    downLatch.countDown();
                }
            });
        }
        downLatch.await();
        System.out.println("await 唤醒， 小文件写入完毕! 耗時：" + (System.currentTimeMillis()-s));
        List<File> files = new ArrayList<File>();
        for(int i=0;i<segment;i++) {
            files.add(new File("D:\\tmp_" + i+".txt"));
        }
        s = System.currentTimeMillis();
        //合併文件
        merge(files, "D:\\last.txt");
        System.out.println("合併文件完毕! 耗時：" + (System.currentTimeMillis()-s));
        service.shutdown();
    }


    public static void merge(List<File> files , String to) {
        File t = new File(to);
        FileInputStream in = null;
        FileChannel inChannel = null;

        FileOutputStream out = null ;
        FileChannel outChannel = null ;
        try {
            out = new FileOutputStream(t, true);
            outChannel = out.getChannel();
            // 记录新文件最后一个数据的位置
            long start = 0;
            for (File file : files) {
                in = new FileInputStream(file);
                inChannel = in.getChannel();
                // 从inChannel中读取file.length()长度的数据，写入outChannel的start处
                outChannel.transferFrom(inChannel, start, file.length());
                start += file.length();
                in.close();
                inChannel.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                outChannel.close();
            } catch (Exception e2) {
            }
        }
    }
}
