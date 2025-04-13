import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress gp1 = new GameProgress(10, 1, 1, 30);
        GameProgress gp2 = new GameProgress(20, 2, 2, 40);
        GameProgress gp3 = new GameProgress(15, 4, 2, 35);
        String dir1 = "C:\\Users\\Logerasmo\\Desktop\\Games\\savegames\\save1.dat";
        String dir2 = "C:\\Users\\Logerasmo\\Desktop\\Games\\savegames\\save2.dat";
        String dir3 = "C:\\Users\\Logerasmo\\Desktop\\Games\\savegames\\save3.dat";
        saveGame(dir1, gp1);
        saveGame(dir2, gp2);
        saveGame(dir3, gp3);
        zipFiles("C:\\Users\\Logerasmo\\Desktop\\Games\\savegames\\zipo.zip",
                Arrays.asList(dir1, dir2, dir3));
        new File(dir1).delete();
        new File(dir2).delete();
        new File(dir3).delete();

    }
    public static void zipFiles(String archive, List<String> list){
        try(FileOutputStream fos = new FileOutputStream(archive);
            ZipOutputStream zos = new ZipOutputStream(fos)){
            for (String file_dir : list){
                try(FileInputStream fis = new FileInputStream(file_dir)){
                    ZipEntry entry = new ZipEntry(new File(file_dir).getName());
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    int i;
                    while ((i = fis.read()) != -1){
                        zos.write(i);
                    }
                    zos.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void saveGame(String dir, GameProgress gp){
        try(FileOutputStream fos = new FileOutputStream(dir);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(gp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
