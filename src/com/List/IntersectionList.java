package com.List;

public class IntersectionList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow == null || slow.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }


        return slow;
    }*/

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(8);
        ListNode e = new ListNode(10);
        ListNode f = new ListNode(12);
        ListNode g = new ListNode(14);
        ListNode h = new ListNode(16);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        //ListNode fk=detectCycle(a);
        //System.out.println(fk.val);
    }
}

