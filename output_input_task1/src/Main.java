import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        String main_dir = "C:\\Users\\Logerasmo\\Desktop\\Games";
        String src = main_dir + "\\src";
        String res = main_dir + "\\res";
        String temp = main_dir + "\\temp";
        createFolder(src);
        createFolder(res);
        createFolder(main_dir + "\\savegames");
        createFolder(temp);
        createFolder(src + "\\main");
        createFolder(src + "\\test");
        createFile(src + "\\main", "Main.java");
        createFile(src + "\\main", "Utils.java");
        createFolder(res + "\\drawables");
        createFolder(res + "\\vectors");
        createFolder(res + "\\icons");
        createFile(temp, "temp.txt");
        try (FileWriter fw = new FileWriter(new File(temp, "temp.txt"))){
            fw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createFolder(String dir){
        File folder = new File(dir);
        if (folder.mkdir()){
            sb.append("Folder ").append(folder.getName()).append(" created! ").append(new Date()).append("\n");
        }
        else{
            sb.append("Folder ").append(folder.getName()).append(" not created! ").append(new Date()).append("\n");
        }
    }
    public static void createFile(String dir, String name){
        File file = new File(dir, name);
        try {
            if (file.createNewFile()){
                sb.append("File ").append(file.getName()).append(" created! ").append(new Date()).append("\n");
            }
            else{
                sb.append("File ").append(file.getName()).append(" not created! ").append(new Date()).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
