package pr_7;

public class Main {
    public static void main(String[] args) {
        final boolean DEBUG_MODE = false;
        Game pyanitsa = new Game(DEBUG_MODE);
        pyanitsa.readFirst();
        pyanitsa.readSecond();
        pyanitsa.loop();
    }
}
