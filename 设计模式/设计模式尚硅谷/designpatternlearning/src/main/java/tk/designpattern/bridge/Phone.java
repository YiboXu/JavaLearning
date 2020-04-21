package tk.designpattern.bridge;

public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void call(){
        brand.call();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand=" + brand.getBrandName() +
                "type=" + getPhoneType() +
                '}';
    }

    public abstract PhoneType getPhoneType();
}
