package newamazingpvp.lifestealsmp.EndBossFight.BossTimeEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class DeathBeaconEvent implements Listener{

    static boolean isBeaconOut = false;
    static int countdown = 999999;








    public static void triggerBeaconEvent(Player player) throws InterruptedException {

        if(!isBeaconOut){
            isBeaconOut=true;

            countdown=30;

            while(countdown > 0){

                if(countdown<11){
                    Bukkit.broadcastMessage(ChatColor.DARK_RED + "The death beacon will crack in" + countdown + "sec");
                }else{
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "The death beacon will crack in" + countdown + "sec");
                }



                countdown-=1;


                if(countdown==0) {
                    isBeaconOut = false;
                }


                Thread.sleep(1000);


            }
        }else{
            player.sendMessage(ChatColor.RED + "Can't use when there is already a beacon");
        }
    }




}
