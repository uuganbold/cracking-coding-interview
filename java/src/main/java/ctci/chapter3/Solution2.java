package ctci.chapter3;

import java.util.EmptyStackException;

public class Solution2 {
    
    private class Node{
        int val;
        int min;
        Node prev;

        public Node(int val, int min, Node prev){
            this.val=val;
            this.min=min;
            this.prev=prev;
        }
    }

    private Node base;
    public void push(int val){
         int min=val;
         if(base!=null){
             min=Math.min(min,base.min);
         }
         Node n=new Node(val,min,base);
         base=n;
    }

    public int pop(){
        if(base==null){
            throw new EmptyStackException();
        }
        int val=base.val;
        base=base.prev;
        return val;
    }

    public int min(){
        if(base==null){
            throw new EmptyStackException();
        }
        return base.min;
    }
}