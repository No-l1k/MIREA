package pr_7;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Game
{
    private ArrayDeque<Short> first_player;
    private ArrayDeque<Short> second_player;
    private short round;
    private GameState current_state;

    public Game()
    {
        this(new ArrayDeque<Short>(), new ArrayDeque<Short>());
    }

    public Game(ArrayDeque<Short> first_player, ArrayDeque<Short> second_player)
    {
        this.first_player = first_player;
        this.second_player = second_player;

        round = 0;
        current_state = GameState.IN_PROCESS;
    }

    private void readCards(ArrayDeque<Short> arr, String name)
    {

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
            arr.add(input.nextShort());
    }

    public void readFirst()
    {
        readCards(first_player, "first");
    }

    public void readSecond()
    {
        readCards(second_player, "second");
    }

    public void loop()
    {
        if (current_state != GameState.IN_PROCESS) {
            showEndPage();
            return;
        }

        step();
        round++;
        loop();
    }

    private void step()
    {

        if (round >= 106)
        {
            current_state = GameState.BOTVA;

            return;
        }
        if (isSecondStronger(first_player.getFirst(), second_player.getFirst()))
        {

            second_player.add(first_player.removeFirst());
            second_player.add(second_player.removeFirst());
            if (first_player.size() == 0)
                current_state = GameState.VICTORY_OF_SECOND;
        }
        else
        {

            first_player.add(first_player.removeFirst());
            first_player.add(second_player.removeFirst());
            if (second_player.size() == 0)
                current_state = GameState.VICTORY_OF_FIRST;
        }
    }

    private boolean isSecondStronger(short f, short s)
    {
        if (f > s && (s != 0 || f != 9) || (f == 0 && s == 9))
            return false;

        return true;
    }



    private void showEndPage()
    {

        if (current_state == GameState.BOTVA)
            System.out.println(current_state);
        else
            System.out.println(current_state+" "+round);
    }

    public ArrayDeque<Short> getFirstPlayer()
    {
        return first_player;
    }

    public ArrayDeque<Short> getSecondPlayer()
    {
        return second_player;
    }

    public short getRound()
    {
        return round;
    }

    public GameState getCurrentState()
    {
        return current_state;
    }
}

enum GameState
{
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
