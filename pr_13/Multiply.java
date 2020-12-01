package pr_13;

public class Multiply extends AbstractOperator {

    public Multiply(IComputable a, IComputable b) {
        super(a, b);
    }

    public int evaluate(int x) {
        return a.evaluate(x) * b.evaluate(x);
    }
}
