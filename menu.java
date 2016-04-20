import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class menu 
{	
	
    public static void main(String[] args)
    {
                SoundBoxFrame frame = new SoundBoxFrame();
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
    }

	

}

class SoundBoxFrame extends JFrame implements ActionListener
{
    private JPanel buttonPanel;
	private JPanel infoPanel;
	@SuppressWarnings("unused")
	private JPanel drawPanel;
	
	private String Title;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	private String  MenuTitle ;
	private JPanel DrawingPanel;
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
	

    
    public SoundBoxFrame()
    {
    	setBackground(Color.BLACK);
    	this.setMinimumSize(new Dimension(300,300));
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Drawing");
        
        buttonPanel = new JPanel();
        infoPanel = new JPanel();
        DrawingPanel = new JPanel();
        
        
        menuBar = new JMenuBar();
        menu = new JMenu( "My Menu" );
        makeMenuItem("Help");
        makeMenuItem("Close");
        makeMenuItem("Change Color");        
       
        makeDrawingPanel();
        makeLable("You have Selected:" + Title);
        makeSoundButton("Rectangle");
        makeSoundButton("Circle");
        makeSoundButton("Trainagle");
        makeSoundButton("Star");
        
        
        JToggleButton confirm = new JToggleButton("Confirm your shape");
        confirm.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent event)
        			{
        				if(confirm.isSelected())
        				{
        					System.out.println("Drawing ON");
        					//turns on some boolean that will allow user to draw
        				}else{
        					System.out.println("drawing Off");
        					//turns off the boolean that allows user to draw
        				}//end of else
        				
        			}//action performed
        		});//add action listener
       
        add(infoPanel);
        add(buttonPanel); 
        buttonPanel.add(confirm);
        add(DrawingPanel);
        this.setJMenuBar( menuBar );
    }//end of SoundFrame
    
    private void makeDrawingPanel() 
    {
        this.setSize( 500, 500 );
        setVisible( true );
        
	}//end of MakeDrawingPanel

	private void makeMenuItem(String MenuTitle) {

        
        menuItem = new JMenuItem( MenuTitle );
        menuItem.setActionCommand( "MenuSomething" + MenuTitle );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        menu.add( menuItem );
        menuBar.add( menu );

        this.setJMenuBar( menuBar );
	}//end of make MenuItem

	private void makeLable(String labell) {
    		JLabel label= new JLabel(labell);
    		label.setFont(new Font("TimesRoman", Font.BOLD, 24));
        	infoPanel.add(label);
	}//end of make Label

	public void makeSoundButton(String Title)
    {
        JButton button = new JButton(Title);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener()
            {	
        	
        		
                private AbstractButton confirm;
				public void actionPerformed(ActionEvent event)
                {	
                	
                	System.out.println(Title);
                    try {
                    	switch(button.getActionCommand()){
                    	case "Circle":
                    		DrawCircle();
                    		break;
                    	case "Rectangle":
                    		DrawRectangle();
                    		break;
                    	case "Triangle":
                    		DrawTriangle();
                    		break;
                    	case "Star":
                    		break;
                    	}//end of switch
                    }//end of try
                    catch (Exception e) {
                        
                    }//end of catch
                    
                }//end of action performed

				private void DrawTriangle() {
					
				}

				private void DrawRectangle() {
					if (confirm.isSelected())
					{
						
					}
				}

				private void DrawCircle() {
					if (confirm.isSelected())
					{
						
					}//end of if confirm selected
				}//end of Draw Circle

            });//end of Action Listener
            
    }//end of MakeSoundButton

	@Override
	public void actionPerformed(ActionEvent AC) {
		System.out.println("Roadhouse");
		if(MenuTitle=="Close")
		{
			System.exit(0);
		}
	}
}//end of SoundFrame
