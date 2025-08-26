package com.xj.leetcode.common;

import java.util.Arrays;
import java.util.Random;

/**
 * @author XuJ
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 生成随机链表
     *
     * @param length 链表长度
     * @return 头结点
     */
    public static ListNode buildRandomLinkedList(int length) {
        if (length <= 0) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            current.next = new ListNode(random.nextInt(100)); // 生成范围在0到99的随机整数
            current = current.next;
        }

        return dummy.next; // 返回头结点的下一个节点作为实际的头结点
    }

    /**
     * 打印链表
     *
     * @param head 头结点
     */
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
    }

    /**
     * 生成有序的随机链表
     *
     * @param length    链表长度
     * @param ascending 是否升序
     * @return 头结点
     */
    public static ListNode buildSortedRandomLinkedList(int length, boolean ascending) {
        if (length <= 0) {
            return null;
        }

        int[] sortedValues = generateSortedRandomArray(length, ascending);
        return buildLinkedListByArray(sortedValues);
    }

    /**
     * 根据数组, 生成链表
     *
     * @param array    链表数组
     * @return 头结点
     */
    public static ListNode buildLinkedListByArray(int[] array) {
        if (array.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : array) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next; // 返回头结点的下一个节点作为实际的头结点
    }

    private static int[] generateSortedRandomArray(int length, boolean ascending) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100); // 生成范围在0到99的随机整数
        }

        if (ascending) {
            Arrays.sort(array);
        } else {
            Arrays.sort(array);
            reverseArray(array);
        }

        return array;
    }

    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


}


