import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

// Script manifest is required to provide details about your script.
@ScriptManifest(name = "Drop All Items", description = "Drop all coins, drop all items in inventory except axe.", author = "Harminder Singh Nijjar",  version = 0.1,
        category = Category.MISC, image = "")

public class DropAllItems extends AbstractScript {

    @Override
    public int onLoop() {
        Inventory.dropAll("Coins"); // Name
        Inventory.dropAll(995); // ID

        // Filter that will drop all items that aren't an axe
        Inventory.dropAll(item -> !item.getName().contains("axe"));
        return 0;
    }
}
