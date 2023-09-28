package kosher.deliveritemutils;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface DeliverItemsPluginConfig extends Config {
    @ConfigItem(
            keyName = "Requester",
            name = "Requester of the delivery",
            description = "the person who requests the delivery"
    )
    default String Requester() {
        return "";
    }

    @ConfigItem(
            keyName = "location",
            name = "Location of the delivery",
            description = "you must be dumb to not understand what this is")
    default String location() {
        return "";
    }

    @ConfigItem(
            keyName = "items",
            name = "Items",
            description = "items :thumbsup:"
    )
    default String items() {
        return "";
    }
    @ConfigItem(
            position = 1,
            keyName = "showWorldType",
            name = "Show the current world type",
            description = "Toggle the display of the current world type"
    )
    default boolean showWorldType()
    {
        return false;
    }
}
