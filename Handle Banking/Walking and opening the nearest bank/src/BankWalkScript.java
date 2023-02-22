import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

// Script manifest is required to provide details about your script.
@ScriptManifest(name = "Open Closest Bank", description = "Walk to and open the nearest bank.", author = "Harminder Singh Nijjar",  version = 0.1,
        category = Category.MISC, image = "")
public class BankWalkScript extends AbstractScript {

    @Override
    public int onLoop() {
        if (Bank.open()) {
            // If this returns true, that means the bank is open and ready
            // You can see other things you can do now below
        } else {
            // If this returns false, that means the client is still walking
            // or interacting with the bank
            return 500;
        }

        return 500;
    }

}
