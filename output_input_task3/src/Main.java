import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        openZip("C:\\Users\\Logerasmo\\Desktop\\Games\\savegames\\zipo.zip",
                "C:\\Users\\Logerasmo\\Desktop\\Games\\savegames");
        System.out.println(openProgress("C:\\Users\\Logerasmo\\Desktop\\Games\\savegames\\save1.dat"));

    }
    public static GameProgress openProgress(String save_dir){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(save_dir))){
            return (GameProgress) ois.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void openZip(String zip_dir, String folder_dir){
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(zip_dir))){
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                String name = entry.getName();
                FileOutputStream fos = new FileOutputStream(folder_dir + "\\" + name);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fos.write(c);
                }
                fos.flush();
                fos.close();
                zis.closeEntry();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}