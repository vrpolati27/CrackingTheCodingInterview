package practice.HackerRankMoodyAnalyticsContest;

/*
source: https://www.hackerrank.com/contests/moodys-analytics-fall-university-codesprint/challenges/stock-purchase-day/problem
*/
import java.util.*;

public class StockPurchaseDay {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int[] stockCosts = new int[days];
        Map<Integer,List<Integer>> _map = new HashMap<>(days);
        for(int c=0;c<days;c++){
            int stockCost = sc.nextInt();
            List<Integer> list = _map.getOrDefault(stockCost,new ArrayList<>());
            list.add(c+1);
            _map.put(stockCost,list);
        }
        int queriesCount = sc.nextInt();
        int[] queries = new int[queriesCount];
        for(int m1=0;m1<queries.length;m1++){
            queries[m1] = sc.nextInt();
        }
        for(int qi:queries){
            System.out.println(lastPossibleDay(_map,qi));
        }
        sc.close();
    }

    private static int lastPossibleDay(Map<Integer,List<Integer>> _map, int qi){
      int result = -1;
      for(Map.Entry<Integer,List<Integer>> en:_map.entrySet()){
          if(en.getKey()<=qi){
              result = Math.max(result,en.getValue().get(en.getValue().size()-1));
          }
      }
      return result;
    }

    private static int lastPossibleDay2(int[] stockCosts, int xi, int minPrice){
     int result = -1;

     return result;
    }

}
