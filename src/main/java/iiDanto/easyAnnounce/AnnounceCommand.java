package iiDanto.easyAnnounce;

import io.papermc.paper.event.player.AsyncChatCommandDecorateEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Sound.BLOCK_NOTE_BLOCK_PLING;

public class AnnounceCommand implements CommandExecutor {

    private final EasyAnnounce plugin;

    public AnnounceCommand(EasyAnnounce plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player){
            if (args.length == 1){
                String prefix = plugin.getConfig().getString("prefix");
                plugin.getServer().broadcastMessage(prefix + args);
                for (Player player : plugin.getServer().getOnlinePlayers()) {
                    if (plugin.getConfig().getBoolean("actionbar") == true){
                        player.sendActionBar(ChatColor.GREEN + "An announcement has just been made.");
                    }
                    if (plugin.getConfig().getBoolean("sound") == true){
                        player.playSound(player.getLocation(), BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                    }
                }
            }
        }
        return true;
    }
}
