//给出一个链表和一个值x，以x为参照将链表划分成两部分，使所有小于x的节点都位于大于或等于x的节点之前。
//两个部分之内的节点之间要保持的原始相对顺序。
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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        ListNode beforeHead=null;
        ListNode before=null;
        ListNode afterHead=null;
        ListNode after=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            cur.next=null;
            if(cur.val<x){
                if(beforeHead==null){
                    beforeHead=cur;
                    before=cur;
                }else{
                    before.next=cur;
                    before=before.next;
                }
            }else{
                if(afterHead==null){
                    afterHead=cur;
                    after=cur;
                }else{
                    after.next=cur;
                    after=after.next;
                }
            }
            cur=curNext;
        }
        if(beforeHead==null){
            return afterHead;
        }else{
            before.next=afterHead;
            return beforeHead;
        }
    }
}


//判断给定的链表中是否有环
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}

//对于一个给定的链表，返回环的入口节点，如果没有环，返回null
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}

//现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的
//任意一个节点或者指向空。请对这个链表进行深拷贝。
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        RandomListNode cur=head;
        while(cur!=null){
            RandomListNode clone=new RandomListNode(cur.label);
            clone.next=cur.next;
            cur.next=clone;
            cur=cur.next.next;
        }
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                 cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        cur=head;
        RandomListNode newHead=cur.next;
        while(cur.next!=null){
            RandomListNode curNext=cur.next;
            cur.next=cur.next.next;
            cur=curNext;
        }
        return newHead;
    }
}

