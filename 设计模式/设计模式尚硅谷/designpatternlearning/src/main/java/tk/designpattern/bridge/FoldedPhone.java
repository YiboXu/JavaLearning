package tk.designpattern.bridge;

public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public PhoneType getPhoneType() {
        return PhoneType.FOLDED;
    }
}
