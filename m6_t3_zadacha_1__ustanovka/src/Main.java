import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        String fullPath = "C:/Users/d.ponomarenko/work/napravleniya_raboty/my_personal_dannue/java/m4_t3_potoki_vvoda_vyvoda__rabota_s_faylami__serializatsiya/ver3/m6_t3_potoki_vvoda_vyvoda__rabota_s_faylami__serializatsiya/m6_t3_zadacha_1__ustanovka";

        List<String> directories = new ArrayList<>(List.of(
                fullPath + "/Games/src",
                fullPath + "/Games/res",
                fullPath + "/Games/savegames",
                fullPath + "/Games/temp"
        ));

        createDirectory(log, fullPath + "/Games/src");

        // 1. В папке `Games` создайте несколько директорий: `src`, `res`, `savegames`, `temp`.
        for (String directori : directories) {
            createDirectory(log, directori);
        }

        // 2. В каталоге `src` создайте две директории: `main`, `test`.
        createDirectory(log, fullPath + "/Games/src/main");
        createDirectory(log, fullPath + "/Games/src/test");

        // 3. В подкаталоге `main` создайте два файла: `Main.java`, `Utils.java`.
        File[] childsSrcMain = {
                new File(fullPath + "/Games/src/main/Main.java"),
                new File(fullPath + "/Games/src/main/Utils.java")
        };

        for (File child : childsSrcMain) {
            try {
                if (child.createNewFile()) {
                    log.append("Файл " + child.getName() + " создан в " + child.getPath() + "\n");
                } else {
                    log.append("Файл " + child.getName() + " НЕ создан в " + child.getPath() + "\n");
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        // 4. В каталог `res` создайте три директории: `drawables`, `vectors`, `icons`.
        createDirectory(log, fullPath + "/Games/res/drawables");
        createDirectory(log, fullPath + "/Games/res/vectors");
        createDirectory(log, fullPath + "/Games/res/icons");

        // 5. В директории `temp` создайте файл `temp.txt`.
        File[] childstemp = {
                new File(fullPath + "/Games/temp", "temp.txt")
        };

        for (File child : childstemp) {
            try {
                if (child.createNewFile()) {
                    log.append("Файл " + child.getName() + " создан в " + child.getPath() + "\n");
                } else {
                    log.append("Файл " + child.getName() + " НЕ создан в " + child.getPath() + "\n");
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        try (FileWriter writerLog = new FileWriter(fullPath + "/Games/temp/temp.txt", false)) {
            writerLog.write(log.toString());
            writerLog.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createDirectory(StringBuilder log, String path) {
        File file = new File(path);

        if (file.mkdir()) {
            log.append("Каталог " + file.getName() + " создан в " + file.getPath() + "\n");
        } else {
            log.append("Каталог " + file.getName() + " НЕ создан в " + file.getPath() + "\n");
        }
    }
}
