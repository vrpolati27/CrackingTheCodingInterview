package LearnJava.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args){
        Path path = Paths.get("/temp/dijkstras.txt");
        System.out.println(path.toString());
        System.out.println(path.getFileName());
        System.out.println(path.getNameCount());
    }
}
