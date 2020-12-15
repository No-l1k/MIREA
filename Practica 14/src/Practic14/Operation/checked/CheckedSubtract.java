package Practic14.Operation.checked;
import Practic14.Exceptions.ArithmeticParserException;
import Practic14.Expression.TripleExpression;
import Practic14.Operation.BinaryOperation;


public class CheckedSubtract extends BinaryOperation {
    public CheckedSubtract(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            throw new ArithmeticParserException("Integer overflow");
        }
        return left - right;
    }
}
