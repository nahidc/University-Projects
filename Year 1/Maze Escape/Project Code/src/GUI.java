import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    JPanel mainMenu, gamePanel, imagePanel, titlePanel, buttonPanel;
    JButton startButton;
    JButton loadButton;
    JLabel title, img;
    ImageIcon image;
    
    public GUI() {
        super("Escape");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainMenu = new JPanel();
        mainMenu.setLayout(new BorderLayout());
        mainMenu.setBackground(Color.YELLOW);
        add(mainMenu);
        
        
        /* ------------- Game Panel --------------- */
        
        gamePanel = new JPanel();   
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setPreferredSize(new Dimension(250, 0));
        mainMenu.add(gamePanel, BorderLayout.WEST);
        
        
        /* ------------- Title Panel --------------- */
        
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setPreferredSize(new Dimension(0, 200));
        gamePanel.add(titlePanel, BorderLayout.NORTH);
        
        
        title = new JLabel("ESCAPE", JLabel.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        titlePanel.add(title, BorderLayout.CENTER);    
        
        
        /* ------------- BUTTON --------------- */
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.setBackground(Color.GREEN);
        buttonPanel.setPreferredSize(new Dimension(0, 200));
        gamePanel.add(buttonPanel, BorderLayout.SOUTH);
        
        startButton = new JButton("Start");
        OpenIntroGUI event = new OpenIntroGUI();
        startButton.addActionListener(event);
        buttonPanel.add(startButton);
        
        loadButton = new JButton("Load");
        OpenLoadGUI event2 = new OpenLoadGUI();
        loadButton.addActionListener(event2);
        buttonPanel.add(loadButton); 
        
        
        /* ------------- imagePanel --------------- */
        
        imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout());
        imagePanel.setBackground(Color.BLUE);
        mainMenu.add(imagePanel, BorderLayout.CENTER);
        
        image = new ImageIcon(getClass().getResource("Stickman.png"));
        img = new JLabel(image);
        imagePanel.add(img);
        
        /* ----------------------------------- */
        
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public class OpenIntroGUI implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            IntroGUI run = new IntroGUI();
            dispose();
        }
    }
    
    public class OpenLoadGUI implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            LoadGUI run = new LoadGUI();
            dispose();
        }
    }
    
    public static void main(String[] param) {
        GUI run = new GUI();
    }
}

