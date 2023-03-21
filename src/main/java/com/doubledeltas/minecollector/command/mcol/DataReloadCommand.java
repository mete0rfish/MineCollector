package com.doubledeltas.minecollector.command.mcol;

import com.doubledeltas.minecollector.command.GameCommand;
import com.doubledeltas.minecollector.constant.Titles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class DataReloadCommand extends GameCommand {
    @Override
    public String getCommandName() {
        return "data";
    }

    @Override
    public boolean onRawCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Titles.MSG_PREFIX + "데이터 리로드");
        
        return false;
    }
}
