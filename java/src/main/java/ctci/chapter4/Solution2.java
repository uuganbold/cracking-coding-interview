package ctci.chapter4;

public class Solution2 {
    
    /*
        Unique elements?
        How shoult it handle duplicated elements?
    */
    public TreeNode makeBST(int[] sorted){
        return makeBSt(sorted, 0, sorted.length);
    }

    private TreeNode makeBSt(int[] sorted, int low, int high){
        if(low>=high){
            return null;
        }
        int mid=low+(high-low)/2;
        TreeNode ans=new TreeNode(mid);
        ans.left=makeBSt(sorted, low, mid);
        ans.right=makeBSt(sorted, mid, high);

        return ans;
    }
}