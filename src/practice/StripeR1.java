package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StripeR1 {

    public static void main(String[] args){
      String[] input = {
              "API: card=4242424242424242&amount=300&description=order+7878",
              "API: amount=301&card=5656565656565656",
              "BANK: card=565656XXXXXXXXXXXXXXXXXXXX5656&authorize=true"
      };
      for(String str:process(input)){
          System.out.println(str);
      }
    }

    /**/
    private static  String[] process(String[] lines){
        String[] output = new String[lines.length];
        Map<String,String> map = new HashMap<>();
      for(int c=0;c<lines.length;c++){
          String line = lines[c];
        String action = line.substring(0,line.indexOf(':'));
        if(action.equals("API")){
            Pattern pattern = Pattern.compile("card=[0-9]{15}[0-9]?");
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            String cardNumber = matcher.group().substring(5);
            String encryptedCardNumber = encrypt(cardNumber);
            map.put(encryptedCardNumber,cardNumber);
            output[c]=line.replace(cardNumber,encryptedCardNumber);
        }else if(action.equals("BANK")){
            Pattern pattern = Pattern.compile("card=[0-9]{6}[X]{20}[0-9]{4}");
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            String encrypptedCardNumber = matcher.group().substring(5);
            String decryptedCardNumber = map.get(encrypptedCardNumber);
            output[c] = line.replace(encrypptedCardNumber,decryptedCardNumber);
        }
      } return output;
    }

    private static String encrypt(String cardNumber){
        StringBuilder encrypted = new StringBuilder();
        encrypted.append(cardNumber.substring(0,6));
        encrypted.append("XXXXXXXXXXXXXXXXXXXX");
        encrypted.append(cardNumber.substring(cardNumber.length()-4));
        return encrypted.toString();
    }


}
