package SequenceStudy;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode removeElements(ListNode head, int val) {
/*        //若给定值恰好为头结点
        while(head != null && head.val == val){
            head = head.next;
        }
        //若所有元素都被删除
        if(head == null){
            return null;
        }
        //若被删除的元素一定有前驱节点
        ListNode prev = head;
        //先找到前驱节点
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;//再将前驱节点指向被删除元素的下一个节点
            }
            else {
                prev = prev.next;
            }
        }
        return head;*/

        //创建虚拟头结点，确保每一个被删除元素都有前驱节点
        /*ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        //通过前驱节点寻找被删除的数的
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
                prev = prev.next;
            }
        }
        return dummyHead.next;*/

        //递归实现
        if(head == null){
            return null;
        }
        else{
            ListNode res = removeElements(head.next,val);
            if(head.val == val){
                return res;
            }
            else{
                head.next = res;
                return head;
            }
        }
    }
    public ListNode reverseList(ListNode head) {
        /*ListNode fir = new ListNode(-1);
        for(ListNode tmp = head;tmp != null;tmp = tmp.next){
            ListNode newListNode = new ListNode(tmp.val);
            newListNode.next = fir.next;
            fir.next = newListNode;
        }
        return fir.next;*/

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        if(head == null || head.next == null){
            return null;
        }
        else
        {
            ListNode f = dummyHead.next;
            ListNode s = f.next;
            while(s != null){
                f.next = s.next;
                s.next = dummyHead.next;
                dummyHead.next = s;
                s = f.next;
            }
        }
        return dummyHead.next;
    }
    public ListNode middleNode(ListNode head) {
        if(head != null){
            ListNode fast = head;
            ListNode low = head;
            while(fast != null && low != null && fast.next != null){
                low = low.next;
                fast = fast.next.next;
            }
            return low;
        }
        return null;
    }
    //判断其是否为回文结构。
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构
    public boolean chkPalindrome(ListNode A) {
        //判断链表是否为空或只有一个值
        if(A == null || A.next == null){
            return true;
        }
        //找到中间节点
        ListNode fast = A;
        ListNode low = A;
        while(fast != null && low != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        //将后一半链表取出
        ListNode mid = low;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = mid;
        if(mid.val == A.val){//如果原链表只有两个一样的值，视为回文链表
            return true;
        }
        else{
            if(mid.next == null){//原链表后半部分为空
                return false;
            }
            else{//将后一半链表翻转
                ListNode f = dummyHead.next;
                ListNode s = f.next;
                while(s != null){
                    f.next = s.next;
                    s.next = dummyHead.next;
                    dummyHead.next = s;
                    s = f.next;
                }
            }
        }
        //比较前一部分链表和后一部分链表内容
        while(A != null && dummyHead.next != null){
            if(A.val != dummyHead.next.val){
                return false;
            }
            A = A.next;
            dummyHead.next = dummyHead.next.next;
            return true;
        }
        return false;
    }
    //输入一个链表，输出该链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head != null){
            ListNode first = head;
            ListNode second = head;
            for(int i = 0; i < k;i++){
                if(first != null){
                    first = first.next;
                }
                else{
                    return null;
                }
            }
            while(first != null){
                first = first.next;
                second = second.next;
            }
            return second;
        }
        return null;
    }
}
