package tk.chap4;

import java.util.stream.Collectors;

import static tk.chap4.Menu.menu;

public class T4 {
    public static void main(String[] args){
        System.out.println(menu.stream().collect(Collectors.counting()));

        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(" ")));

        System.out.println(menu.stream().map(Dish::getName).reduce("*",(e1,e2)->e1+"0"+e2));
        System.out.println(menu.parallelStream().map(Dish::getName).reduce("*",(e1,e2)->e1+"0"+e2,(e1,e2)->e1+"1"+e2));
    }
}
