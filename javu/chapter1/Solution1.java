package javu.chapter1;
import java.util.*;
public class Solution1{
    
    /*
        Is the string contains ascii chars or unicode chars?
        How long is the string?
        It can contain capital character if it contains only english letters?
    */
    /*
        T: O(N)
        S: O(N)
    */
    public boolean isUnique(String s){
        if(s==null||s.length()==0) return true;
        Set<Character> charSet=new HashSet<>();
        for(char ch:s.toCharArray()){
            if(charSet.contains(ch)) return false;
            charSet.add(ch);
        }
        return true;
    }


    /*
        T: O(N^2)
        S: O(1)
    */
    public boolean isUniqueSpaceEfficient(String s){
        if(s==null||s.length()==0) return true;

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)) return false;
            }
        }

        return true;
    }
}