package tk.designpattern.bridge;

public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    public PhoneType getPhoneType() {
        return PhoneType.UPRIGHT;
    }
}
