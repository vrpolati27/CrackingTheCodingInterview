package LearnJava;

public class PassByValNRefDemo {

      public static void main(String[] args){
          int[] c1 = {13};
          System.out.println("initial Value:"+c1[0]);
          fun1(c1);
          System.out.println("after Function call,"+c1[0]);
      }

      private static void fun1(int[] c1){
          c1[0] = c1[0]+12;
          System.out.println("inside Function,"+c1[0]);
      }
}
