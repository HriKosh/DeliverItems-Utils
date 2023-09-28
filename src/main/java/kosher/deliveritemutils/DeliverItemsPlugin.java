package kosher.deliveritemutils;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
        name = "DeliverItems Utils"
)
public class DeliverItemsPlugin extends Plugin {
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private UtilOverlay utilOverlay;
    @Inject
    private Client client;

    @Inject
    private DeliverItemsPluginConfig config;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(utilOverlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(utilOverlay);
    }

    @Provides
    DeliverItemsPluginConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(DeliverItemsPluginConfig.class);
    }
}
