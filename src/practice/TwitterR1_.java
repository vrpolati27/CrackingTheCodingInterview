package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterR1_ {

    public static void main(String[] args){

    }

    /* Q1. Binary Tree Nodes
    * source: https://www.hackerrank.com/challenges/binary-search-tree-1/problem
    * Table: Tree
    *  Id (Integer)
    *  P_Id(Integer)
    *
    *  SELECT c1.Id AS NodeId, Case
    *                           When c1.Id IS NULL Then 'Root'
    *                           When c2.Id IS NULL Then 'Leaf'
    *                           Else 'Inner'
    *                           End AS NodeType
    *    FROM Tree c1 LEFT OUTER JOIN Tree c2
    *    on c1.Id = c2.P_Id
    *    Order By NodeId */

    public static List<Integer> recommendedTweets(int[][] followGraphEdges,int[][] likesGraph,
                                                  int targetUser, int minLikesThreshold){
        List<Integer> _recommended = new ArrayList<>();
        Map<Integer,Integer> followers = new HashMap<>();
        for(int[] followEdge: followGraphEdges){
            if(followEdge[0] == targetUser){
                followers.put(followEdge[1],1);
            }
        }


        for(int[] likeEdge:likesGraph){
            boolean isRecommendedTweet = followers.getOrDefault(likeEdge[0],0)
                    ==1 ? true:false;

        }
        return _recommended;
    }

}
