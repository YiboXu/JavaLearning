package tk.designpattern.interpret;

import java.util.HashMap;

public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.getLeft().interpreter(var) + super.getRight().interpreter(var);
    }
}
