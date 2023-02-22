import jdk.jfr.internal.Logger;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Sleep;
import static org.dreambot.api.methods.interactive.Players.getLocal;
@ScriptManifest(name = "Depositing Items", description = "Open the nearest bank and deposit items.", author = "Harminder Singh Nijjar",  version = 0.1,
        category = Category.MISC, image = "")
public class BankDepositScript extends AbstractScript {

    @Override
    public int onLoop() {
        if (Bank.open()) {
            // If this returns true, that means the bank is open and ready
            Bank.deposit(995);          // Both of these will deposit one coin
            Bank.deposit("Coins");

            Bank.deposit(995, 10);      // Both of these will deposit 10 coins
            Bank.deposit("Coins", 10);

            Bank.depositAll(995);       // Both of these will deposit all coins
            Bank.depositAll("Coins");

            Bank.depositAllItems();     // This will deposit everything in your inventory
            Bank.depositAllEquipment(); // This will deposit all of your equipment

            // Once you are done depositing, you can close the bank
            Bank.close();

            //Log that we are done depositing
            log("Done depositing");
            // Sleep while the character is standing still or 5 minutes has passed
            Sleep.sleepWhile(() -> !Players.getLocal().isMoving(), 300000);



        } else {
            // If this returns false, that means the client is still walking
            // or interacting with the bank
            return 500;
        }

        return 500;

    }

}

