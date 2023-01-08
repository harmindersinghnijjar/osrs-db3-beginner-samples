// Import required packages
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Logger;

import javax.swing.*;

// Script Manifest is used to define the script's name, author, category, and version
@ScriptManifest (author = "Harminder Singh Nijjar", name = "Specific World Hopper", version = 0.1, category = Category.MISC, description = "Hop to a specific world.")
public class SpecificWorldHopper extends AbstractScript {
    // Declare variables
    private int world;
    // On start, get the world to hop to
    @Override
    public void onStart() {
        Logger.log("Starting Specific World Hopper");
        SwingUtilities.invokeLater(() -> createGUI());
    }

    // Create a GUI to get the world to hop to
    private void createGUI() {
        JFrame frame = new JFrame("Specific World Hopper");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        frame.add(panel);
        JLabel label = new JLabel("Enter the world you want to hop to: ");
        panel.add(label);
        JTextField textField = new JTextField(10);
        panel.add(textField);
        JButton button = new JButton("Hop");
        panel.add(button);
        button.addActionListener(e -> {
            world = Integer.parseInt(textField.getText());
            frame.dispose();
        });
    }

    // On loop, hop to the world
    @Override
    public int onLoop() {
    // If the current world is not 0
    if (world != 0) {
        // If the current world is not the world we want to hop to
        if (Worlds.getCurrentWorld() != world) {
            // Log that we are hopping to the world
            Logger.log("Hopping to world " + world);
            // Hop to the world
            WorldHopper.hopWorld(world);
        }
    }
    return 0;

    }

}
