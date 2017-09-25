package practice;


/* University Grad 2018. (Twitter)
   this is a HackerRank test.*/
public class TwitterR1 {

    public static void main(String[] args){
      /*System.out.println(decrypt('w',6 ));
      System.out.println(new Boolean(true).equals(new Boolean(true)));
      System.out.println(encrypt("w",6));*/
      String message = new String("This is the original message that Alice wants to send to Bob");
      int key = /*999999999;*/(int)(Math.random()*Integer.MAX_VALUE+1); /* key = (0,Integer.maxvalue]*/
      System.out.println("original message :"+message);
      System.out.println("secret key :"+key);
      String encryptedMessage = encrypt(message,key);
      System.out.println("Encrypted message :"+ encryptedMessage);
      String decryptedMessage = decrypt(encryptedMessage,key);
        System.out.println("Decrypted message :"+decryptedMessage);
      System.out.println("------------------------------------------------");
      System.out.println("maxLength("+message+") :"+maxLength(message,12));
        System.out.println("maxLength("+message+") :"+maxLength2(message,12));
    }

    /* Q1[Orders 1] is a Database question,
       You are given Orders table, query the CustomerNumber from Orders who has placed largest
       number of orders.

       Orders
       ----------
       OrderNumber | OrderDate | RequiredDate | ShippedDate | Status | Comments | CustomerNumber
        (int)         (date)      (date)         (date)       char(15)  char(200)  int

       SQL Server Query:
       -------------------
        SELECT TOP 1 CustomerNumber
          From Orders
          GROUP BY CustomerNumber
          ORDER BY COUNT(CustomerNumber) DESC;
     */

    /* Q2. HackingTime
    *  original message: Hi, this is an example
    *  key: 4071321
    *  Encrypted messaged: Li, ailu jw au facntll
      H+4=L
      i+0=i
      t+7=a...
      [ a b c d e f g h i j k l m n o p q r s t u v w x y z]
      1. You have to find key
      2. (Decrypt) convert given encrypted message to original message.*/

    /* This method returns an Decrypted message for a given Encrypted message and a Key.
    * T(n)=O(n). */
    private static String decrypt(String encryptedMsg, int key){
        StringBuilder decryptedMsg = new StringBuilder();
        int index = 0;
        String _key = Integer.toString(key);
        int keyLength = _key.length();
        for(int c1=0;c1<encryptedMsg.length();c1++){
            char ch = encryptedMsg.charAt(c1);
            if(Character.isLetter(ch))
                decryptedMsg.append(decrypt(ch,
                        Character.getNumericValue(_key.charAt(index++%keyLength))));
            else decryptedMsg.append(ch);
        }
        return decryptedMsg.toString();
    }

    /* given character is rotated back #digit letters. */
    private static char decrypt(char ch,int digit){
      Boolean isCapital = ch<97?true:false;
      int d = ch-digit;
      if((isCapital&&Character.isUpperCase(d)) ||
              ((!isCapital)&&Character.isLowerCase(d)))
          return (char)d;
      else{
          char lastLetter = isCapital?'Z':'z';
          int diff = isCapital?'A'-d:'a'-d;
          return (char)(lastLetter+1-diff);
      }
    }

    /* This method Encrypts given message using the key*/
    private static String encrypt(String originalMsg, int key){
        StringBuilder decryptedMsg = new StringBuilder();
        int index = 0;
        String _key = Integer.toString(key);
        int keyLength = _key.length();
        for(int c1=0;c1<originalMsg.length();c1++){
            char ch = originalMsg.charAt(c1);
            if(Character.isLetter(ch)){
              /* rotate character forward by few steps.*/
               int k = Character.getNumericValue(_key.charAt(index++%keyLength));
               char c = (char)(ch+k);
               if( (Character.isUpperCase(ch)&&Character.isUpperCase(c)) ||
                       (Character.isLowerCase(ch)&&Character.isLowerCase(c))){
                   decryptedMsg.append(c);
               }else{
                   int _d= Character.isUpperCase(ch)?'A'+(c-'Z')-1:'a'+(c-'z')-1;
                   decryptedMsg.append((char)_d);
               }
            }else decryptedMsg.append(ch);
        }
        return  decryptedMsg.toString();
    }


    /* Q3. Longest phrases in a Tweet.
    * Tweet: I am Bob
    * phrases in tweet: [I],[am],[Bob],[I am],[am Bob],[I am Bob]
    * server can only process limited phrases, there is a limit on chars it can process.
    * if k=3, phrases with fewer or 3 characters are {[I],[am],[Bob],[I am]}
     longest phrase is [I am], which contains 2 words.
     write a function to return the length of a longest subarray having sum <= k. .

     T(n)=O(n^2). */
    private static int maxLength(String tweet, int k){
        String[] tokens = tweet.split(" ");
        int[] tokensLength = new int[tokens.length];
        /* I am Bob is converted as array: [1,2,3]*/
        for(int c1=0;c1<tokens.length;c1++){
            tokensLength[c1]= tokens[c1].length();
        }
        int maxLength = 0;
        int length = 0;
        for(int i=0;i<tokens.length;i++){
            int sum = tokensLength[i];
            length = 0;
            if(sum<=k) length++;
            for(int j=i+1;j<tokens.length;j++){
                sum += tokensLength[j];
                if(sum<=k) length++;
                else break;
            } maxLength = Math.max(maxLength,length);
        } maxLength = Math.max(maxLength,length);
        return maxLength;
    }

    /* Q3. method2
    * it's still O(n^2) but works better(or equally) than method1 in almost all cases.*/
    private static int maxLength2(String tweet, int k){
        int maxLength = 0;
        String[] tokens = tweet.split(" ");
        int[] phraseLengths = new int[tokens.length];
        int sum = 0;
        for(int c1=0;c1<tokens.length;c1++){
            phraseLengths[c1] = tokens[c1].length();
            sum += phraseLengths[c1];
        }
        maxLength = maxLength(phraseLengths,0,phraseLengths.length-1,sum,k);
        return maxLength;
    }

    private static int maxLength(int[] phraseLengths,int startIndex,int endIndex, int sum, int k){
        if(sum<=k) return (endIndex-startIndex+1);
        else if(startIndex==endIndex){
            return -1;
        }else{
            int sumLeft = sum-phraseLengths[endIndex];
            int sumRight = sum-phraseLengths[startIndex];
            if(sumLeft<=k || sumRight<=k) return (endIndex-startIndex);
            else{
                return Math.max(maxLength(phraseLengths,startIndex,endIndex-1,sumLeft,k),
                        maxLength(phraseLengths,startIndex+1,endIndex,sumRight,k));
            }
        }
    }

}
