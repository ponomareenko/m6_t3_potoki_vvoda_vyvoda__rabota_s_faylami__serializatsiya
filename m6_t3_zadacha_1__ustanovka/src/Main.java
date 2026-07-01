import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static public final String FILE_PATH = "/Users/ponomarenko/learning/actual/java/netology/classwork/mod_6_java_core/t3_potoki_vvoda_vyvoda_rabota_s_faylami_serializatsiya/ver4/m6_t3_potoki_vvoda_vyvoda__rabota_s_faylami__serializatsiya/m6_t3_zadacha_1__ustanovka";

    static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        String fullPath = "C:/Users/d.ponomarenko/work/napravleniya_raboty/my_personal_dannue/java/m4_t3_potoki_vvoda_vyvoda__rabota_s_faylami__serializatsiya/ver3/m6_t3_potoki_vvoda_vyvoda__rabota_s_faylami__serializatsiya/m6_t3_zadacha_1__ustanovka";

        List<String> directories = new ArrayList<>(List.of(
                "/Games/src",
                "/Games/res",
                "/Games/savegames",
                "/Games/temp",
                "/Games/src/main",
                "/Games/src/test",
                "/Games/res/drawables",
                "/Games/res/vectors",
                "/Games/res/icons"
        ));

        for (String directori : directories) {
            createDirectory(log, directori);
        }

        createFile(log, "/Games/src/main", "Main.java");
        createFile(log, "/Games/src/main", "Utils.java");
        createFile(log, "/Games/temp", "temp.txt");

        try (FileWriter writerLog = new FileWriter(FILE_PATH + "/Games/temp/temp.txt", false)) {
            writerLog.write(log.toString());
            writerLog.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createDirectory(StringBuilder log, String path) {
        File file = new File(FILE_PATH + path);

        if (file.mkdir()) {
            log.append("Каталог " + file.getName() + " создан в " + file.getPath() + "\n");
        } else {
            log.append("Каталог " + file.getName() + " НЕ создан в " + file.getPath() + "\n");
        }
    }

    public static void createFile(StringBuilder log, String path, String name) {
        File file = new File(FILE_PATH + path, name);

        try {
            if (file.createNewFile()) {
                log.append("Файл " + file.getName() + " создан в " + file.getPath() + "\n");
            } else {
                log.append("Файл " + file.getName() + " НЕ создан в " + file.getPath() + "\n");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
