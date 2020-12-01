package pr_13;

public class Add extends AbstractOperator {
    public Add(IComputable a, IComputable b) {
        super(a,b);
    }

    public int evaluate(int x) {
        return a.evaluate(x) + b.evaluate(x);
    }
}
