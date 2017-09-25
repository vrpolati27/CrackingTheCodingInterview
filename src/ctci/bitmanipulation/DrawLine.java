package ctci.bitmanipulation;

import java.util.Arrays;

public class DrawLine {

    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(setBits(4,12)));
        byte[] screen = new byte[4*32];
        int width = 32;
        /*for(int c1=0;c1<screen.length;c1++){
            screen[c1] = (byte)(Math.random()*128);
        }
        printScreen(screen,width);*/
        System.out.print(Integer.toBinaryString(Integer.MAX_VALUE));
        drawLine(screen,width,17,23,8);
    }

    /* Draw a HorizontalLine from (x1,y) to (x2,y) of given width.
    * 0<= (x1,x2) < width.*/
    private static void drawLine(byte[] screen,int width,int x1,int x2,int y){
       int screenHeight = screen.length/(width/8); /* 0<=y<screenHeight */
       int height = (screenHeight-y);
       int reqBytesStartIndex = 4*height;
       StringBuilder sb = new StringBuilder();
       for(int c1=0;c1<width;c1++){
           if((c1%8)==0) sb.append("0");
           else if((c1>=x1) && (c1<=x2)) sb.append("1");
           else sb.append("0");
       }
       String line = sb.toString();
       for(int c=0;c<(width/8);c++){
           screen[reqBytesStartIndex+c] = Byte.parseByte(line.substring(8*c,8*(c+1)),2);
       }
       printScreen(screen,width);
    }

    /* returns a number whose binary representation is
    * of the form 000000111111000000
    * setBits(4,12) = 000000000000000000001111111110000. */
    private static int setBits(int from,int to){
         int m1 = (~0)<<from;
         int m2 = ~((~0)<<(to+1));
         return (m1 & m2);
    }

    private static void printScreen(byte[] screen,int width){
      int _width2 = width/8;
      for(int c1=0;c1<(screen.length/_width2);c1++){
         for(int c3=0;c3<_width2;c3++){
             byte c4 = screen[4*c1+c3];
             for(int c=0;c<8;c++){
                 int bit = ((1<<c)&c4)>0?1:0;
                 if(bit==1) System.out.print(".");
                 else System.out.print(" ");
             }
         } System.out.println();
      }
    }
}
