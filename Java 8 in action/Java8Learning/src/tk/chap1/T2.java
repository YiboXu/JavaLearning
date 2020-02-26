package tk.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class T2 {
    public static void main(String[] args){
        List<Apple> inventory = Arrays.asList(new Apple(Colour.RED,200),new Apple(Colour.RED,550),new Apple(Colour.GREEN,600));
        System.out.println(FilterApple(inventory,Apple::isGreenApple));
        System.out.println(FilterApple(inventory,Apple::isHeavyApple));
    }

    public static List<Apple> FilterApple(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }
}
