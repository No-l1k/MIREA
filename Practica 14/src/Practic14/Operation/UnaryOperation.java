package Practic14.Operation;
import Practic14.Expression.TripleExpression;


public abstract class UnaryOperation implements TripleExpression {
    private final TripleExpression object;

    public UnaryOperation(TripleExpression object) {
        this.object = object;
    }

    abstract protected int evaluate(int object);

    public int evaluate(int x, int y, int z) {
        return evaluate(object.evaluate(x, y, z));
    }
}
