package org.jayjaytee.wickedutilities;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jayjaytee.wickedutilities.commands.KeysCommand;
import org.jayjaytee.wickedutilities.commands.PoobCommand;
import org.jayjaytee.wickedutilities.events.DisconnectEvent;
import org.jayjaytee.wickedutilities.utils.UIUtils;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@Mod(
        modid = WickedUtilities.MOD_ID,
        name = WickedUtilities.MOD_NAME,
        version = WickedUtilities.VERSION
)
public class WickedUtilities {

    public static final String MOD_ID = "wickedutilities";
    public static final String MOD_NAME = "WickedUtilities";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static WickedUtilities INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new PoobCommand());
        ClientCommandHandler.instance.registerCommand(new KeysCommand());
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new DisconnectEvent());
    }

    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event){
        Minecraft minecraft = Minecraft.getMinecraft();
        if(PoobCommand.test){
            minecraft.fontRenderer.drawString("Poob is ENABLED", 100, 100, Color.GREEN.getRGB());
        }
        if(KeysCommand.showKeys){
            EntityPlayer player = (EntityPlayer) minecraft.player;
            KeysCommand.getKeyAmount(player);
            FontRenderer renderer = Minecraft.getMinecraft().fontRenderer;
            /*UIUtils.drawChromaWaveString("Keys in Key Vault", 10, 10, true);
            UIUtils.drawChromaWaveString("Mine Keys: " + KeysCommand.mineKeys.toString(), 10, 30, false);
            UIUtils.drawChromaWaveString("Rare Keys: " + KeysCommand.rareKeys.toString(), 10, 40, false);
            UIUtils.drawChromaWaveString("Legendary Keys: " + KeysCommand.lKeys.toString(), 10, 50, false); */

            renderer.drawString("Keys in Key Vaults", 10, 10, Color.WHITE.getRGB(), true);

            renderer.drawString("Mine Keys ", 10, 30, Color.CYAN.getRGB());
            renderer.drawString(KeysCommand.mineKeys.toString(), renderer.getStringWidth("Mine Keys ")+10, 30, Color.LIGHT_GRAY.getRGB());

            renderer.drawString("Rare Keys ", 10, 40, Color.MAGENTA.getRGB());
            renderer.drawString(KeysCommand.rareKeys.toString(), renderer.getStringWidth("Rare Keys ")+10, 40, Color.LIGHT_GRAY.getRGB());

            renderer.drawString("Legendary Keys ", 10, 50, Color.RED.getRGB());
            renderer.drawString(KeysCommand.lKeys.toString(), renderer.getStringWidth("Legendary Keys ")+10, 50, Color.LIGHT_GRAY.getRGB());

        }

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
      /*
          public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
      */
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
      /*
          public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
          public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
      */
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
           /*
             event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
             event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
            */
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
           /*
             event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));
            */
        }
    }
    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
