import java.util.List;

public class Main {
    static void main(String[] args) {
        GameProgress playerOne = new GameProgress(100, 80, 6, 40.0);
        GameProgress playerTwo = new GameProgress(64, 45, 8, 22.5);
        GameProgress playerThree = new GameProgress(20, 36, 2, 10.2);

        String myPath = "/Users/ponomarenko/learning/actual/java/netology/classwork/mod_6_java_core/t3_potoki_vvoda_vyvoda_rabota_s_faylami_serializatsiya/m6_t3_potoki_vvoda_vyvoda__rabota_s_faylami__serializatsiya/m6_t3_zadacha_1__ustanovka/Games/savegames";

        Serializator serializator = new Serializator();

        serializator.saveGame(myPath + "/playerOne.data", playerOne);
        serializator.saveGame(myPath + "/playerTwo.data", playerTwo);
        serializator.saveGame(myPath + "/playerThree.data", playerThree);

        serializator.zipFiles(myPath + "/players.zip", List.of(
                myPath + "/playerOne.data",
                myPath + "/playerTwo.data",
                myPath + "/playerThree.data"
        ));
    }
}

