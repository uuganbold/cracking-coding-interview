package ctci.chapter4;

public class Solution8 {
    /**
     * What if one of the nodes is the ancester of the other.
     * Does the node points to its parent node?
     */

     /*
        When nodes point to their parent?
     */
     public static TreeNode firstCommonAncestor(TreeNode t1, TreeNode t2){
          int h1=0,h2=0;
          TreeNode parent=t1;
          while(parent!=null){
              h1++;
              parent=parent.parent;
          }

          parent=t2;
          while(parent!=null){
              h2++;
              parent=parent.parent;
          }

          int minH=Math.min(h1,h2);
          int diff=h1-minH;
          for(int i=0;i<diff;i++){
              t1=t1.parent;
          }

          diff=h2-minH;
          for(int i=0;i<diff;i++){
              t2=t2.parent;
          }

          while(t1!=t2){
              t1=t1.parent;
              t2=t2.parent;
          }

          return t1;
     }


     private static class Result{
         TreeNode node;
         boolean isAncestor;

         public Result(TreeNode node, boolean isAncestor){
             this.node=node;
             this.isAncestor=isAncestor;
         }
     }
     public static TreeNode firstCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2){
           Result r=find(root,t1,t2);
           if(r.isAncestor){
               return r.node;
           }
           return null;
     }


     /*
     */
     private static Result find(TreeNode root, TreeNode t1, TreeNode t2){
            if(root==null){
                return new Result(null,false);
            }

            if(root==t1&&root==t2){
                return new Result(root, true);
            }
            
            Result rleft=find(root.left, t1, t2);
            if(rleft.isAncestor){
                return rleft;
            }

            Result rright=find(root.right,t1,t2);
            if(rright.isAncestor){
                return rright;
            }

            if(rleft.node!=null&&rright.node!=null){
                return new Result(root, true);
            }else if(root==t1 || root==t2){
                boolean isAncestor=rleft.node!=null||rright.node!=null;
                return new Result(root, isAncestor);
            }else {
                return new Result(rleft.node!=null?rleft.node:rright.node,false);
            }
     }
}