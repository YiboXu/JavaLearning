package tk.designpattern.basicruler.closeOpen;

/**
 * - 开闭原则，是编程中最基础，最重要的设计原则
 * - 一个软件实体如类，模块和函数应该对扩展开放(相对功能提供方)，对修改关闭(对功能使用方)
 * 用抽象构建框架，用实现扩展细节
 * - 当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化
 * - 编程中遵循其他原则，以及使用设计模式的目的就是遵循开闭原则.
 */

interface Shape{
    void draw();
}

class Rectangle implements Shape{

    public void draw() {
        System.out.println("画长方形");
    }
}

//如果需要画其他图形, 只用创建新的实现类，而不用修改已经存在的类
class Circle implements Shape{

    public void draw() {
        System.out.println("画圆形");
    }
}

class GraphicEditor{
    static void draw(Shape shape){
        shape.draw();
    }
}

public class CloseOpenRule {
    public static void main(String[] args) {
        GraphicEditor.draw(new Rectangle());
        GraphicEditor.draw(new Circle());
    }
}
