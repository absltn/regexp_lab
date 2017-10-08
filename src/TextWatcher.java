import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TextWatcher {
    public static void main(String[] args){
        System.out.println("Results of checking:");
        System.out.println(checkWithRegExp("_@BEST"));
        System.out.println(checkWithRegExp("asd"));
        System.out.println(checkWithRegExp("vo"));
        System.out.println(checkWithRegExp("Z@OZA"));
        System.out.println(checkWithRegExp("change"));
    }
    public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile(".{2,5}");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}