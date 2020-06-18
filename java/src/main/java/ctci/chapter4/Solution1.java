package ctci.chapter4;

import java.util.*;
public class Solution1 {

    /*
         Should I find a route from both nodes, or will you give me the source node?
         Which way should I represent the graph? adjacency list or adjacency matrix
         Should I return route or it is enough to return if there is route?
         Should I return all route between the nodes or any one node? 
    */

    private static class Node{
        int val;
        List<Node> adjacents;

        public Node(int val){
            this.val=val;
            adjacents=new ArrayList<>();
        }

        public void addEdge(Node node){
            adjacents.add(node);
        }
    }

    private static class GraphAL{
         Node[] nodes;

         /*
            Assuming vertices have different value.
         */
         public GraphAL(int n, int[][] edges){
              nodes=new Node[n];
              for(int i=0;i<n;i++){
                  nodes[i]=new Node(i);
              }

              for(int[] edge:edges){
                    Node node1=nodes[edge[0]];
                    node1.addEdge(nodes[edge[1]]);
              }
         }

         public Node dfsIterative(int destination, int source){
               Set<Node> visited=new HashSet<>();

               Node src=nodes[source];
               if(src.val==destination){
                   return src;
               }

               Stack<Node> stack=new Stack<>();
               visited.add(src);
               stack.push(src);

               while(!stack.isEmpty()){
                    Node node=stack.pop();
                    for(Node adjacent: node.adjacents){
                        if(!visited.contains(adjacent)){
                            if(adjacent.val==destination){
                                return adjacent;
                            }
                            stack.push(adjacent);
                            visited.add(adjacent);
                        }
                    }
               }

               return null;
         }

         public Node dfsRecurse(int destination, int source){
              Set<Node> visited=new HashSet<>();

              Node src=nodes[source];
              return dfsAux(src,destination, visited);
         }

         private Node dfsAux(Node source, int dest, Set<Node> visited){
                if(source==null){
                    return null;
                }

                for(Node adj: source.adjacents){
                    if(adj.val==dest){
                        return adj;
                    }
                }

                for(Node adjacent: source.adjacents){
                    if(!visited.contains(adjacent)){
                        visited.add(adjacent);
                         Node found=dfsAux(adjacent, dest, visited);
                         if(found!=null){
                             return found;
                         }
                    }
                }

                return null;   
         }


         public Node bfs(int source, int dest){
             Set<Node> visited=new HashSet<>();

             Node src=nodes[source];
             if(src.val==dest){
                 return src;
             }

             Queue<Node> queue=new LinkedList<>();
             queue.offer(src);
             visited.add(src);

             while(!queue.isEmpty()){
                 Node node=queue.poll();
                 for(Node adj:node.adjacents){
                     if(!visited.contains(adj)){
                         if(adj.val==dest){
                             return adj;
                         }
                         queue.offer(adj);
                         visited.add(adj);
                     }
                 }

             }

             return null;

         }
    }

    private static class GraphAM{
          int[][] adjacencyMat;

          public GraphAM(int n, int[][] edges){
              this.adjacencyMat=new int[n][n];
              for(int[] edge:edges){
                  this.adjacencyMat[edge[0]][edge[1]]=1;
              }
          }

          public int dfsIterative(int src, int dest){
                if(src==dest){
                    return src;
                }
                boolean[] visited=new boolean[adjacencyMat.length];

                Stack<Integer> stack=new Stack<>();
                stack.push(src);
                visited[src]=true;

                while(!stack.isEmpty()){
                    int node=stack.pop();
                    for(int adj: adjacencyMat[node]){
                        if(!visited[adj]){
                            if(adj==dest){
                                return adj;
                            }
                            stack.push(adj);
                            visited[adj]=true;
                        }
                    }
                }

                return -1;
          }

          public int dfsRecursive(int src, int dest){
              boolean[] visited=new boolean[adjacencyMat.length];
              return dfsAux(src,dest,visited);
          }

          private int dfsAux(int src, int dest, boolean[] visited){
               
               for(int adj: adjacencyMat[src]){
                   if(adj==dest){
                       return dest;
                   }
               }

               for(int adj: adjacencyMat[src]){
                    if(!visited[adj]){
                        visited[adj]=true;
                        int found=dfsAux(adj, dest, visited);
                        if(found!=-1){
                            return found;
                        }
                    }

               }

               return -1;
          }

    }

    
}