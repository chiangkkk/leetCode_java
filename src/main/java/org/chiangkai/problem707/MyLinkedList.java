package org.chiangkai.problem707;

public class MyLinkedList {

    public Integer val;

    public MyLinkedList pre;
    public MyLinkedList next;

    public static MyLinkedList head = new MyLinkedList();

    public static MyLinkedList tail = head;

    public static int length = 0;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index > length && index < 0) {
            return -1;
        }
        MyLinkedList pos = head;
        //可以添加判断那边近从那别查询
        for (int i = 0; i < index; i++) {
            pos = pos.next;
        }
        if (pos != null && pos.val != null) {
            return pos.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        if (isInit()) {
            head.val = val;
        } else {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.val = val;
            MyLinkedList preHead = head;
            head = myLinkedList;
            head.next = preHead;
            head.pre = null;
            preHead.pre = head;
        }
        length++;
    }

    public void addAtTail(int val) {
        if (isInit()) {
            head.val = val;
        } else {
            MyLinkedList preTail = tail;
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.val = val;
            preTail.next = myLinkedList;
            tail = myLinkedList;
            myLinkedList.pre = preTail;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (isInit()) {
            head.val = val;
        } else {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.val = val;
            MyLinkedList pos = head;
            for (int i = 0; i < index; i++) {
                pos = pos.next;
            }
            if (index == 0) {
                MyLinkedList preHead = head;
                head = myLinkedList;
                head.next = preHead;
                head.next.pre = myLinkedList;
            } else if (index == length) {
                MyLinkedList preTail = tail;
                preTail.next = myLinkedList;
                myLinkedList.pre = preTail;
                tail = myLinkedList;
            } else {
                MyLinkedList lastLink = pos.pre;
                MyLinkedList nextLink = pos;
                lastLink.next = myLinkedList;
                myLinkedList.pre = lastLink;
                myLinkedList.next = nextLink;
                nextLink.pre = myLinkedList;
            }
        }
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index > length && index < 0) {
            return;
        }
        if (isInit()) {
            return;
        }
        // 只有一个的情况
        if (head == tail && index == 0) {
            head.val = null;
            length--;
            return;
        }
        if (index == 0) {
            MyLinkedList newHead = head.next;
            head = newHead;
            head.pre = null;
        } else if (index == length - 1) {
            MyLinkedList newTail = tail.pre;
            tail = newTail;
            tail.next = null;
        } else {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.val = val;
            MyLinkedList pos = head;
            for (int i = 0; i < index; i++) {
                pos = pos.next;
            }
            MyLinkedList posPre = pos.pre;
            MyLinkedList posNext = pos.next;
            posPre.next = posNext;
            posNext.pre = posPre;
        }
        length--;
    }

    /**
     * 是否初始化
     *
     * @return boolean
     */
    private boolean isInit() {
        return head == tail && head.val == null;
    }
}
