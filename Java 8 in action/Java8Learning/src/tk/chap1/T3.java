package tk.chap1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T3 {
    public static void doSomethingWithFile1(FileProcessor processor) {
        try(BufferedReader br = new BufferedReader(new FileReader("c:\\test.txt"))){
            System.out.println(processor.process(br));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doSomethingWithString(StringProcessor processor){
        System.out.println(processor.process("hello","world"));
    }

    public static void main(String[] args){
        doSomethingWithFile1((BufferedReader br) -> br.readLine() + "\n"+br.readLine());
        doSomethingWithString((String s1, String s2) -> s1+s2);
    }
}

@FunctionalInterface
interface FileProcessor{
    String process(BufferedReader br) throws IOException;
}

@FunctionalInterface
interface StringProcessor{
    String process(String s1, String s2);
}
