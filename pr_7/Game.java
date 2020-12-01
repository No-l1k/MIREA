package pr_7;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Game {
    private ArrayDeque<Short> first_player;
    private ArrayDeque<Short> second_player;
    private short round;
    private GameState current_state;
    private boolean show_game_process;

    public Game() {
        this(false);
    }

    public Game(boolean show_game_process) {
        this(new ArrayDeque<Short>(),
             new ArrayDeque<Short>(), show_game_process);
    }

    public Game(ArrayDeque<Short> first_player, ArrayDeque<Short> second_player) {
        this(first_player, second_player, false);
    }

    public Game(ArrayDeque<Short> first_player, ArrayDeque<Short> second_player, boolean show_game_process) {
        this.first_player = first_player;
        this.second_player = second_player;
        this.show_game_process = show_game_process;
        round = 0;
        current_state = GameState.IN_PROCESS;
    }

    private void readCards(ArrayDeque<Short> arr, String name) {
        if (show_game_process)
            System.out.print("Введите набор карт для игрока '"+name+"': ");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
            arr.add(input.nextShort());
    }

    public void readFirst() {
        readCards(first_player, "first");
    }

    public void readSecond() {
        readCards(second_player, "second");
    }

    public void loop() {
        if (current_state != GameState.IN_PROCESS) {
            showEndPage();
            return;
        }
        if (show_game_process)
            showGameField();
        step();
        round++;
        loop();
    }

    private void step() {
        /*
        *  +-----------------------------------------+
        *  |        first (x) <--- second (y)        |
        *  +-----------------------------------------+
        *  |        first (x) ---> second (y)        |
        *  +-----------------------------------------+
        *  |       Rounds maximum exceed (106)       |
        *  +-----------------------------------------+
        *
        * */
        if (round >= 106) {
            current_state = GameState.BOTVA;
            if (show_game_process)
                System.out.println("|       Rounds maximum exceed (106)       |");
            return;
        }
        if (isSecondStronger(first_player.getFirst(),
                second_player.getFirst())) {
            if (show_game_process) {
                System.out.println(String.format(
                        "|        first (%s) ---> second (%s)        |",
                        first_player.getFirst(),
                        second_player.getFirst()));
            }
            second_player.add(first_player.removeFirst());
            second_player.add(second_player.removeFirst());
            if (first_player.size() == 0)
                current_state = GameState.VICTORY_OF_SECOND;
        } else {
            if (show_game_process) {
                System.out.println(String.format(
                        "|        first (%s) <--- second (%s)        |",
                        first_player.getFirst(),
                        second_player.getFirst()));
            }
            first_player.add(first_player.removeFirst());
            first_player.add(second_player.removeFirst());
            if (second_player.size() == 0)
                current_state = GameState.VICTORY_OF_FIRST;
        }
    }

    private boolean isSecondStronger(short f, short s) {
        if (f > s && (s != 0 || f != 9) || (f == 0 && s == 9))
            return false;
        return true;
    }

    public void showGameField() {
        /*
        * +---------------[ Ход 116 ]---------------+
        * | first:  [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]  |
        * | second: [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]  |
        * +-----------------------------------------+
        *
        * */
        System.out.println(String.format("+---------------[ Ход %-3s ]---------------+", round));
        System.out.println(String.format("| first:  %-31s |", first_player));
        System.out.println(String.format("| second: %-31s |", second_player));
        System.out.println("+-----------------------------------------+");
    }

    private void showEndPage() {
        /*
         * +-----------------------------------------+
         * |           first  player: won            |
         * +-----------------------------------------+
         * |           second player: won            |
         * +-----------------------------------------+
         * |           there is no winner            |
         * +-----------------------------------------+
         *
         * */
        if (show_game_process) {
            if (current_state == GameState.BOTVA)
                System.out.println("|           there is no winner            |");
            else {
                showGameField();
                System.out.println(String.format("|           %-6s player: won            |", current_state));
            }
            System.out.println("+-----------------------------------------+");
        } else if (current_state == GameState.BOTVA)
            System.out.println(current_state);
        else
            System.out.println(current_state+" "+round);
    }

    public ArrayDeque<Short> getFirstPlayer() {
        return first_player;
    }

    public ArrayDeque<Short> getSecondPlayer() {
        return second_player;
    }

    public short getRound() {
        return round;
    }

    public GameState getCurrentState() {
        return current_state;
    }
}

enum GameState {
    IN_PROCESS(""),
    VICTORY_OF_FIRST("first"),
    VICTORY_OF_SECOND("second"),
    BOTVA("botva");

    private String repr;
    GameState(String repr) {
        this.repr = repr;
    }

    @Override
    public String toString() {
        return repr;
    }
}