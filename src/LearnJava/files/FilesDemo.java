package LearnJava.files;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesDemo {

    public static void main(String[] args){

        /* working with Files.*/
        File cwd = new File(System.getProperty("user.dir"));
        try{
            printAllFiles(cwd,1);
            System.out.println("\n\nJava program responsible for printing this line is as Follows");
            System.out.println("----------------------------------------------");
            Path curFilePath = Paths.get(cwd.getAbsolutePath().toString()+"/src/LearnJava/files/FilesDemo.java");
            System.out.println(curFilePath.toString());
            File currentFile = curFilePath.toFile();
            System.out.println("current File length():"+currentFile.length());
            printFile(currentFile);
            System.out.println("---------------------------------------");
            /* create a new directory and a File in it*/
            File subdirRef = new  File("subdir");
            if(!subdirRef.exists()) subdirRef.mkdir();
            File file2 = new File(subdirRef,"welcome.java");
            if(!file2.exists()) file2.createNewFile();
            /* delete the File created in above steps*/
            System.out.println("delete("+file2.getName()+"):"+file2.delete());
            subdirRef.delete();

            File c = new File("CoreJava Topics.txt");
            FileReader fr = new FileReader(c);
            /*char[] chs = new char[(int)c.length()];
            fr.read(chs);
            for(char ch:chs){
                System.out.print(ch);
            }*/
            int m = fr.read();
            while(m!=-1){
                System.out.print((char)m);
                m = fr.read();
            }
            fr.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void printAllFiles(File file,int space){
        space(space);System.out.println(file.toString() );
        space(space);System.out.println("----------------------------------------------");
        List<File> directories = new ArrayList<>();
        for(File c:file.listFiles()){
            if(c.isDirectory()) directories.add(c);
            else if(c.isFile()){
                space(space);
                System.out.println(c.getName().toString());
            }
        }
        for(File directory:directories){
            printAllFiles(directory,space+1);
        }
    }

    private static void space(int spaces){
        for(int c=0;c<spaces;c++)
            System.out.print("\t");
    }

    private static void printFile(File file){
        if(file.exists() && file.isFile()){
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while(line!=null){
                    System.out.println(line);
                    line = br.readLine();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
