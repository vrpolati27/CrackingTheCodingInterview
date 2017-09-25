package ctci.ArraysNstrings;

public class OneAway {

    public static void main(String[] args){
      String s1="pale",s2="ple"; /* true*/
      System.out.println("isOneEditAway("+s1+","+s2+"):"+isOneEditAway(s1,s2));
      s1 = "pales"; s2="pale";/* true*/
        System.out.println("isOneEditAway("+s1+","+s2+"):"+isOneEditAway(s1,s2));
        s1="pale";s2="bale";/* true*/
        System.out.println("isOneEditAway("+s1+","+s2+"):"+isOneEditAway(s1,s2));
        s1="pale";s2="bake";/* false*/
        System.out.println("isOneEditAway("+s1+","+s2+"):"+isOneEditAway(s1,s2));
    }

    /* returns true only if both the strings are at most 1 edit away, false otherwise.
    * T(n)=O(n), where n=s1.length().*/
    private static boolean isOneEditAway(String s1, String  s2){
        int lenDiff = Math.abs(s1.length()-s2.length());
        if(!(lenDiff==0 || lenDiff==1)) return false;
        return s1.length()>=s2.length()?isOneDistanceAway(s1,s2):isOneDistanceAway(s2,s1);
    }

    private static boolean isOneDistanceAway(String s1,String s2){
        boolean isSameLengthStr = s1.length()==s2.length();
        boolean oneEdited = false;
        int c1=0,c2=c1;
        for(;c1<s2.length();){
          char ch1 = s1.charAt(c1); char ch2 = s2.charAt(c2);
          if(oneEdited && isSameLengthStr && ch1!=ch2) return false;
          if(!oneEdited && isSameLengthStr && ch1!=ch2) oneEdited = true;
          if(!isSameLengthStr && ch1!=ch2 && !oneEdited) {
              oneEdited = true;
              c1=c1+1;
              continue;
          }
          if(!isSameLengthStr && oneEdited && ch1!=ch2) return false;
            c1++;c2++;
        }
        return true;
    }
}
