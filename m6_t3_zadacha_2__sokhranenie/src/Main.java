import java.util.List;

public class Main {
    static public final String FILE_PATH = "/Users/ponomarenko/learning/actual/java/netology/classwork/mod_6_java_core/t3_potoki_vvoda_vyvoda_rabota_s_faylami_serializatsiya/ver4/m6_t3_potoki_vvoda_vyvoda__rabota_s_faylami__serializatsiya/m6_t3_zadacha_1__ustanovka/Games/savegames";

    static void main(String[] args) {
        GameProgress playerOne = new GameProgress(100, 80, 6, 40.0);
        GameProgress playerTwo = new GameProgress(64, 45, 8, 22.5);
        GameProgress playerThree = new GameProgress(20, 36, 2, 10.2);

        Serializator serializator = new Serializator();

        serializator.saveGame(FILE_PATH + "/playerOne.data", playerOne);
        serializator.saveGame(FILE_PATH + "/playerTwo.data", playerTwo);
        serializator.saveGame(FILE_PATH + "/playerThree.data", playerThree);

        serializator.zipFiles(FILE_PATH + "/players.zip", List.of(
                FILE_PATH + "/playerOne.data",
                FILE_PATH + "/playerTwo.data",
                FILE_PATH + "/playerThree.data"
        ));
    }
}

