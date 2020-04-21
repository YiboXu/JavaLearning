package tk.designpattern.uml;

public class Person {
    private IDCard idCard;
    private Head head = new Head();

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
