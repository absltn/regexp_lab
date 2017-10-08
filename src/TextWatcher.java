import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextWatcher {
    public static void main(String[] args){
        System.out.println("Results of checking:");
        String userInput;

        System.out.println(checkForAdj("хорошему"));
        System.out.println(checkForAdj("волчая"));
        System.out.println(checkForAdj("волчий"));
        System.out.println(checkForAdj("настоящей"));
        System.out.println(checkForVerb("стоить"));
        System.out.println(checkForAdverb("вголосину"));
    }
    public static boolean checkForAdj(String userNameString) {
        Pattern adj = Pattern.compile("[а-яА-Я]{3,}(([оиеы]й)|([ео]е|м|(му)|(го))|([аиья]я)|" +
                "((ле)|(не)|(ше)|(ще)|(че)й)$)");
        Matcher madj = adj.matcher(userNameString);
        return madj.matches();
    }
    public static boolean checkForVerb(String userNameString) {
        Pattern verb = Pattern.compile("[а-яА-Я]{2,}((ти)|([ауоиыея]ть)|([ауоиыея]л[аои]{1})$)");
        Matcher mverb = verb.matcher(userNameString);
        return mverb.matches();
    }

    public static boolean checkForAdverb(String userNameString){
        Pattern adverb = Pattern.compile("[освнпзтудегчб][а-яА-Я]{2,}(([елиз(яр)ь](ко))|(ро)|(вчера)|(сегодня)|" +
                "(завтра)|(сь)|(назад)|(вперед)|([ае][(во),(ку)])|(перь)|([дт]ан)|(ину)|([еяу]ча)$)");
        Matcher madverb = adverb.matcher(userNameString);
        return madverb.matches();
    }
}

