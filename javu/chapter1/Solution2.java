package javu.chapter1;
import java.util.*;

public class Solution2 {
    
    /*
        Unicode or Ascii?
        English letters or any character?
        Can contain capital letter?
        How long?
    */

    /*
        T: O(N)
        S: O(N)
    */
    public boolean isPermutation(String str, String other){
         if(str==null||other==null) return false;
         if(str.length()!=other.length()) return false;

         Map<Character,Integer> strCharMap=mapCharToCount(str);
         Map<Character,Integer> otherCharMap=mapCharToCount(other);

         for(char ch:strCharMap.keySet()){
             if(otherCharMap.get(ch)!=strCharMap.get(ch)){
                 return false;
             }
         }

         return true;
    }

    private Map<Character, Integer> mapCharToCount(String str){
        Map<Character, Integer> result=new HashMap<>();

        for(char ch:str.toCharArray()){
            result.put(ch,result.getOrDefault(ch,0)+1);
        }
        return result;
    }
}