package Lab15;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regex="(\\d+.?\\d*) (EU|RUB|USD)";
        Pattern pattern=Pattern.compile(regex);
        String inp="1 USD ббеббебебебеб 2 USD овлсвыоаыол 2.4 USD dasdasda 2 EU RUB sdadk; dsd jaksdjalsd akdj ksalkdj 15.001 RUB";
        Matcher matcher=pattern.matcher(inp);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
