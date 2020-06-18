package ctci.chapter4;

public class Solution5 {
    
    boolean ans=true;

    public boolean isBST(TreeNode root){
          isBSTAux(root);
          return ans;
    }

    private int[] isBSTAux(TreeNode root){
        int[] result=new int[]{root.val, root.val};
        if(!ans){
            return result;
        }

        if(root.left!=null){
            int[] left=isBSTAux(root.left);
            if(left[1]>root.val){
                ans=false;
                return result;
            }
            result[0]=left[0];
        }

        if(root.right!=null){
            int[] right=isBSTAux(root.right);
            if(right[0]<root.val){
                ans=false;
                return result;
            }
            result[1]=right[1];
        }
        return result;
    }
}