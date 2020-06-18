package ctci.chapter4;

public class Solution6 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }

    public TreeNode successor(TreeNode node){
         TreeNode ans;
         if(node.right!=null){
             ans=node.right;
             while(ans.left!=null){
                 ans=ans.left;
             }
         }else{
             ans=node;
             while(ans.parent!=null&&ans.parent.right==ans){
                 ans=ans.parent;
             }
             ans=ans.parent;
         }

         return ans;
    }
    
}