package com.danizml.mechanicalevents.storage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabCompleter implements org.bukkit.command.TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mevents")) {
            List<String> argList = new ArrayList<>();

            if (args.length == 1) {
                argList.add("config");
                argList.add("reload");
                argList.add("tools");
                argList.add("help");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }

            if (args.length == 2 && (args[0].equals("tools"))) {
                argList.add("tracker");
                argList.add("stickinfo");
                return argList;
            }

            if (args.length == 3 && (args[0].equals("tracker"))) {
                argList.add("on");
                argList.add("off");
                return argList;
            }
        }return null;
    }
}
