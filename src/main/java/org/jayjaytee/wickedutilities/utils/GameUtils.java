package org.jayjaytee.wickedutilities.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;

public class GameUtils {

    /*
    Checks for if the player is in the wicked server or not.
     */
    public static boolean checkForWicked(){
        Minecraft minecraft = Minecraft.getMinecraft();
        if(minecraft != null && minecraft.world != null && !minecraft.isSingleplayer()){
            ScoreObjective scoreObjective = minecraft.world.getScoreboard().getObjectiveInDisplaySlot(1);
            if(scoreObjective != null){
                String name = ScoreboardHandler.cleanSB(scoreObjective.getDisplayName());
                if(name.contains("WickedPrison")){
                    return true;
                }
            }
        }
        return false;
    }
}
