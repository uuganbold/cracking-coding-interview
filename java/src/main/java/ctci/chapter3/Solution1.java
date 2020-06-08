package ctci.chapter3;

import java.util.EmptyStackException;

public class Solution1 {

    /*
        Should the stacks have the same capacity?
        Should push and pop run in constant time?
        is it fixed-size or not?

    */
    
    public static class SingleStack{
        private int[] memory;
        private int last;
        
        public SingleStack(int capacity){
            memory=new int[capacity];
            last=0;
        }

        public boolean isEmpty(){
            return size()==0;
        }

        public void push(int i){
            if(last>=memory.length) throw new StackOverflowError();
            memory[last++]=i;
        }

        public int pop(){
            if(size()==0) throw new EmptyStackException();
            last--;
            return memory[last];
        }

        public int peek(){
            if(size()==0) throw new EmptyStackException();
            return memory[last-1];
        }

        public int size(){
            return last;
        }

    }

    public static class ThreeStack{
        int[] memory;
        private int[] pointers;
        
        public ThreeStack(int capacity){
             memory=new int[capacity];
        }

        public boolean isEmpty(int stackId){
            return false;
        }

        public void push(int stackId, int i){

        }

        public int pop(int stackId){
            return 0;
        }

        public int peek(int stackId){
            return 0;
        }

        public int size(int stackId){
            return 0;
        }

    }
}