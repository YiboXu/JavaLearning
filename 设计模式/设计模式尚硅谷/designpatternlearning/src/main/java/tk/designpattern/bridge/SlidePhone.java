package tk.designpattern.bridge;

public class SlidePhone extends Phone {

    public SlidePhone(Brand brand) {
        super(brand);
    }

    @Override
    public PhoneType getPhoneType() {
        return PhoneType.SLIDE;
    }
}
