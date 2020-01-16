import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntroGUI extends JFrame {
    JTextField dialogue = new JTextField(30);
    JButton startGame;
    
    public IntroGUI() {
        super("Intro GUI");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dialogue.setText("Welcome adventurer...  to the world of Spiraphia.\n Let us begin by creating your first avatar...");
        add(dialogue);
        
        startGame = new JButton("Start");
        OpenGameGUI event = new OpenGameGUI();
        startGame.addActionListener(event);
        add(startGame);
        
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public class OpenGameGUI implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            GameGUI run = new GameGUI();
        }
    }
}
