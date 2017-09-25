package ctci.ArraysNstrings;

public class StringCompression {
    public static void main(String[] args){
       String str = "aabcccccaaa";/*a2b1c5a3*/
       System.out.println("compress("+str+"):"+compress(str));
       str = "abadFmnpFgdaf";/* abadFmnpFgdaf*/
        System.out.println("compress("+str+"):"+compress(str));
    }

    /* This method returns a compressed string that represents count of repeated characters,
    * T(n)=O(n), Linear and
    * space complexity = O(n) where n is length of a string.*/
    private static String compress(String s1){
        boolean isOriginal = true;
        StringBuilder compressedString = new StringBuilder();
        char prevChar = s1.charAt(0); int length = 1;
        for(int c1=1;c1<s1.length();c1++){
           char ch = s1.charAt(c1);
           if(ch!=prevChar){
               compressedString.append(prevChar);
               compressedString.append(length);
               if(length>1) isOriginal = false;
               prevChar = ch; length = 1;
           }else length++;
        }
        compressedString.append(prevChar);
        compressedString.append(length); if(length>1) isOriginal = false;
        if(isOriginal) return s1;
        else return compressedString.toString();
    }
}
