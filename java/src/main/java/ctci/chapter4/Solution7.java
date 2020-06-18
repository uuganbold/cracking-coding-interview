package ctci.chapter4;

import java.util.ArrayList;
import java.util.*;
public class Solution7 {
     
      /*
        Can I project name as 0-n number values?
      */

      /*
           0,1,2,3,4,5
           [[0,3],[5,1],[1,3],[5,0],[3,2],[2,0]]
            0 - 3
            1 - 3
            2 - 0
            3 - 2
            4 -
            5 - 1,0
            [1,0,1,1,0,0]
            q: 
            P: 4, 5, 1
      */
      public int[] buildOrder(int n, int[][] dependency){
            int ans[]=new int[n];
            int k=0;

            int[] deps=new int[n];

            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] dep:dependency){
                adj.get(dep[0]).add(dep[1]);
                deps[dep[1]]++;
            }

            Queue<Integer> queue=new LinkedList<>();
            for(int i=0;i<n;i++){
                if(deps[i]==0){
                    queue.offer(i);
                }
            }

            while(!queue.isEmpty()){
                int node=queue.poll();
                ans[k++]=node;
                for(int neighbor:adj.get(node)){
                    deps[neighbor]--;
                    if(deps[neighbor]==0){
                        queue.offer(neighbor);
                    }
                }
            }

            if(k==n){
                return ans;
            }else{
                return null;
            }
      }
}