package tk.designpattern.interpret;

import java.util.Stack;

public class Calculator {
    private Expression expression;

    public Calculator(String expStr) {
        Stack<Expression> stack = new Stack<>();
        char[] charArray = expStr.toCharArray();

        for(int i=0;i<charArray.length;i++){
            switch (charArray[i]){
                case '+':
                    stack.push(new AddExpression(stack.pop(),new VarExpression(String.valueOf(charArray[++i]))));
                    break;
                case '-':
                    stack.push(new SubExpression(stack.pop(),new VarExpression(String.valueOf(charArray[++i]))));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }

        this.expression = stack.pop();
    }

    public Expression getExpression() {
        return expression;
    }
}
