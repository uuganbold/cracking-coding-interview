package ctci.chapter2;

public class Solution5 {

    /*
        List how big?
        long vs int?
    */
    public static  ListNode sum(ListNode a, ListNode b){
        if(a==null&&b==null) return null;
        int ansValue=retrieveReverseOrder(a)+retrieveReverseOrder(b);
        return makeListReverseOrder(ansValue); 
    }

    public static ListNode sumWhileTraversing(ListNode a, ListNode b){
        if(a==null&&b==null) return null;
        ListNode ans=new ListNode(0);
        ListNode tail=ans;

        int memorize=0;
        while(a!=null||b!=null){
            int aValue=a==null?0:a.data;
            int bValue=b==null?0:b.data;
            int value=aValue+bValue+memorize;
            tail.next=new ListNode(value%10);
            memorize=value/10;
            tail=tail.next;
            if(a!=null){
                a=a.next;
            }
            if(b!=null){
                b=b.next;
            }
        }

        if(memorize>0){
            tail.next=new ListNode(memorize);
        }

        return ans.next;
    }

    private static ListNode makeListReverseOrder(int value){
        ListNode head=new ListNode(value%10);
        ListNode tail=head;
        value=value/10;
        while(value>0){
            tail.next=new ListNode(value%10);
            value/=10;
            tail=tail.next;
        }

        return head;
    }

    private static int retrieveReverseOrder(ListNode head){
         int base=1;
         int ans=0;
         while(head!=null){
             ans=head.data*base+ans;
             base*=10;
             head=head.next;
         }

         return ans;
    }
    
}