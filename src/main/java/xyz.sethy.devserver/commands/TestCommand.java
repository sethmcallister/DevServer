package xyz.sethy.devserver.commands;

import io.fabric8.kubernetes.api.model.DoneableNode;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Sethy on 31/05/2017.
 */
public class TestCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, Command command, String s, String[] args)
    {
        if(args.length != 2)
        {
            sendUsage(sender);
            return true;
        }
        switch (args[0].toLowerCase())
        {
            case "hcf":
            {
                handleHCFStartup(sender, args);
                break;
            }
            default:
            {
                sendUsage(sender);
                break;
            }
        }
        return true;
    }

    private void sendUsage(final CommandSender sender)
    {
        sender.sendMessage(ChatColor.RED + "Usage: /test <Plugin> <Version>");
    }

    private void handleHCFStartup(final CommandSender sender, final String[] args)
    {
        final Config config = new ConfigBuilder().withMasterUrl("https://intra.sethy.xyz/configuarion/hcf/" + args[1]).build();
        final KubernetesClient client = new DefaultKubernetesClient(config);
        final DoneableNode node = client.nodes().createNew();
        //No idea if this is actually correct; I'll read up on this today.
    }
}
