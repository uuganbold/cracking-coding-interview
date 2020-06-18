package ctci.chapter4;

public class Solution4 {
    
    private class TreeBalancy{
        int depth;
        boolean isBalanced;

        public TreeBalancy(int depth, boolean isBalanced){
            this.depth=depth;
            this.isBalanced=isBalanced;
        }
    }


    boolean isBalanced(TreeNode root){
         TreeBalancy balancy=isBalancedAux(root);
         return balancy.isBalanced;
    }

    private TreeBalancy isBalancedAux(TreeNode root){
        if(root==null){
            return new TreeBalancy(0,true);
        }

        TreeBalancy left=isBalancedAux(root.left);
        if(!left.isBalanced){
             return left;
        }

        TreeBalancy right=isBalancedAux(root.right);
        right.isBalanced=right.isBalanced&&left.isBalanced;
        right.depth=Math.max(left.depth,right.depth)+1;

        return right;

    }
}