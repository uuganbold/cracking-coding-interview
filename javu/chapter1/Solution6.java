package javu.chapter1;

public class Solution6 {
    
    /*
        Does the string contain numerical character?

    */
    /*
        T: O(N)
        S: O(N)
    */
    public static String compress(String str){
        if(str==null||str.length()==0) return str;

        StringBuilder builder=new StringBuilder();

        char current=str.charAt(0);

        builder.append(current);

        int count=0;
        for(char ch:str.toCharArray()){
            if(ch!=current){
                builder.append(count);
                current=ch;
                builder.append(current);
                count=1;
            }else{
                count++;
            }
        }
        //forgot this line
        builder.append(count);

        if(builder.length()>=str.length()) return str;
        else return builder.toString();
    }

    public static void main(String[] args){
        System.out.println(compress("a"));
        System.out.println(compress("aa"));
        System.out.println(compress("aabcccccaaa"));
    }
}