package org.jayjaytee.wickedutilities.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import org.jayjaytee.wickedutilities.utils.UIUtils;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class KeysCommand implements ICommand {
    public static boolean showKeys = false;

    public static Integer mineKeys = 0;
    public static Integer rareKeys = 0;
    public static Integer lKeys = 0;

    @Override
    public String getName() {
        return "keys";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/" + getName();
    }

    @Override
    public List<String> getAliases() {
        return new java.util.ArrayList<>(Collections.singletonList("keys"));
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        showKeys = !showKeys;
    }

    /*public static void getKeyAmountLine(ItemStack item, Integer line){
        String mine = item.getTagCompound().getCompoundTag("display").getTagList("Lore", 8).get(line).toString();
        String[] a = mine.split(" ");
        String[] b = a[2].split("/");
        String clean = b[0].replaceAll("\\D+","");
        if(line == 3) mineKeys = Integer.parseInt(UIUtils.removeLastCharacter(clean));
        if(line == 4) rareKeys = Integer.parseInt(UIUtils.removeLastCharacter(clean));
        if(line == 5) lKeys = Integer.parseInt(UIUtils.removeLastCharacter(clean));
    }*/

    public static void getKeyAmount(EntityPlayer player){
        mineKeys = 0;
        rareKeys = 0;
        lKeys = 0;
        NonNullList<ItemStack> items = player.inventory.mainInventory;
        for(ItemStack item : items) {
            if (item.getDisplayName().contains("Key Vault")) {

                String mine = item.getTagCompound().getCompoundTag("display").getTagList("Lore", 8).get(3).toString();
                String[] a = mine.split(" ");
                String[] b = a[2].split("/");
                String clean = b[0].replaceAll("\\D+", "");
                int mkeys = Integer.parseInt(UIUtils.removeLastCharacter(clean));

                String mine2 = item.getTagCompound().getCompoundTag("display").getTagList("Lore", 8).get(4).toString();
                String[] a2 = mine2.split(" ");
                String[] b2 = a2[2].split("/");
                String clean2 = b2[0].replaceAll("\\D+", "");
                int rkeys = Integer.parseInt(UIUtils.removeLastCharacter(clean2));

                String mine3 = item.getTagCompound().getCompoundTag("display").getTagList("Lore", 8).get(5).toString();
                String[] a3 = mine3.split(" ");
                String[] b3 = a3[2].split("/");
                String clean3 = b3[0].replaceAll("\\D+", "");
                int lekeys = Integer.parseInt(UIUtils.removeLastCharacter(clean3));

                mineKeys += mkeys;
                rareKeys += rkeys;
                lKeys += lekeys;

            }
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
