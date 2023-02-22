import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

// Script manifest is required to provide details about your script.
@ScriptManifest(name = "Drop One Item", description = "Drop coins, drop first item in inventory except an axe.", author = "Harminder Singh Nijjar",  version = 0.1,
        category = Category.MISC, image = "")

public class DropOneItem extends AbstractScript {

    @Override
    public int onLoop() {
        Inventory.drop("Coins"); // Name

        Inventory.drop(995); // ID

        // Filter that will drop the first item in inventory that does not contain "axe" in its name.
        Inventory.drop((item) -> {
            return !item.getName().contains("axe");
        });
        return 0;
    }
}
