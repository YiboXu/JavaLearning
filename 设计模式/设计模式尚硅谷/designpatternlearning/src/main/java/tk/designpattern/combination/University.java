package tk.designpattern.combination;

import java.util.ArrayList;
import java.util.List;

public class University extends OriginationComponent {
    //存放College节点
    private List<OriginationComponent> originationComponents = new ArrayList<OriginationComponent>();

    public University(String name, String description) {
        super(name,description);
    }

    @Override
    public void add(OriginationComponent originationComponent) {
        originationComponents.add(originationComponent);
    }

    @Override
    public void remove(OriginationComponent originationComponent) {
        originationComponents.remove(originationComponent);
    }

    @Override
    public void print() {
        System.out.println(this);
        originationComponents.stream().forEach(c -> c.print());
    }
}
