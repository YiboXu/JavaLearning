package tk.chap10;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;

public class T1 {
    public static void main(String[] args){
        Person p1 = new Person(Optional.empty());
        Car car1 = new Car(Optional.empty());
        Person p2 = new Person(Optional.ofNullable(car1));
        Insurance insurance = new Insurance("RenBaoCarInsurance");
        Car car2 = new Car(Optional.ofNullable(insurance));
        Person p3 = new Person(Optional.of(car2));

        System.out.println(p1.getCar().orElse(new Car(Optional.empty())).getInsurance().orElse(new Insurance("UnExist")).getName());

        //fetch the object using flatMap if there are multiple Optional
        Optional<Car> optCar = p3.getCar();
        Optional<Insurance> optInsurance = optCar.flatMap(Car::getInsurance);

        //fetch the object using map if just one level Optional
        Optional<String> name = optInsurance.map(Insurance::getName);

        System.out.println(name.get());
    }
}
