package ctci.chapter3;

import java.util.*;
public class Solution4 {
    
    private Stack<Integer> head=new Stack<>();//
    private Stack<Integer> tail=new Stack<>();//3
    private Integer front=null;

    public void offer(Integer val){
         if(tail.isEmpty()){
             front=val;
         }
         tail.push(val);
    }

    public Integer peek(){
        if(head.isEmpty()) return front;
        else return head.peek();
    }

    public Integer poll(){
        if(head.isEmpty()){
            while(!tail.isEmpty()){
                head.push(tail.pop());
            }
            front=null;
        }
        return head.pop();
    }

    public int size(){
        return head.size()+tail.size();
    }

    public boolean isEmpty(){
        return head.isEmpty()&&tail.isEmpty();
    }
}