package tk.chap4;
import java.util.List;
import java.util.stream.Collectors;

import static tk.chap4.Menu.menu;

public class T1 {
    public static void main(String[] args){
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);
    }
}
