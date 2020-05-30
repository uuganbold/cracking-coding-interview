package ctci.chapter1;

public class Solution4 {

    /*
        Unicode or Ascii
        English letters?
        What kinds or special characters? spaces, underscore, hyphen
        Should Special characters have pair?

    */

    /*
        T: O(N)
        S: O(1)
    */
    public static boolean isPalindromePermutation(String str){
         if(str==null||str.length()==0) return true;
         int[] charMap=new int[26];

         for(char ch:str.toCharArray()){
             if(Character.isLetter(ch)){
                charMap[Character.toLowerCase(ch)-'a']++;
             }       
         }

         boolean oddCount=false;
         for(int i=0;i<charMap.length;i++){
             if(charMap[i]%2==1) {
                 if(oddCount) return false;
                 oddCount=true;
             }
         }

         return true;

    }

    public static void main(String[] args){
        System.out.println(isPalindromePermutation("Tact Co a"));
        System.out.println(isPalindromePermutation(""));
        System.out.println(isPalindromePermutation("a"));
        System.out.println(isPalindromePermutation("ba"));
        System.out.println(isPalindromePermutation("ba b"));
    }
    
}