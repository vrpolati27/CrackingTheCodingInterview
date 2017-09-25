package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrChronoR1 {

    public static void main(String[] args){
        String message = "ab1ca2bdf348hedfszz3243dxfdxga676c2331fgfyeaeew";
        System.out.println("encrypy("+message+") :"+encrypt(message));
        addChars('d','f');
        addChars('t','l');
        addChars('z','z');
        addChars('m','f');
        /* question2 */
        int[] array1 = {3,2,1,14,25};
        int[] array2 = {1,2,3,14,25};
        System.out.println("last index of most Frequent entry is :"+mostFrequent(array2,array1));
        System.out.println("------------------------------------------------------");

        /*Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher("polati,vinay reddy");
        while(m.find()) System.out.println(m.group+"."+m.end());*/
        duplicateNames();
        /*List<String> nameFormats = new ArrayList<>();
        nameFormats.add("vinay");
        nameFormats.add("polati,vinay reddy");
        System.out.println(getUniqueName(nameFormats));*/
    }

    /* q1. string Encryption: given a AlphaNumberic string
    * 1. remove digits
    * 2. remove duplicate characters (keep only first instance)
    * 3. add adjacent characters*/
    private static String encrypt(String message){
        StringBuilder encryptedMsg = new StringBuilder();
        boolean[] isPresent = new boolean[26];
        Arrays.fill(isPresent,false);
        for(int c=0;c<message.length();c++){
          char ch = message.charAt(c);
          if(Character.isLetter(ch) && !isPresent[ch-'a']){
              encryptedMsg.append(ch);
              isPresent[ch-'a'] = true;
          }
        }

        if(encryptedMsg.length()>1){
            StringBuilder result = new StringBuilder();
            for(int c1=0;c1<encryptedMsg.length()-1;c1++){
                char ch1 = encryptedMsg.charAt(c1);
                char ch2 = encryptedMsg.charAt(c1+1);
                result.append(addChars(ch1,ch2));
            } result.append(addChars(encryptedMsg.charAt(0),
                    encryptedMsg.charAt(encryptedMsg.length()-1)));
            return result.toString();
        }
        return encryptedMsg.toString();
    }

    /* add 2 characters
     [a,b,c,d,e,f,g,h,i,j ,k ,l ,m ,n ,o ,p ,q ,r ,s ,t ,u ,v ,w ,x ,y ,z]
     [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]
    *  a+b = c
    *  c+f = */
    private static char addChars(char ch1,char ch2){
        char[] alphabets = {'a','b','c','d','e','f','g','h','i','j' ,'k' ,'l' ,'m' ,'n'
                ,'o' ,'p' ,'q' , 'r' ,'s' ,'t' ,'u' ,'v' ,'w' ,'x' ,'y' ,'z'};
        int ind1 = ch1-'a'+1;
        int ind2 = ch2-'a'+1;
        int resultIndex = (ind1+ind2)%26;
        char c =  alphabets[resultIndex==0?25:resultIndex-1];
        /*System.out.println(ch1+"+"+ch2+" = "+c);
        * (or) return resultIndex==0?(char)('a'+25):(char)('a'+resultIndex-1)*/
        return c;
    }


    /* q2. [3,2,1,14,25] given 2 arrays
    *      [1,2,3,14,25]
    *      ------------------
    * 1.  {4,4,4,28,50}   (add 2 )
    * 2. return last index of most occurring entry from sum array.*/
    private static int mostFrequent(int[] random, int[] sorted){
        int mostFrequent = Integer.MIN_VALUE;
        Map<Integer,Integer> frequency = new HashMap<>();
        int highestFreency = 0;
        for(int c=0;c<random.length;c++){
          random[c] += sorted[c];
          frequency.put(random[c],frequency.getOrDefault(random[c],0)+1);
          highestFreency = Math.max(highestFreency,frequency.get(random[c]));
        }

        for(int c1=random.length-1;c1>=0;c1--) {
            int num = random[c1];
            if(frequency.get(num) == highestFreency) {
                mostFrequent = c1;
                break;
            }
        }
        return mostFrequent;
    }


    /* q3. Duplicate Names */
    private static void duplicateNames(){
        Scanner sc = new Scanner(System.in);
        int linesCount = Integer.parseInt(sc.nextLine());
        Map<String,List<String>> map = new HashMap<>();
        for(int c=0;c<linesCount;c++){
            String line = sc.nextLine(); /* name:ssn*/
            String[] tokens = line.split(":");
            List<String> dupNames = map.getOrDefault(tokens[1],null);
            dupNames = dupNames==null?new ArrayList<>():dupNames;
            dupNames.add(tokens[0]);
            map.put(tokens[1],dupNames);
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+getUniqueName(entry.getValue()));
        }
        sc.close();
    }

    /* A name can be in any of the following forms
    * 1. <First Name>
    * 2. <Last Name>, <First Name>
    * 3. <First Name> <Last Name>
    * 4. <Last Name>, <First Name> <Middle Name>
    * 5. <First Name> <Middle Name> <Last Name>
    * 6. <First Initial>.<Middle Initial>.<Last Name>
    * 7. <First Name> <Middle initial>. <Last Name>
   ------------------------------------------------------
    *  so, if a persons name is Maggie Fitzgerald Fergusson
    *     Maggie
    *     Fergusson,Maggie
    *     Maggie Fergusson
    *     Fergusson,Maggie Fitzgerald
    *     Maggie Fitzgerald Fergusson
    *     M.F.Fergusson
    *     Maggie F.Fergusson*/
    private static String getUniqueName(List<String> formats){
        String fullName = new String();
        String firstName=null, middleName=null, lastName=null,
             firstInitial = null, middleInitial = null;
        for(String format:formats){
            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            Matcher matcher = pattern.matcher(format);
            int count = 0;
            while(matcher.find()) count++; matcher = matcher.reset();
            if(count==1){
                firstName = format;
            }else if(count==2){
                for(int c=0;c<format.length();c++){
                    char ch = format.charAt(c);
                    if(!Character.isLetter(ch)){
                        String first = format.substring(0,c);
                        String second = format.substring(c+1);
                        firstName = ch==' '?first:second;
                        lastName = ch==','?firstName:second;
                        break;
                    }
                }
            }else if(count==3){
              matcher.find();
              int ind1 = matcher.end();
              if(format.charAt(ind1)==','){
                 lastName = matcher.group();
                 matcher.find(); firstName = matcher.group();
                 matcher.find(); middleName = matcher.group();
              }else if(format.charAt(ind1)=='.'){
                   matcher.find(); firstInitial = matcher.group();
                   matcher.find(); middleInitial = matcher.group();
                   matcher.find(); lastName = matcher.group();
              }else if(format.charAt(ind1)==' '){
                  firstName = matcher.group();
                  matcher.find();
                  int c = matcher.end();
                  if(format.charAt(c)==' ') middleName = matcher.group();
                  else if(format.charAt(c)=='.') middleInitial = matcher.group();
                  matcher.find(); lastName = matcher.group();

              }
            }
        }
        return firstName+" "+middleName+" "+lastName;
    }


}
