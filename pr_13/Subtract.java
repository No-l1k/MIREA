package pr_13;

public class Subtract extends AbstractOperator {
    public Subtract(IComputable a, IComputable b) {
        super(a, b);
    }

    public int evaluate(int x) {
        return a.evaluate(x) - b.evaluate(x);
    }
}
