package practice;

import java.util.*;

public class LetsPlayAGame {

    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String str = sc.next();
       int[] array = new int[n];
       for(int i=0;i<n;i++){
           array[i] = sc.nextInt();
       }
       System.out.println(maxScore(str,array));
       sc.close();
    }

    private static int maxScore(String str, int[] array){
       int maxScore = 0;
       Pair[] _arr = new Pair[array.length];
       for(int c1=0;c1<str.length();c1++){
           char ch = str.charAt(c1);
           int value = array[c1];
           Pair pair = new Pair(ch,value);
           _arr[c1] = pair;
       }
        Arrays.sort(_arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return new Integer(o1.value).compareTo(o2.value);
            }
        });
        for(Pair c:_arr){
            System.out.print(c.value+" "+c.color+"/ ");
        } System.out.println();
        /* Define rules*/
        Map<Character,char[]> rules = new HashMap<>(4);
        char[] c1 = {'G','W'};
        char[] c2 = {'R','B'};
        rules.put('R', c1);
        rules.put('G', c2);
        rules.put('B', c1);
        rules.put('W', c2);
        int[] maxScoresSoFar = new int[_arr.length];
        maxScoresSoFar[0] = 1;
        maxScore = 1;
        for(int c=1;c<_arr.length;c++){
            maxScoresSoFar[c] = 1;
            for(int c3=0;c3<c;c3++){
               char[] mn1 = rules.get(_arr[c].color);
               if((_arr[c3].color == mn1[0] || _arr[c3].color == mn1[1]) &&
                       _arr[c3].value < _arr[c].value ){
                   maxScoresSoFar[c] = Math.max(maxScoresSoFar[c], 1+maxScoresSoFar[c3]);
               }
            }
            maxScore = Math.max(maxScore,maxScoresSoFar[c]);
        }
       return maxScore;
    }
}

class Pair{
    char color;
    int value;

    public Pair(char ch, int value){
        this.color = ch;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return new Integer(value).hashCode();
    }
}
