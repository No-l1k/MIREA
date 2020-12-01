package pr_13;

public class Variable implements IComputable {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(int x) {
        return x;
    }
}
