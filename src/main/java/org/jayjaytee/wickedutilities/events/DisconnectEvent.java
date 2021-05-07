package org.jayjaytee.wickedutilities.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.jayjaytee.wickedutilities.commands.KeysCommand;

public class DisconnectEvent extends Event {
    @SubscribeEvent
    public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event){
        Minecraft minecraft = Minecraft.getMinecraft();
        if(KeysCommand.showKeys){ KeysCommand.showKeys = false; }
    }
}
