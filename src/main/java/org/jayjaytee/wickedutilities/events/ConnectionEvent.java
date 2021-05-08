package org.jayjaytee.wickedutilities.events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.jayjaytee.wickedutilities.commands.KeysCommand;
import org.jayjaytee.wickedutilities.utils.GameUtils;

public class ConnectionEvent extends Event {
    @SubscribeEvent
    public void onConnect(FMLNetworkEvent.ClientConnectedToServerEvent event){
        Minecraft minecraft = Minecraft.getMinecraft();
        System.out.println(minecraft.getCurrentServerData().serverIP.toLowerCase().contains("wicked"));
        if(GameUtils.checkForWicked()){
            KeysCommand.showKeys = true;
        }
    }
}
