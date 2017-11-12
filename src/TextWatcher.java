import java.io.IOException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class TextWatcher {
    public static void main(String[] args) throws IOException {
        System.out.println("Results of checking:");

        ResourceBundle bundle = ResourceBundle.getBundle("test");
        String fileName = bundle.getString("regexp");

        int result[]={0,0,0,0};
        String content = null;

        content = readUsingFiles(fileName);
        System.out.println("Текст для анализа: "+ content+"\n");
        String [] words = content.split ("([\\s/.,/!/?]+)");
        List<String> other = new ArrayList<String>();
        List<String> adverbs = new ArrayList<String>();
        List<String> verbs = new ArrayList<String>();
        List<String> adjectives = new ArrayList<String>();

        for (int i=0; i<words.length;i++)
            if (checkForAdj(words[i]) ) {
                result[0]++;
                adjectives.add(words[i]);
            }
            else if (checkForVerb(words[i])){
                result[1]++;
                verbs.add(words[i]);
            }
            else if (checkForAdverb(words[i])) {
                result[2]++;
                adverbs.add(words[i]);
            }
            else {
                result[3]++;
                other.add(words[i]);
            }
        System.out.printf("В данном тексте примерно %d прилагательных, %d глаголов,%n" +
                "%d наречий и %d других хоть-сколько значимых слов.%n",result[0],result[1],result[2],
                result[3]);
        System.out.println("Из них прилагательные:");
        for (String s:adjectives)
            System.out.printf("%s ",s);
        System.out.println("\nглаголы:");
        for (String s:verbs)
            System.out.printf("%s ",s);
        System.out.println("\n\nНаречия:");
        for (String s:adverbs)
            System.out.printf("%s ",s);
        System.out.println("\n\nПрочее:");
        for (String s:other)
            System.out.printf("%s ",s);
    }

    private static String readUsingFiles(String fileName) throws IOException {
        try{
            Files.readAllBytes(Paths.get(fileName));}
        catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Files.readAllBytes(Paths.get(fileName)),"UTF-8");
    }

     public static boolean checkForAdj(String userNameString) {
        Pattern adj = Pattern.compile("[а-яА-Я]{2,}((^з[оиеы][йем])$|([ео]м|(му)|(го)$)|([аиья]я$)|" +
                "((еле)$|(ше)$|(ще)$|(че)$)|([иы]х)$)");
        Matcher madj = adj.matcher(userNameString);
        return madj.matches();
    }

    public static boolean checkForVerb(String userNameString) {
        Pattern verb = Pattern.compile("[а-яА-Я]{2,}(((ти)|(ри)|(ги)|(ши)|(юди)(сь)?$)|([ауоиыея](ть)|(ти)((ся)?)$)|" +
                "([аяиуюое]?^(бл)[ияюе]т(ся)?$)|" +
                "((ьте)|^(кр)(ай)|(рь)|(ите)$)|(([лнсзмр]аю$)|([лсзмр][ую]ю)$)|" +
                "([ие](шь)|(шу)|^(та)м(ся)?$)|(йте$)|([еияыа]л|(л[аои]))(с[яь])?$)");
        Matcher mverb = verb.matcher(userNameString);
        return mverb.matches();
    }

    public static boolean checkForAdverb(String userNameString){
        Pattern adverb = Pattern.compile("[оОсСвВнНпПзЗтТуУдДеЕгГчЧбБ]*" +
                "(([елиз(яр)ь](ко$))|(ро$)|(вчера$)|([сС]егодня$)|([тТ]ам$)|([сС]ям$)|(йн[ео]$)" +
                "([зЗ]автра$)|(сь$)|(где$)|([вВ]перед$)|([ае](во$)|(ку$)|([гГ]де$)|(лько))|(перь)|([тп][лрн][оe(ее)])|" +
                "(ив[о(ее)])|(ев[о(ее)])|([дт]ан)|(ину)|([еяу]ча)$)");
        Matcher madverb = adverb.matcher(userNameString);
        return madverb.matches();
    }
}

