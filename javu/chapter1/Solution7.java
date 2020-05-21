package javu.chapter1;
import java.util.Arrays;
public class Solution7 {
    
    /*
        
    */

    /*
        T: O(N^2)
        S: O(N^2)
    */
    public static int[][] rotate(int[][] mat){
        
        int N=mat.length;
        int[][] newMat=new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                newMat[j][N-i-1]=mat[i][j];
            }
        }

        return newMat;

    }


    /*
        T: O(N^2)
        S: O(1)
    */
    public static void rotateInPlace(int[][] mat){
        int N=mat.length;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        for(int i=0;i<N;i++){
            int[] row=mat[i];
            int left=0, right=row.length-1;
            while(left<right){
                int temp=row[left];
                row[left]=row[right];
                row[right]=temp;
                left++;
                right--;
            }
        }

    }

    public static void main(String[] args){
        int[][] mat={
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };

        print2D(rotate(mat));

        rotateInPlace(mat);

        print2D(mat);

    }

    private static void print2D(int[][] mat){
        for(int[] row:mat){
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\n\n");
    }
}