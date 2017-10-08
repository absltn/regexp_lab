import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.String;

public class TextWatcher {
    public static void main(String[] args) throws IOException {
        System.out.println("Results of checking:");
        String fileName = "C:/users/airliq/desktop/regTest.txt";
        int result[]={0,0,0};
        String content = null;
        content = readUsingFiles(fileName);
        String [] words = content.split ("([\\s/.,]+)");

        for (int i=0; i<words.length;i++)
            if (checkForAdj(words[i]) ) 
                result[0]++;

            else if (checkForVerb(words[i]))
                result[1]++;
            else if (checkForAdverb(words[i]))
                result[2]++;
        System.out.printf("В данном тексте примерно %d прилагательных, %d глаголов и " +
                "%d наречий.",result[0],result[1],result[2]);
    }

    private static String readUsingFiles(String fileName) throws IOException {
        try{
            Files.readAllBytes(Paths.get(fileName));}
        catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

     public static boolean checkForAdj(String userNameString) {
        Pattern adj = Pattern.compile("[а-яА-Я]{3,}(([оиеы]й)|([ео]е|м|(му)|(го))|([аиья]я)|" +
                "((ле)|(не)|(ше)|(ще)|(че)й)$)");
        Matcher madj = adj.matcher(userNameString);
        return madj.matches();
    }
    public static boolean checkForVerb(String userNameString) {
        Pattern verb = Pattern.compile("[а-яА-Я]{2,}((ти)|([ауоиыея][ть])|([ияюе]т)|([(ьте)(ай)(рь)(ите)])|([ие](шь)|(те)|м)|([ия]л[аои]{1})$)");
        Matcher mverb = verb.matcher(userNameString);
        return mverb.matches();
    }

    public static boolean checkForAdverb(String userNameString){
        Pattern adverb = Pattern.compile("[оОсСвВнНпПзЗтТуУдДеЕгГчЧбБ][а-яА-Я]{1,}" +
                "(([елиз(яр)ь](ко))|(ро)|(вчера)|(сегодня)|" +
                "(завтра)|(сь)|(назад)|(вперед)|([ае][(во),(ку)])|(перь)|([лрн][о(ее)])|(ив[о(ее)])|(ев[о(ее)])|([дт]ан)|(ину)|([еяу]ча)$)");
        Matcher madverb = adverb.matcher(userNameString);
        return madverb.matches();
    }
}

