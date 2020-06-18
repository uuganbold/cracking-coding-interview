package ctci.chapter4;

import java.util.*;
public class Solution3 {
    
     public List<ListNode> listOfDepths(TreeNode root){
         if( root==null){
             return null;
         }

         List<ListNode> ans=new ArrayList<>();

          Queue<TreeNode> queue=new LinkedList<>();
          queue.offer(root);
          while(!queue.isEmpty()){
                Queue<TreeNode> temp=new LinkedList<>();
                ListNode head=new ListNode();
                ListNode curr=head;
                while(!queue.isEmpty()){
                    TreeNode node=queue.poll();
                    curr.next=new ListNode(node.val);
                    curr=curr.next;
                    if(node.left!=null){
                        temp.offer(node.left);
                    }
                    if(node.right!=null){
                        temp.offer(node.right);
                    }
                }
                ans.add(head.next);
                queue=temp;
          }

          return ans;
     }
}