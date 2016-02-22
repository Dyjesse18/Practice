import java.awt.*;
import java.awt.event.*;
import java.swing.*;

public class Layout Test extends JFrame implements ActionListener {
        
        // Private variables
        private static final long serialVersionUID = 1;
        private JPanel mainPanel;
        private JPanel buttonPanel;
        private JLabel outputLabel;
                
        public LayoutTest() {
                
                //constructor
                super( "Layout Test" );
                JButton button;
                JLable label;
                
                //allows  window to be closed
                setDefaultClose Operation(JFrame.EXIT_ON_CLOSE);
                setLayout( new BorderLayout() );
                
                //creates the main penel
                mainPanel = new JPanel();
                buttonPanel = new JPanel();
                buttonPanel.setLayout( new GridLayout(1 , 3) );
                
                //creates button 1
                button = new JButton( "One" );
                button.setActionCommand( " One " );
                button.addActionCommand( this );
                buttonPanel.add( button );
                
                //creates button 2
                button = new JButton( "Two" );
                button.setActionCommand( " Two " );
                button.addActionCommand( this );
                buttonPanel.add( button );
                
                //creates button 3
                button = new JButton( "Three" );
                button.setActionCommand( " Three " );
                button.addActionCommand( this );
                buttonPanel.add( button );
                
                //adds buttons
                add(buttonPanel, BorderLayout.SOUTH);
                
                //creates label
                mainPanel.setLayout( new FlowLayout() );
                label = new JLabel("Here is what you wanted; " );
                mainPanel.add( label );
                
                //creates outputlabel
                outputLabel = newJLabel();
                outputLabel.setPreferredSize(new Dimension(150, 15) );
                mainPanel.add( outputLabel );
                
                //adds the main panel
                add( mainPanel, BorderLayout.CENTER );
                
                //sizes the window to the prefered size
                setSize( getPreferredSize() );
                //packs all the components together
                pack();
                //makes the window visible
                setVisible( true );
                
        }//layout test end
        
        public void  actionPerformed( SctionEvent e ){
                JButton button = (JButton)e.getSource();
                
                //button actions 
                switch(button.getActionCommand() ) {
                        case " One ":
                                outputLabel.setText("Blaahhhhh1");
                                break;
                        case " Two ":
                                outputLabel.setText("Blaahhhhh2");
                                break;
                        case " Three ":
                                outputLabel.setText("Blaahhhhh3");
                                break;
                        default:
                                JOptionPane.showMessageDialog( this, "WHERE ARE YOU! THIS DOESNT EXIST!OH GOD HOW DID YOU GET HERE" );
                                break;
                }//end of switch
                
        }//end of action performed
        
        
        public static void main(String[] args) {
                
                new LayoutTest();
                
        }//main method end

}//layout test extend end
