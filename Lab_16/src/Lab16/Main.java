package Lab16;

public class Main {
    public static final String[] STRINGS = {"(1+8)–9/4", "6/5–2*9 "};

    public static void main(String[] args) {
        for (String str : STRINGS) {
            System.out.print(str + ": ");
            System.out.println(isCorrect(str) ? "False" : "True");
        }
    }

    public static boolean isCorrect(String str) {
        return str.matches(".*\\d+.*") && !str.matches(".*\\d+\\+.*");
    }
}
