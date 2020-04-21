package tk.designpattern.combination;

public class Department extends OriginationComponent {
    public Department(String name, String description) {
        super(name, description);
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
