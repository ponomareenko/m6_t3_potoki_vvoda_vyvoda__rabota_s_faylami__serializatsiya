import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static void main(String[] args) {
        StringBuilder log = new StringBuilder();

//        1. В папке `Games` создайте несколько директорий: `src`, `res`, `savegames`, `temp`.
        File[] childsGames = {
                new File("Games", "src"),
                new File("Games", "res"),
                new File("Games", "savegames"),
                new File("Games", "temp")
        };

        for (File child : childsGames) {
            if (child.mkdir()) {
                log.append("Каталог " + child.getName() + " создан в " + child.getPath() + "\n");
            } else {
                log.append("Каталог " + child.getName() + " НЕ создан в " + child.getPath() + "\n");
            }
        }

//        2. В каталоге `src` создайте две директории: `main`, `test`.
        File[] childsSrc = {
                new File("Games/src", "main"),
                new File("Games/src", "test")
        };

        for (File child : childsSrc) {
            if (child.mkdir()) {
                log.append("Подкаталог " + child.getName() + " создан в " + child.getPath() + "\n");
            } else {
                log.append("Подкаталог " + child.getName() + " НЕ создан в " + child.getPath() + "\n");
            }
        }

//        3. В подкаталоге `main` создайте два файла: `Main.java`, `Utils.java`.
        File[] childsSrcMain = {
                new File("Games/src/main", "Main.java"),
                new File("Games/src/main", "Utils.java")
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

//        4. В каталог `res` создайте три директории: `drawables`, `vectors`, `icons`.
        File[] childRes = {
                new File("Games/res", "drawables"),
                new File("Games/res", "vectors"),
                new File("Games/res", "icons"),
        };

        for (File child : childRes) {
            if (child.mkdir()) {
                log.append("Подкаталог " + child.getName() + " создан в " + child.getPath() + "\n");
            } else {
                log.append("Подкаталог " + child.getName() + " НЕ создан в " + child.getPath() + "\n");
            }
        }

//        5. В директории `temp` создайте файл `temp.txt`.
        File[] childstemp = {
                new File("Games/temp", "temp.txt")
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

        try (FileWriter writerLog = new FileWriter("Games/temp/temp.txt", false)) {
            writerLog.write(log.toString());
            writerLog.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}