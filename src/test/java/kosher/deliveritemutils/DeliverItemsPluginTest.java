package kosher.deliveritemutils;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class DeliverItemsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(DeliverItemsPlugin.class);
		RuneLite.main(args);
	}
}