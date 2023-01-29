package org.chiangkai;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ChiangKai
 * @date 2023/1/13
 */
@Slf4j
public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        char[] chars = "!@#$%^&*()-+".toCharArray();
        log.info("{}",chars);
    }

    static class T1 implements Runnable {
        static final ThreadLocal<String> str = new ThreadLocal<>();

        @SneakyThrows
        public T1(String a) {
            if (a != null){
                System.out.println(Thread.currentThread().getId());
                str.set(a);
                System.out.println("set str");
            }
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId());
            System.out.println(str.get());
        }
    }

}
