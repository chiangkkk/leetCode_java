package org.chiangkai.problem707;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

@Slf4j
class MyLinkedListTest {

    @SneakyThrows
    @Test
    public void testMyLink() {
        String[] arr1 = {"addAtHead", "addAtHead", "addAtHead", "addAtIndex", "deleteAtIndex", "addAtHead", "addAtTail", "get", "addAtHead", "addAtIndex", "addAtHead"};
        int[][] arr2 =
                {{7}, {2}, {1}, {3, 0}, {2}, {6}, {4}, {4}, {4}, {5, 0}, {6}};
        // 1->2->7->0
        MyLinkedList linkedList = new MyLinkedList();
        Class<MyLinkedList> myLinkedListClass = MyLinkedList.class;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
//            System.out.println(arr1[i]);
            Object result = null;
//            log.info("arr2={}", arr2);
            if (arr2[i].length == 1) {
                Method method = myLinkedListClass.getMethod(arr1[i], int.class);
                result = method.invoke(linkedList, arr2[i][0]);
            } else {
                Method method = myLinkedListClass.getMethod(arr1[i], int.class, int.class);
                result = method.invoke(linkedList, arr2[i][0], arr2[i][1]);
            }
            MyLinkedList head = linkedList.head;
            MyLinkedList temp = head;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.val);
                temp = temp.next;
                if (temp != null) {
                    sb.append(" -> ");
                }
            }
            log.info("method={},args={}", arr1[i], arr2[i]);
            if (result != null) {
                res.add((Integer) result);
            } else {
                res.add(null);
            }
            log.info("result = {}, linklist={}, length = {}", result, sb.toString(), MyLinkedList.length);
        }
        log.info("res = {}", res);
    }

}