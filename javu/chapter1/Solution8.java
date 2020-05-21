package javu.chapter1;

public class Solution8 {
    
    /*
        Is it square matrix?
        How big? - if it is smaller than 32 we can use integer to map.
    */
    /*
        T: O(N*M)
        S: O(N+M)
    */
    public static void zerofy(int[][] mat){
        boolean[] row=new boolean[mat.length];
        boolean[] col=new boolean[mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0) {row[i]=true; col[j]=true;}
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(row[i]||col[j]) mat[i][j]=0;
            }
        }
    }

    /*
        T: O(N*M)
        S: O(1)
    */
    public static void zerofySmaller(int[][] mat){
        int row=0;
        int col=0;

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0) {row|=1<<i; col|=1<<j;}
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if((row&1<<i)>0||(col&1<<j)>0) mat[i][j]=0;
            }
        }
    }
}