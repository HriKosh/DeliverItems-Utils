package kosher.deliveritemutils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.EnumSet;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.WorldType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.LineComponent;

class UtilOverlay extends Overlay
{
    private final Client client;
    private final DeliverItemsPluginConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private UtilOverlay(Client client, DeliverItemsPluginConfig config)
    {
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        this.client = client;
        this.config = config;
    }


    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();
        String overlayTitle = "Current Order Requester: " + config.Requester();

        // Build overlay title
        panelComponent.getChildren().add(TitleComponent.builder()
                .text(overlayTitle)
                .color(Color.GREEN)
                .build());

        // Set the size of the overlay (width)
        panelComponent.setPreferredSize(new Dimension(
                graphics.getFontMetrics().stringWidth(overlayTitle) + 30,
                0));

        // Add a line on the overlay for world number
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Location: ")
                .right(config.location())
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Items:")
                .right(config.items())
                .build());

        return panelComponent.render(graphics);
    }
}