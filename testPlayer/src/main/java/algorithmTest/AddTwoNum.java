package algorithmTest;

public class AddTwoNum {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode tail = new ListNode();
        int sum = l1.val + l2.val;
        tail.val = sum%10;
        header = tail;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            sum = l1.val + l2.val + sum/10;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
        }
        while (l1.next!=null) {
            l1 = l1.next;
            sum = l1.val  + sum/10;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
        }
        while (l2.next!=null) {
            l2 = l2.next;
            sum = l2.val  + sum/10;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
        }
        if (sum / 10 != 0) {
            tail.next = new ListNode(sum/10);
        }
        return header;
    }

    public static void main(String[] args) {

    }
}
