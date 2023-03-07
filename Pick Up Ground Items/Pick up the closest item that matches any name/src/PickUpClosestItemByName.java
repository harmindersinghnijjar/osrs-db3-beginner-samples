import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Sleep;
import org.dreambot.api.wrappers.items.GroundItem;

// Script manifest is required to provide details about your script.
@ScriptManifest(name = "Name-Based Closest Item Pickup", description = "Pick up coins, bones, and cowhides by name.", author = "Harminder Singh Nijjar",  version = 0.1,
        category = Category.MISC)

public class PickUpClosestItemByName extends AbstractScript {

    @Override
    public int onLoop() {
        GroundItem item = GroundItems.closest("Coins", "Bones", "Cowhide");

        if (item != null) {
            item.interact("Take");
            Sleep.sleep(2000, 3000);
        }
        return 0;
    }

}