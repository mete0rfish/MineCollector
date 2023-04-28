package com.doubledeltas.minecollector;

import com.doubledeltas.minecollector.command.CommandRoot;
import com.doubledeltas.minecollector.config.Config;
import com.doubledeltas.minecollector.data.DataManager;
import com.doubledeltas.minecollector.event.EventManager;
import com.doubledeltas.minecollector.item.ItemManager;
import com.doubledeltas.minecollector.item.manager.InlineItemManager;
import com.doubledeltas.minecollector.util.MessageUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class MineCollector extends JavaPlugin {
    private final ItemManager itemManager = new InlineItemManager();

    public static MineCollector getPlugin() {
        return MineCollector.getPlugin(MineCollector.class);
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    @Override
    public void onEnable() {
        DataManager.loadData();
        EventManager.loadEventHandlers();
        CommandRoot.loadCommands();
        Config.load();
        MessageUtil.log(Level.INFO, "마인콜렉터 플러그인이 켜졌습니다!");
    }

    @Override
    public void onDisable() {
        DataManager.saveAll();
        MessageUtil.log(Level.INFO, "마인콜렉터 플러그인이 꺼졌습니다.");
    }

}
