package newamazingpvp.lifestealsmp.RaffleEvent;

import java.util.Random;

public class RaffleMain {


    public static boolean isRaffleEventRunning = false;

    public static int currentRaffleEventID;

    static Random random = new Random();


    public static void startRaffleEvent(){

        for (int i = 0; i < 11; i++) {

            int randomNumber = random.nextInt(10) + 1;
            currentRaffleEventID += randomNumber;

        }

        isRaffleEventRunning = true;

    }


}
