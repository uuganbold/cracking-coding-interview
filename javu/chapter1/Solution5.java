package javu.chapter1;

public class Solution5 {
    
    /*
        How long?

    */

    /*
        T: O(N)
        S: O(1)
    */
    public static boolean oneAway(String str1, String str2){
        if(str1==null||str2==null) throw new IllegalArgumentException();
        if(Math.abs(str1.length()-str2.length())>=2) return false;

        if(str1.length()<str2.length()){
            String temp=str1;
            str1=str2;
            str2=temp;
        }

        int start=0;
        int end1=str1.length()-1;
        int end2=str2.length()-1;

        while(start<str1.length()&&
            start<str2.length()&&
            str1.charAt(start)==str2.charAt(start)){
                start++;
        }

        while(end1>=0&&end2>=0&&str1.charAt(end1)==str2.charAt(end2)){
            end1--;
            end2--;
        }

        return start==end1;
    }

    public static void main(String[] args){
        System.out.println(oneAway("pale", "peele"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "bake"));
    }
}