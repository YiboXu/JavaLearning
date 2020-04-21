package tk.designpattern.interpret;

import java.util.HashMap;

public class VarExpression extends Expression {
    private String varName;

    public VarExpression(String varName) {
        this.varName = varName;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(varName);
    }
}
