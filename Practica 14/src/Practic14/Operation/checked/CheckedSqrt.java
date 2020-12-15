package Practic14.Operation.checked;
import Practic14.Exceptions.ArithmeticParserException;
import Practic14.Expression.TripleExpression;
import Practic14.Operation.UnaryOperation;


public class CheckedSqrt extends UnaryOperation {
    public CheckedSqrt(TripleExpression object) {
        super(object);
    }

    protected int evaluate(int x) {
        if (x < 0)
            throw new ArithmeticParserException("negative radicand :  sqrt(" + x + ")");
        if (x == 0)
            return 0;
        int result = 1;
        boolean decreased = false;
        int nx;
        for (; ; ) {
            nx = (result + x / result) >> 1;
            if (result == nx || nx > result && decreased) {
                break;
            }
            decreased = nx < result;
            result = nx;
        }
        return result;
    }
}
