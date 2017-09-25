package ctci.ArraysNstrings;

public class URLify {

    public static void main(String[] args){
        char[] c1 = new char[]{'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        System.out.println("urLify("+new String(c1)+",13): "+new String(urLify(c1,13)));
    }

    /* This method replaces all spaces in a string with '%20'.
    * urLify("Mr John Smith    ",13) returns "Mr%20John%20Smith". */
    private static char[] urLify(char[] c1,int len){
       int lastIndex = c1.length-1;
       int curPos = len-1;
       while(curPos>=0){
           if(c1[curPos]==' '){
               c1[lastIndex]='0';
               c1[lastIndex-1]='2';
               c1[lastIndex-2]='%';
               lastIndex = lastIndex-3;
           }else c1[lastIndex--]= c1[curPos];
           curPos = curPos-1;
       }
       return c1;
    }
}
