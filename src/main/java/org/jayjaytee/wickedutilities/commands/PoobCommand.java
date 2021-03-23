package org.jayjaytee.wickedutilities.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import org.jayjaytee.wickedutilities.utils.GameUtils;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class PoobCommand implements ICommand {
    public static boolean test = false;

    @Override
    public String getName() {
        return "poob";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/" + getName();
    }

    @Override
    public List<String> getAliases() {
        return new java.util.ArrayList<>(Collections.singletonList("poob"));
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = (EntityPlayer) sender;
        if (GameUtils.checkForWicked()) {
            player.sendMessage(new TextComponentString("You are connected to WickedPrison!"));
            test = !test;
        } else {
            player.sendMessage(new TextComponentString("You are NOT connected to WickedPrison!"));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }


}
