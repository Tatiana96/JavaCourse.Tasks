package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class TestFrame extends JFrame {
	
	static JPanel MainPanel;
	static JButton buttonImage;
 
    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        MainPanel = new JPanel(); 
        MainPanel.setLayout(new BorderLayout()); 
        
        JPanel ButtonPanel = new JPanel();
        
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        
        ButtonPanel.add(b1);
        ButtonPanel.add(b2);
        ButtonPanel.add(b3);
        
        
        MainPanel.add(ButtonPanel, BorderLayout.EAST);

        buttonImage = new JButton();
        buttonImage.setPreferredSize(new Dimension(300, 300));
        
        
        MainPanel.add(buttonImage, BorderLayout.WEST);
        
        b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon1 = createIcon("5.jpg");
		        buttonImage.setIcon(icon1);
			}
        });
        b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon1 = createIcon("6.jpg");
		        buttonImage.setIcon(icon1);
			}
        });
        b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon1 = createIcon("7.jpg");
		        buttonImage.setIcon(icon1);
			}
        });
 
        frame.getContentPane().add(MainPanel);
        frame.setPreferredSize(new Dimension(390, 135));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
     
    protected static ImageIcon createIcon(String path) {
        URL imgURL = TestFrame.class.getResource(path);     
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
 
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
