package userInterface;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*; 
 
public class CardLayoutDemo implements ItemListener { 
    JPanel cards; 
   
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void addComponentToPane(Container pane) { 
        // поместить JComboBox в JPanel для наглядности
        JPanel comboBoxPane = new JPanel(); 
        String comboBoxItems[] = { "First Photo", "Second Photo", "Third Photo" }; 
        JComboBox cb = new JComboBox(comboBoxItems); 
        cb.setEditable(false); 
        cb.addItemListener(this); 
        comboBoxPane.add(cb); 
 
        // Создание "cards". 
        JPanel card1 = new JPanel(); 
	        JButton button1 = new JButton();
	       // button1.setPreferredSize(new Dimension(100, 100));
	        ImageIcon icon1 = createIcon("1.jpg");
	        button1.setIcon(icon1);
        card1.add(button1); 

 
        JPanel card2 = new JPanel(); 
	        JButton button2 = new JButton();
	       // button2.setPreferredSize(new Dimension(100, 100));
	        ImageIcon icon2 = createIcon("2.jpg");
	        button2.setIcon(icon2);
        card2.add(button2); 
        
        JPanel card3 = new JPanel(); 
	        JButton button3 = new JButton();
	        //button3.setPreferredSize(new Dimension(100, 100));
	        ImageIcon icon3 = createIcon("3.jpg");
	        button3.setIcon(icon3);
	    card3.add(button3); 
         
        // Создаем панель 
        cards = new JPanel(new CardLayout()); 
        cards.add(card1, "First Photo"); 
        cards.add(card2, "Second Photo"); 
        cards.add(card3, "Third Photo"); 
 
        pane.add(comboBoxPane, BorderLayout.PAGE_START); 
        pane.add(cards, BorderLayout.CENTER); 
    } 
     
    public void itemStateChanged(ItemEvent evt) { 
        CardLayout cl = (CardLayout)(cards.getLayout()); 
        cl.show(cards, (String)evt.getItem()); 
    } 
     
    private static void createAndShowGUI() { 
        // Создание и настройка окна 
        JFrame frame = new JFrame("CardLayoutDemo"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        CardLayoutDemo demo = new CardLayoutDemo(); 
        demo.addComponentToPane(frame.getContentPane()); 
         
        // Показ окна 
        frame.pack(); 
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
        try { 
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
        } catch (UnsupportedLookAndFeelException ex) { 
            ex.printStackTrace(); 
        } catch (IllegalAccessException ex) { 
            ex.printStackTrace(); 
        } catch (InstantiationException ex) { 
            ex.printStackTrace(); 
        } catch (ClassNotFoundException ex) { 
            ex.printStackTrace(); 
        } 
 
        UIManager.put("swing.boldMetal", Boolean.FALSE); 
 
        javax.swing.SwingUtilities.invokeLater(new Runnable() { 
            public void run() { 
                createAndShowGUI(); 
            } 
        }); 
    } 
}