package ctci.chapter3;

import java.util.*;
public class Solution3 {
    
    /*
        Can I use Java Stack api?
        Can I use any other built-in data structure? ArrayList?
        When popAt is called, should I refill it from the next stack?

    */

    private int capacity;
    private List<Stack<Integer>> stacks;
    private int size;

    public Solution3(int capacity){
        this.capacity=capacity;
        this.size=0;
        stacks=new ArrayList<>();
    }

    public int getSetSize(){
        return stacks.size();
    }

    public int size(){
        return size;
    }

    public void push(int i){
        if(getSetSize()==0){
            stacks.add(new Stack<>());
        }
        Stack<Integer> lastStack=stacks.get(stacks.size()-1);
        if(lastStack.size()==capacity){
            lastStack=new Stack<>();
            stacks.add(lastStack);
        }
        lastStack.push(i);
        size++;
    }

    public int pop(){
        return popAt(getSetSize()-1);
    }

    public int popAt(int index){
        if(getSetSize()<=index) throw new EmptyStackException();
        Stack<Integer> s=stacks.get(index);
        int val=s.pop();
        if(s.isEmpty()){
            stacks.remove(index);
        }
        size--;
        return val;
    }
}