package xyz.sethy.devserver;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Sethy on 31/05/2017.
 */
public class Main extends JavaPlugin
{
    private static Main instance;

    public void onEnable()
    {
        instance = this;
    }

    public static Main getInstance()
    {
        return instance;
    }
}
