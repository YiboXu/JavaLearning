package tk.designpattern.interpret;

import java.util.HashMap;

/**
 * 解释器模式的注意事项和细节 解释器模式的注意事项和细节
 * 1) 当有 一个语言需要解释执行 ，可 将该语言中的句子表示为一个抽象法 树，就可以 考虑使用解释器模式，让程序具有良好的扩 展性
 * 2) 应用场景：编译 器、运 算表达 式计、正则式、机 器人等
 * 3) 使用解释器可能带来的问题： 解释器模式会引起类膨 胀、解释器模式采用 递归调方法，将会导致调试非常复 杂、效率 可能降低 .
 */
public class Client {
    public static void main(String[] args) {
        HashMap<String, Integer> var = new HashMap<>();
        var.put("a",10);
        var.put("b",20);
        var.put("c",4);
        Calculator calculator1 = new Calculator("a+b-c");
        System.out.println(calculator1.getExpression().interpreter(var));
    }
}
