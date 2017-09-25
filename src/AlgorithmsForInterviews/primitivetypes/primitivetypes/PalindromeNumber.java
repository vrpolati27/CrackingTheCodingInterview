package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class PalindromeNumber {
    public static void main(String[] args){
        int c1 = Integer.parseInt("2345432");
        System.out.println(c1+" is palindrome:"+isPalindrome(c1));
        System.out.println(c1+" is palindrome:"+isPalindrome2(c1));
    }

    /* This method returns true if given number is palindrome.
     does this by calculating reverse and comparing it with original number.
     T(n)=O(n). */
    private static boolean isPalindrome2(int x){
        return ReverseDigits.reverse(x)==x;
    }

    /* returns true if the given number is Palindrome.
       T(n)=O(n), linear time.*/
    private static boolean isPalindrome(int x){
        if(x<=0) return x==0;
        boolean isPalindrome = true;
        int length = Integer.toString(x).length()-1;
        while(x>9){
            int leastSignificantDigit = x%10;
            int mostSignificantDigit =(int)(x/Math.pow(10,length));
            if(leastSignificantDigit!=mostSignificantDigit){
                isPalindrome = false;
                break;
            }
            x = (int)(x%Math.pow(10,length));
            x = x/10;
            length = length-2;
        }
        return isPalindrome;
    }
}
