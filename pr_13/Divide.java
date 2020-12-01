package pr_13;

public class Divide extends AbstractOperator {
    public Divide(IComputable a, IComputable b) {
        super(a, b);
    }

    public int evaluate(int x) {
        return a.evaluate(x) / b.evaluate(x);
    }
}
