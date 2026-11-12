
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// A simple GUI for a text adventure game
public class TextAdventureGUI extends JFrame {

    // GUI components
    private JTextArea storyArea;
    private JTextField commandField;
    private JButton submitButton;
    private JButton restartButton;

    // Constructor: builds the game window
    public TextAdventureGUI() {
        setTitle("Text Adventure Game");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Dark theme colors
        Color backgroundColor = new Color(30, 30, 35);
        Color textColor = new Color(230, 230, 230);
        Color buttonColor = new Color(75, 90, 110);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(
                15, 15, 15, 15));

        // Story display area
        storyArea = new JTextArea();
        storyArea.setEditable(false);
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);
        storyArea.setBackground(new Color(40, 40, 45));
        storyArea.setForeground(textColor);
        storyArea.setCaretColor(textColor);
        storyArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        storyArea.setMargin(new Insets(10, 10, 10, 10));

        // Add a scroll bar to the story area
        JScrollPane scrollPane = new JScrollPane(storyArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Command input field
        commandField = new JTextField();
        commandField.setFont(new Font("Arial", Font.PLAIN, 15));
        commandField.setBackground(new Color(50, 50, 55));
        commandField.setForeground(textColor);
        commandField.setCaretColor(textColor);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBackground(buttonColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        // Restart button
        restartButton = new JButton("Restart");
        restartButton.setBackground(buttonColor);
        restartButton.setForeground(Color.WHITE);
        restartButton.setFocusPainted(false);

        // Bottom panel for commands and buttons
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBackground(backgroundColor);
        inputPanel.add(commandField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(submitButton);
        buttonPanel.add(restartButton);

        inputPanel.add(buttonPanel, BorderLayout.EAST);

        // Add components to the main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Submit when the button is clicked
        // or when Enter is pressed in the input field
        submitButton.addActionListener(e -> submitCommand());
        commandField.addActionListener(e -> submitCommand());

        // Restart the interface
        restartButton.addActionListener(e -> restartGame());

        // Show the starting message
        Game.gui = this;
        
        restartGame();
    }

    // Displays the player's command in the story area
    private void submitCommand() {
        String command = commandField.getText().trim();

        // Ignore empty commands
        if (command.isEmpty()) {
            return;
        }

        // Display the player's command
        output("\n> " + command);

        // Clear the input field
        commandField.setText("");

        // Send the command to the game
        Game.runGameGUI(command);

        // Scroll to the latest message
        storyArea.setCaretPosition(
            storyArea.getDocument().getLength()
        );

        commandField.requestFocusInWindow();
    }
    // Resets the GUI to its starting state
    private void restartGame() {
        storyArea.setText(
            "====================================\n" +
            "       TEXT ADVENTURE GAME\n" +
            "====================================\n\n" +
            "Welcome, adventurer!\n\n" +
            "You awaken in a mysterious place.\n" +
            "Dark trees surround you, and a narrow\n" +
            "path leads deeper into the forest.\n\n" +
            "What would you like to do?\n\n"
        );

        commandField.setText("");
        commandField.requestFocusInWindow();
        Game.printFile();
        Game.current = World.buildWorld();
        Game.inventory.clear();
        output(Game.current.toString());
    }

    // Main method: starts the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextAdventureGUI game = new TextAdventureGUI();
            game.setVisible(true);
        });
    }

    public void output(String message) {
        storyArea.append(message + "\n");
        storyArea.setCaretPosition(
            storyArea.getDocument().getLength()
        );
    }
	}

