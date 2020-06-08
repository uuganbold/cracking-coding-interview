package ctci.chapter3;
import java.util.*;
public class Solution5 {
    
      /*
            T: O(N^2)
            S: O(N)
      */
      public void sort(Stack<Integer> stack){
          
            Stack<Integer> sorted=new Stack<>();
            
            while(!stack.isEmpty()){
                  int temp=stack.pop();
                  while(!sorted.isEmpty()&&sorted.peek()<temp){
                        stack.push(sorted.pop());
                  }
                  sorted.push(temp);             
            }

            while(!sorted.isEmpty()){
                  stack.push(sorted.pop());
            }
      }
}