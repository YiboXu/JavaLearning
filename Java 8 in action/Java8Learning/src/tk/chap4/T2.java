package tk.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T2 {
    public static void main(String[] args){
        List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(4,5);

        List<int[]> list = number1.stream().flatMap(i -> number2.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());
        System.out.println(list.stream().map(arr -> "("+arr[0]+","+arr[1]+")").collect(Collectors.toList()));
    }
}
