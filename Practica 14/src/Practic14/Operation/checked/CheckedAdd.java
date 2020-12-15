package Practic14.Operation.checked;
import Practic14.Exceptions.ArithmeticParserException;
import Practic14.Expression.TripleExpression;
import Practic14.Operation.BinaryOperation;


public class CheckedAdd extends BinaryOperation {
    public CheckedAdd(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            throw new ArithmeticParserException("Overflow exception : " + left + " + " + right);
        }
        return left + right;
    }
}
