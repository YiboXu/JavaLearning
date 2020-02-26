package tk.chap10;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance;

    public Car(Optional<Insurance> insurance){
        this.insurance = insurance;
    }

    public Optional<Insurance> getInsurance(){
        return insurance;
    }
}
