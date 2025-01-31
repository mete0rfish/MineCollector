package com.doubledeltas.minecollector.balance;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;

public class VaultDirector {

    private final static double NORMAL_ITEM_COLLECT_PRIZE = 1000;

    public static double addFirstCollectBalance(Player target) {
        Economy econ = VaultManager.getEconomy();
        econ.depositPlayer(target, NORMAL_ITEM_COLLECT_PRIZE);
        return econ.getBalance(target);
    }
}
