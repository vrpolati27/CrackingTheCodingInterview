package practice;

public class BottleCap {
    public static void main(String[] args){
       int n = 6; /* money bob has.*/
       int b = 2; /* cost of each bottle.*/
       int m = 2; /* trade off between caps n bottles,
                     You get 1 bottle n exchange for 2 bottle caps.*/
       System.out.println("Total number of bottles possible:"+bottlesCount(n,b,m));

    }

    private static int bottlesCount(int n,int b,int m){
        int bottlesCount = 0;
        bottlesCount += (n/b);
        bottlesCount += bottlesCount((n/b),m);
        return bottlesCount;
    }

    /* returns number of bottles we can get if we have 'c1' initial bottle caps n
    Trade off between bottles n bottle caps is m.*/
    private static int bottlesCount(int c1,int m){
        if(m>c1) return 0;
        else return (c1/m)+ bottlesCount(((c1/m)+(c1%m)),m);
    }
    
}
