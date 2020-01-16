import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame {
    public GameGUI() {
        super("Game GUI");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true); 
    }
    
    public static void gameplay() {
        int stop = 0;
        Player player = new Player();
        Wall w1 = new Wall(1, 1);
        
        while(stop != 5) {
            player.movement();
           
            if((player.getXPosition() == w1.getXPosition()) && (player.getYPosition() == w1.getYPosition())) {
                player.wallCollision();
            }
            stop = player.getMoveChoice();
        }
    }
}
