package LearnJava;

public class EnumDemo {

    public static void main(String[] args){
      System.out.println(" Enumeration Example. \n-----------------------------");
      Month[] months = Month.values();
      for(Month month:months){
          System.out.println(month+" is month #"+month.ordinal() );
          /*System.out.println(month.compareTo(Month.January));*/
      }
    }

}

/*Enum */
enum Month{
    January, February, March, April,May,June,July, August, September, October, November,
    December;
    Month(){
        System.out.println("creating month enum constant (object)"+this.name());
    }
}

