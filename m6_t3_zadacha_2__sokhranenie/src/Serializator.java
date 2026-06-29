import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Serializator {
    public void saveGame(String fullFilePath, GameProgress player) {
        File file = new File(fullFilePath);

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(player);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void zipFiles(String fullZipFilePath, List<String> savePlayers) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(fullZipFilePath))) {
            for (int i = 0; i < savePlayers.size(); i++) {
                FileInputStream fis = new FileInputStream(savePlayers.get(i));
                ZipEntry entry = new ZipEntry("pac_save" + (i + 1) + ".data");
                zout.putNextEntry(entry);

                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);

                zout.write(buffer);

                zout.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (String savePlayer : savePlayers) {
            if (savePlayer != null) {
                File savePlayerFile = new File(savePlayer);
                savePlayerFile.delete();
            }
        }
    }
}
