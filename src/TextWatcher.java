import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TextWatcher {
    public static void main(String[] args){
        System.out.println("Results of checking:");
        System.out.println(checkForAdj("волчей"));
        System.out.println(checkForVerb("стоял"));
    }
    public static boolean checkForAdj(String userNameString) {
        Pattern adj = Pattern.compile("..+([ео]е|м|му|го|шем])|[иы][ей]|[аиья]я|([ле,не,ше,ще,че,о]й)$");
        Matcher madj = adj.matcher(userNameString);
        return madj.matches();
    }
    public static boolean checkForVerb(String userNameString){
        Pattern verb = Pattern.compile("..+(ти)|[ауоиыея]т|лаои?$");
        Matcher mverb = verb.matcher(userNameString);;
        return mverb.matches();
    }
}

