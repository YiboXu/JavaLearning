package tk.designpattern.combination;

import java.util.ArrayList;
import java.util.List;

public class College extends OriginationComponent {
    //存放叶子节点Department
    private List<OriginationComponent> originationComponents = new ArrayList<OriginationComponent>();

    public College(String name, String description) {
        super(name,description);
    }

    @Override
    public void add(OriginationComponent originationComponent) {
        originationComponents.add(originationComponent);
    }

    @Override
    public void remove(OriginationComponent originationComponent) {
        super.remove(originationComponent);
    }

    @Override
    public void print() {
        System.out.println(this);
        originationComponents.stream().forEach(c -> c.print());
    }
}
