package practice;

import java.util.Arrays;
import java.util.Stack;

public class CodilityR2 {

    public static void main(String[] args){
       String str = "AAABBBBBKJHDKCJSOISDJDFDHKJHDE3KJHDCKSDJHK";
       System.out.println(maxSubstringLength(str));
       //Scanner sc = new Scanner(System.in);
       int[][] map = { {5,4,4},{4,3,4},{3,2,4},{2,2,2},{3,3,4},{1,4,4},{4,1,1}};
       /*for(int row=0;row<map.length;row++){
           for(int col=0;col<map[row].length;col++){
               map[row][col]= sc.nextInt();
           }
       }*/
       //sc.close();
       System.out.println(numberOfCountries(map));

    }

    private static int maxSubstringLength(String str){
        int maxLength = 0;
        int length = 0;
        boolean isValid = false;
        for(int c1=0;c1<str.length();c1++){
            char ch = str.charAt(c1);
            if(Character.isDigit(ch)){
                if(isValid) maxLength = Math.max(maxLength,length);
                length = 0;
                isValid = false;
            }else{
                if(ch>='A' && ch<='Z') isValid = true;
                length++;
            }

        }
        if(isValid) maxLength = Math.max(maxLength,length);
        return maxLength==0?-1:maxLength;
    }

    private static int numberOfCountries(int[][] matrix){
        IntWrap countriesCount = new IntWrap();
        Boolean[][] travel = new Boolean[matrix.length][];
        for(int row=0;row<matrix.length;row++){
            travel[row] = new Boolean[matrix[row].length];
            Arrays.fill(travel[row],false);
        }

        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
               explore(row,col,matrix,travel,countriesCount);
            }
        }
        return countriesCount.c;
    }

    private static void explore(int row,int col, int[][] matrix, Boolean[][] travel,
                                IntWrap countriesCount){
        if(!travel[row][col]){
           countriesCount.c++;
           Grid cur = new Grid(row,col);
           cur.value = matrix[cur.row][cur.col];
           Stack<Grid> stack = new Stack<>();
           stack.push(cur);
           while(!stack.empty()){
               Grid c = stack.pop();
               if(travel[c.row][c.col]) break;
               travel[c.row][c.col] = true;
               /* right grid*/
               Grid right = c.right();
               if(right.col>=0 && right.col<matrix[row].length){
                   right.value = matrix[right.row][right.col];
                   if(c.value==right.value && !travel[right.row][right.col]){
                       stack.push(right);
                   }
               }
               /* left Grid*/
               Grid left = c.left();
               if(left.col>=0 && left.col<matrix[row].length){
                   left.value = matrix[left.row][left.col];
                   if(c.value==left.value && !travel[left.row][left.col]){
                       stack.push(left);
                   }
               }
               /* top Grid*/
               Grid top = c.top();
               if(top.row>=0 && top.row<matrix.length &&
                       top.col>=0 && top.col<matrix[top.row].length){
                   top.value = matrix[top.row][top.col];
                   if(c.value==top.value && !travel[top.row][top.col]){
                       stack.push(top);
                   }
               }
               /* bottom Grid*/
               Grid bottom = c.bottom();
               if(bottom.row>=0 && bottom.row<matrix.length &&
                       bottom.col>=0 && bottom.col<matrix[bottom.row].length){
                   bottom.value = matrix[bottom.row][bottom.col];
                   if(c.value==bottom.value && !travel[bottom.row][bottom.col]){
                       stack.push(bottom);
                   }
               }
           }
        }
    }

}

class Grid{
    public int row;
    public int col;
    public int value;
    public Grid(int row,int col){
        this.row = row;
        this.col = col;
    }
    public Grid right(){
        return new Grid(this.row,this.col+1);
    }
    public Grid left(){
        return new Grid(this.row,this.col-1);
    }

    public Grid top(){
        return new Grid(this.row-1,this.col);
    }

    public Grid bottom(){
        return new Grid(this.row+1,this.col);
    }
}

class IntWrap{
    public int c;
}
