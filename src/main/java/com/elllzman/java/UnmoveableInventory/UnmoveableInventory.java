package com.elllzman.java.UnmoveableInventory;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Created by Elliot on 17/06/2014.
 */
public class UnmoveableInventory extends JavaPlugin implements Listener {

    public static boolean isEnabled = false;


    public void onEnable()
    {
        logger("Unmoveable inventory has  been invoked");
        getServer().getPluginManager().registerEvents(this, this);
    }

    public boolean getState()
    {
        return isEnabled();
    }

    public void logger(String s)
    {
        getLogger().info(s);
        return;
    }

    @EventHandler
    public void moveEvent(InventoryMoveItemEvent event)
    {
        if(getState())
        {
            event.setCancelled(true);
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("UMI"))
        {
            if(getState()==false)
            {
                getServer().broadcastMessage(ChatColor.GOLD + "Unmoveable inventory has been enabled!");
                isEnabled = true;
                return true;
            }
            if(getState()==true) {
                getServer().broadcastMessage(ChatColor.GOLD + "Unmoveable inventory has been disabled");
                isEnabled = false;
                return true;
            }

        }
        return true;
    }
}