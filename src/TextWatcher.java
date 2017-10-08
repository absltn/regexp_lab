import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TextWatcher {
    public static void main(String[] args){
        System.out.println("Results of checking:");
        System.out.println(checkForAdj("хорошему"));
        System.out.println(checkForAdj("волчая"));
        System.out.println(checkForAdj("волчий"));
        System.out.println(checkForAdj("настоящей"));
        System.out.println(checkForVerb("стояти"));
    }
    public static boolean checkForAdj(String userNameString) {
        Pattern adj = Pattern.compile("[а-яА-Я]{3,}([оиеы]й$)|([ео]е|м|(му)|(го)$)|" +
                "([аиья]я$)|((ле)|(не)|(ше)|(ще)|(че)й$)");
        Matcher madj = adj.matcher(userNameString);
        return madj.matches();
    }
    public static boolean checkForVerb(String userNameString){
        Pattern verb = Pattern.compile("[а-яА-Я]{2,}(ти$)|([ауоиыея][тл]аои?$)");
        Matcher mverb = verb.matcher(userNameString);
        return mverb.matches();
    }
}

