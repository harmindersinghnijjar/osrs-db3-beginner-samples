// Import required packages
package Random;
import org.dreambot.api.methods.world.World;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Logger;

import javax.swing.*;

// Script Manifest is used to define the script's name, author, category, and version
@ScriptManifest (author = "Harminder Singh Nijjar", name = "Random World Hopper", version = 0.1, category = Category.MISC, description = "Hop to a random world.")
public class RandomWorldHopper extends AbstractScript{
    // Declare variables
    private String membershipStatus;
    // On start, get membership status
    @Override
    public void onStart() {
        Logger.log("Starting Random World Hopper");
        SwingUtilities.invokeLater(() -> createGUI());
    }

    // Create a GUI to get the membership status
    private void createGUI() {
        JFrame frame = new JFrame("Random World Hopper");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        frame.add(panel);
        JLabel label = new JLabel("Are you a member? ");
        panel.add(label);
        JTextField textField = new JTextField(10);
        panel.add(textField);
        JButton button = new JButton("Hop");
        panel.add(button);
        button.addActionListener(e -> {
            membershipStatus = String.valueOf(textField.getText());
            frame.dispose();
        });
    }
    // On loop, hop to the world
    @Override
    public int onLoop() {
        // If player is a member
        if (membershipStatus.toLowerCase().equals("yes")) {
            World world = Worlds.getRandomWorld(World::isMembers);
                // Log that we are hopping to the world
                Logger.log("Hopping to world " + world);
                // Hop to the world
                WorldHopper.hopWorld(world);
            }
        // If player is not a member
        else if (membershipStatus.toLowerCase().equals("no")) {
            World world = Worlds.getRandomWorld(World::isF2P);
                // Log that we are hopping to the world
                Logger.log("Hopping to world " + world);
                // Hop to the world
                WorldHopper.hopWorld(world);
            }
        // Sleep for 5 minutes
        return 300000;
        }


}
