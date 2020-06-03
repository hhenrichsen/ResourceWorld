package me.nik.resourceworld.commands.subcommands;

import me.nik.resourceworld.ResourceWorld;
import me.nik.resourceworld.commands.SubCommand;
import me.nik.resourceworld.utils.GUIManager;
import me.nik.resourceworld.utils.Messenger;
import org.bukkit.entity.Player;

import java.util.List;

public class Menu extends SubCommand {

    private final ResourceWorld plugin;
    private final GUIManager guiManager;

    public Menu(ResourceWorld plugin) {
        this.plugin = plugin;
        this.guiManager = new GUIManager(plugin);
    }

    @Override
    public String getName() {
        return "menu";
    }

    @Override
    public String getDescription() {
        return "Open the Resource World Menu!";
    }

    @Override
    public String getSyntax() {
        return "/resource menu";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (!player.hasPermission("rw.admin")) {
            player.sendMessage(Messenger.message("no_perm"));
            return;
        }
        if (args.length == 1) {
            guiManager.openMainGUI(player);
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}