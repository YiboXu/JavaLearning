package tk.chap1;

import java.io.File;
import java.io.FileFilter;

public class t1 {
    public static void main(String[] args){
        listHiddenFiles2();
    }

    public static void listHiddenFiles1(){
        File[] hiddenFiles = new File("c:\\").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        for (File file: hiddenFiles) {
            System.out.println(file.getName());
        }
    }

    public static void listHiddenFiles2(){
        File[] hiddenFiles = new File("c:\\").listFiles(File::isHidden);

        for (File file: hiddenFiles) {
            System.out.println(file.getName());
        }
    }
}
