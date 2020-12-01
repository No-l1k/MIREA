package pr_13;

public abstract class AbstractOperator implements IComputable {
    protected IComputable a;
    protected IComputable b;

    public AbstractOperator(IComputable a, IComputable b) {
        this.a = a;
        this.b = b;
    }
}
