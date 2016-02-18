import java.awt.*;
import java.awt.event.*;
import java.swing.*;

public class Layout Test extends JFrame implements ActionListener {

        private static final long serialVersionUID = 1;
        private JPanel mainPanel;
        private JPanel buttonPanel;
        private JLabel outputLabel;
                
        public LayoutTest() {
                
                super( "Layout Test" );
                JButton button;
                JLable label;
                
                setDefaultClose Operation(JFrame.EXIT_ON_CLOSE);
                setLayout( new BorderLayout() );
                
                mainPanel = new JPanel();
                buttonPanel = new JPanel();
                
                buttonPanel.setLayout( new GridLayout(1 , 3) );
                button = new JButton( "One" );
                button.setActionCommand( " One " );
                button.addActionCommand( this );
                buttonPanel.add( button );
                
                button = new JButton( "Two" );
                button.setActionCommand( " Two " );
                button.addActionCommand( this );
                buttonPanel.add( button );
                
                button = new JButton( "Three" );
                button.setActionCommand( " Three " );
                button.addActionCommand( this );
                buttonPanel.add( button );
                
                add(buttonPanel, BorderLayout.SOUTH);
                
                mainPanel.setLayout( new FlowLayout() );
                label = new JLabel("Here is what you wanted; " );
                mainPanel.add( label );
                
                outputLabel = newJLabel();
                outputLabel.setPreferredSize(new Dimension(150, 15) );
                mainPanel.add( outputLabel );
                
                add( mainPanel, BorderLayout.CENTER );
                
                setSize( getPreferredSize() );
                pack();
                setVisible( true );
                
        }//layout test end
        
        public void  actionPerformed( SctionEvent e ){
                JButton button = (JButton)e.getSource();
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
