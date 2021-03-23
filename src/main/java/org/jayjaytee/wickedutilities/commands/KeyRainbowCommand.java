package org.jayjaytee.wickedutilities.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class KeyRainbowCommand implements ICommand {
    public static boolean isRainbow = false;

    @Override
    public String getName() {
        return "keyrainbow";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/"+getName();
    }

    @Override
    public List<String> getAliases() {
        return new java.util.ArrayList<>(Collections.singletonList("keyrainbow"));
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = (EntityPlayer) sender;
        isRainbow = !isRainbow;
        if(isRainbow) { player.sendMessage(new TextComponentString("Rainbow Keys Overlay ENABLED!").setStyle(new Style().setColor(TextFormatting.GREEN))); }
        if(!isRainbow) { player.sendMessage(new TextComponentString("Rainbow Keys Overlay DISABLED!").setStyle(new Style().setColor(TextFormatting.RED))); }
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
