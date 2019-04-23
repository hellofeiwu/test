package linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            result.append(cur.val);
            if(cur.next != null) {
                result.append("->");
            }
            cur = cur.next;
        }

        return result.toString();
    }

    static class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }

            ListNode pre = head;
            while (pre.next != null){
                if(pre.next.val == val) {
                    pre.next = pre.next.next;
                }else {
                    pre = pre.next;
                }
            }

            return head;
        }
    }

    static class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre = dummyHead;

            while(pre.next != null) {
                if(pre.next.val == val) {
                    pre.next = pre.next.next;
                }else {
                    pre = pre.next;
                }
            }
            return dummyHead.next;
        }
    }

    static class Solution3 {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val){
                head = head.next;
            }
            ListNode pre = head;

            if(pre.next != null) {
                if(pre.next.val == val) {
                    pre.next = pre.next.next;
                }else {
                    pre = pre.next;
                }
                if(pre.next != null) {
                    removeElements(pre.next, val);
                }
            }

            return head;
        }
    }

    static class Solution4 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            return remove(dummyHead, val).next;
        }

        private ListNode remove(ListNode node, int val) {
            ListNode pre = node;
            if(pre.next != null) {
                if(pre.next.val == val) {
                    pre.next = pre.next.next;
                }else {
                    pre = pre.next;
                }
                remove(pre, val);
            }
            return node;
        }
    }

    static class Solution5 {
        public ListNode removeElements(ListNode head, int val, int depth) {
            System.out.println(generateDepthStr(depth) + " come in: " + head);
            if(head == null) {
                System.out.println(generateDepthStr(depth) + " return: " + head);
                return head;
            }
            ListNode res = removeElements(head.next, val, depth+1);
            System.out.println(generateDepthStr(depth) + " after remove: " + res);
            if(head.val == val) {
                System.out.println(generateDepthStr(depth) + " return: " + res);
                return res;
            }else {
                head.next = res;
                System.out.println(generateDepthStr(depth) + " return: " + head);
                return head;
            }
        }

        public String generateDepthStr(int depth) {
            StringBuilder res = new StringBuilder();
            for(int i=0; i<depth; i++) {
                res.append("-");
            }
            res.append(depth);
            return res.toString();
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,6,3};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i=1; i<arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        System.out.println(head);
        System.out.println((new Solution5()).removeElements(head, 6, 0));
    }
}


