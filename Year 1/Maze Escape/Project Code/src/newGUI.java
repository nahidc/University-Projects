import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class newGUI extends JFrame { 
    JPanel mmPanel, introPanel, gamePanel;
    JPanel imgPanel, selPanel;
    
    public newGUI() {
        super("Escape");
        getContentPane().setBackground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* --------------- Main Menu Panel ------------------ */
        //mmPanel = new JPanel(); 
        //mmPanel.setLayout(new GridLayout(1,2));
        //mmPanel.setBackground(Color.BLUE);
        //add(mmPanel);
        
        /* --------------- Main Menu Image Panel -------------- */
        //imgPanel = new JPanel();
        //imgPanel.setBackground(Color.YELLOW);
        //mmPanel.add(imgPanel, BorderLayout.EAST);
        
        /* ---------------- Title + Buttons Main Menu Panel ----------- */
        //selPanel = new JPanel();
        //selPanel.setBackground(Color.BLACK);
        //mmPanel.add(selPanel, BorderLayout.WEST);
        
        
                
        /*introPanel = new JPanel();
        introPanel.setBackground(Color.RED);
        add(introPanel);
        
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.ORANGE);
        add(gamePanel);
        */
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);  
    }
    
    
    public static void main(String[] param) {
        new newGUI();
    }
}
