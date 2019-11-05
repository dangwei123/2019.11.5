//将给定的链表中每两个相邻的节点交换一次，返回链表的头指针
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        int len=getLen(head);
        for(int i=0;i<len/2;i++){
            ListNode curNext=cur.next;
            cur.next=curNext.next;
            curNext.next=pre.next;
            pre.next=curNext;
            
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}

//将给出的链表中的节点每k个一组翻转，返回翻转后的链表
//如果链表中的节点数不是k的倍数，将最后剩下的节点保持原样
//你不能更改节点中的值，只能更改节点本身。
//只允许使用常数级的空间
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        int len=getLen(head);
        for(int i=0;i<len/k;i++){
            for(int j=0;j<k-1;j++){
                ListNode curNext=cur.next;
                cur.next=curNext.next;
                curNext.next=pre.next;
                pre.next=curNext;
            }
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}

//删除给出链表中的重复元素，使链表中的所有元素都只出现一次
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=head;
        ListNode cur=pre.next;
        while(cur!=null){
            if(cur.val==pre.val){
                cur=cur.next;
            }else{
                pre.next=cur;
                pre=cur;
                cur=cur.next;
            }
        }
        pre.next=null;
        return head;
    }
}

//将一个链表m位置到n位置之间的区间反转，要求使用原地算法，并且在一次扫描之内完成反转。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        for(int i=0;i<m-1;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        for(int i=0;i<n-m;i++){
            ListNode curNext=cur.next;
            cur.next=curNext.next;
            curNext.next=pre.next;
            pre.next=curNext;
        }
        return dummy.next;
    }
}