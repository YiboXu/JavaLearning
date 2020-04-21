package tk.designpattern.flyweight;

public class ConcreteWebSite extends WebSite {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("User: " + user + " 正在使用 " + type);
    }
}
