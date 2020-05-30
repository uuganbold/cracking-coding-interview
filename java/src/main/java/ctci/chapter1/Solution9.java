package ctci.chapter1;

public class Solution9 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public static boolean isRotation(String str, String str2){
         String newStr=str+str;
         return newStr.indexOf(str2)>=0;
    }

    public static void main(String[] args){
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}