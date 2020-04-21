package tk.designpattern.proxy.staticproxy;

public class ProxyTeacher implements ITeacher {
    private ITeacher teacher;

    public ProxyTeacher(ITeacher teacher) {
        this.teacher = teacher;
    }


    @Override
    public void teach() {
        System.out.println("代课老师代替正式老师");
        teacher.teach();
    }
}
