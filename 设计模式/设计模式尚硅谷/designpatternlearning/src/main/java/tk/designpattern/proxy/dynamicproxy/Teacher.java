package tk.designpattern.proxy.dynamicproxy;

public class Teacher implements ITeacher {
    @Override
    public void teach() {
        System.out.println("老师在上课");
    }
}
