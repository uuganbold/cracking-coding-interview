package ctci.chapter1;

public class Solution3 {
    
    /*
        Is the aditional space just enough or may be more than enough?
        Should I align from the begining?
    */
    /*
        T: O(N)
        S: O(1)

        [mongol%20uls                               ], 10

        [mongol%20uls            ]  n^2

        [           mongol%20uls]
        [mongol%20ulsongol%20uls]

    */
    public static void urlify(char[] original, int length){
        
        int toPoint=original.length-1;
        for(int i=length-1;i>=0;i--){
            if(original[i]==' '){
                original[toPoint--]='0';
                original[toPoint--]='2';
                original[toPoint--]='%';
            }else{
                original[toPoint--]=original[i];
            }
        }
        int alignPoint=0;
        for(int i=toPoint+1;i<original.length;i++){
            original[alignPoint++]=original[i];
            original[i]=' ';
        }

        /*
            !!!! forgot this part
        */
        for(int i=alignPoint;i<original.length;i++){
            original[i]=' ';
        }
        
    }


    public static void main(String[] args){
        String str="Mr John Smith";
        char[] original=new char[str.length()*3];
        for(int i=0;i<str.length();i++){
            original[i]=str.charAt(i);
        }
        System.out.println(str+","+str.length());
        urlify(original,str.length());
        System.out.println(new String(original));
    }

}