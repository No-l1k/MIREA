package pr_13;

public class Const implements IComputable {
    private final int x;

    public Const(int x) {
        this.x = x;
    }

    public int evaluate(int x) {
        return this.x;
    }
}
