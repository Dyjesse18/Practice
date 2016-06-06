import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class Survive {	
    public static void main(String[] args){
    	SoundBoxFrame frame = new SoundBoxFrame();
        frame.setMinimumSize(new Dimension (500, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }//end of main
}//end of menu class

class ImagePanelA extends JPanel {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;

	   public ImagePanelA(Image image) {
		   this.image = image;
	   }
		   @Override
		   public Dimension getPreferredSize() {
		      Dimension superSize = super.getPreferredSize();
		      if (isPreferredSizeSet() || image == null) {
		         return superSize;
		      }
		      int prefW = Math.max(image.getWidth(null), superSize.width);
		      int prefH = Math.max(image.getHeight(null), superSize.height);
		      return new Dimension(prefW, prefH);
		  }

		   @Override
		   protected void paintComponent(Graphics g) {
		      super.paintComponent(g);
		      if (image != null) {
		         g.drawImage(image, 0, 0, null);
		      }
		   }
	   
	   
}
class SoundBoxFrame extends JFrame {																												
	private JPanel godPanel;
    private JPanel buttonPanel;
	private JPanel infoPanel;
	private String Title;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	private JLabel labella;
	public double x;
	public double y;
	protected JColorChooser tcac;
	protected JPanel Chooser;
	protected Random Number;
	protected int food = 10;
	protected int Supplies= 6;
	protected int die2;
	protected int Survivors =1;
	private JPanel Builder;
	private JLabel labella2;
	private JPanel FoodPanel;
	private JLabel labella3;
	private JLabel labella4;
	private JPanel SuppliesPanel;
	private JPanel SurvivorPanel;

	protected boolean flagFire;
	protected boolean flagCampfire;
	protected boolean flagFirePlace;
	protected boolean flagShelter;
	protected boolean flagGoodShelter;
	protected boolean flagMasterShelter;
	protected boolean flagFarm;
	protected boolean flagGoodFarm;
	protected boolean flagMasterFarm;
	protected boolean FarmOn;
	protected int Farmnum;
	private JPanel PicturePanel;
	private String PictureUpdate;
	private JLabel labella5;
	private JPanel dayPanel;
	protected int days;
	protected int people;
	private JPanel PicturePanel11;
	private JLabel labella6;
	protected static String loot;
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 800;
	public SoundBoxFrame(){
		

    	GridBagLayout layout = new GridBagLayout();															 
    	setBackground(Color.BLACK);
    	this.setMinimumSize(new Dimension(600,400));
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Survive and Rise");
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\SJHSStudent\\workspace\\sdf\\bXWFwBT.jpg"));
        } catch (IOException e) {
        }
        
        //background=new ImagePanelA (img);
        //add(background);
        //background=new JLabel("TEST");

        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); 
        
        infoPanel = new JPanel();
        infoPanel.setOpaque(false); 
        Builder = new JPanel();
        Builder.setOpaque(false); 
        SurvivorPanel = new JPanel();
        SurvivorPanel.setOpaque(false); 
        SuppliesPanel= new JPanel();
        SuppliesPanel.setOpaque(false); 
        FoodPanel = new JPanel();
        FoodPanel.setOpaque(false);
        PicturePanel = new JPanel();
        PicturePanel.setOpaque(false);
        PicturePanel11 = new JPanel();
        PicturePanel11.setOpaque(false);
        dayPanel = new JPanel();
        dayPanel.setOpaque(false);
        //godPanel = new JPanel(); 
        godPanel=new ImagePanelA (img);
        godPanel.setLayout(layout); 
        menuBar = new JMenuBar();
        menu = new JMenu( "My_Menu" );
        makeMenuItem("Close");
        makeMenuItem("Help");	
        
    if(Title==null){
   	    makeLabel("Welcome to Survive And Rise");
    }//title is null end
        makeShapeButton("Begin Turn");
        makeShapeButton("Build");
        makeBuild("Shelter", PictureUpdate);
        makeBuild("GoodShelter", PictureUpdate);
        makeBuild("MasterShelter", PictureUpdate);
        makeBuild("Farm", PictureUpdate);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
        		new ImageIcon("axe.png").getImage(),
        		new Point(0,0),"custom cursor"));
        makeConstrains();
        
    }//end of SoundFrame
	private void PlaySound(String soundFilePath)
    {
    	try
        {  
    		File soundFile = new File(soundFilePath);
    		AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
    		System.out.println("Loaded_" + soundFile.getName());
                      
    		//gets the data for the clip
    		DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());

                
    		Clip clip = (Clip) AudioSystem.getLine(info);
                
    		clip.open(sound);
    		System.out.println("Opening_" + soundFile.getName());   
    		clip.start();
        }catch (Exception e) 
                {
                   System.out.println("Fail sound");
                }//end of MalformedURLException
    }//end of playSound
	private void makeBuild(String Title1, final String soundPathFile) {
		JButton button1 = new JButton(Title1);
		Builder.add(button1);
        button1.addActionListener(new ActionListener()
            {	
        		
				

				public void actionPerformed(ActionEvent event)
                {	
					PlaySound(soundPathFile);
					switch(Title1){
					case "Shelter":
						makeLabel("Building a shelter will cost 4 Supplies");
						flagShelter= true;
						System.out.println("Shelter");
						break;
					case "GoodShelter":
						makeLabel("Building a Good shelter will cost 8 Supplies");
						flagGoodShelter= true;
						System.out.println("GoodShelter");
						break;
					case "MasterShelter":
						makeLabel("Building a Master shelter will cost 12 Supplies");
						flagMasterShelter= true;
						System.out.println("MatserShelter");
						break;
					case "Farm":
						makeLabel("Building a Farm will cost 8 Supplies and 4 food");
						flagFarm= true;
						System.out.println("Farm");
						break;
					}
					
					
                }
					
                });
	}
	private void makeConstrains(){
    	GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints c1 = new GridBagConstraints();
    	GridBagConstraints c2 = new GridBagConstraints();
    	GridBagConstraints c3 = new GridBagConstraints();
    	GridBagConstraints c4 = new GridBagConstraints();
    	GridBagConstraints c5 = new GridBagConstraints();
    	GridBagConstraints c6 = new GridBagConstraints();
    	GridBagConstraints c7 = new GridBagConstraints();
    	GridBagConstraints c8 = new GridBagConstraints();
    	
    	c.weightx = 0;
       	c.weighty = 0;
      	c.gridx = 0;
  		c.gridy =0;
  		c.gridwidth = 1;
       	c.gridheight = 1;
       	c.fill = GridBagConstraints.BOTH;
       	godPanel.add(buttonPanel,c);
       	
        c1.weightx = 0;
        c1.weighty = 0;
        c1.gridx = 0;
        c1.gridy =3;
        c1.gridwidth = 1;
        c1.gridheight = 1;
        c1.fill = GridBagConstraints.BOTH;
        godPanel.add(SurvivorPanel,c1);
         
        c2.weightx = 0;
        c2.weighty = 0;
        c2.gridx = 0;
        c2.gridy =2;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.anchor = GridBagConstraints.SOUTH;
        godPanel.add(infoPanel,c2);
        
        c3.weightx = 0;
       	c3.weighty = 0;
      	c3.gridx = 0;
  		c3.gridy =4;
  		c3.gridwidth = 1;
       	c3.gridheight = 1;
       	c3.fill = GridBagConstraints.BOTH;
       	godPanel.add(FoodPanel,c3);
       	
       	c4.weightx = 0;
       	c4.weighty = 0;
      	c4.gridx = 0;
  		c4.gridy =5;
  		c4.gridwidth = 1;
       	c4.gridheight = 1;
       	c4.fill = GridBagConstraints.BOTH;
       	godPanel.add(SuppliesPanel,c4);
       	
       	c5.weightx = 0;
       	c5.weighty = 0;
      	c5.gridx = 0;
  		c5.gridy =6;
  		c5.gridwidth = 1;
       	c5.gridheight = 1;
       	c5.fill = GridBagConstraints.BOTH;
       	godPanel.add(Builder,c5);
       	
       	c6.weightx = 0;
       	c6.weighty = 0;
      	c6.gridx = 0;
  		c6.gridy =9;
  		c6.gridwidth = 1;
       	c6.gridheight = 1;
       	c6.fill = GridBagConstraints.BOTH;
       	godPanel.add(PicturePanel,c6);
       	
       	c7.weightx = 0;
       	c7.weighty = 0;
      	c7.gridx = 0;
  		c7.gridy =9;
  		c7.gridwidth = 1;
       	c7.gridheight = 1;
       	c7.fill = GridBagConstraints.BOTH;
       	godPanel.add(dayPanel,c7);
       	
       	c8.weightx = 0;
       	c8.weighty = 0;
      	c8.gridx = 0;
  		c8.gridy =8;
  		c8.gridwidth = 1;
       	c8.gridheight = 1;
       	c8.fill = GridBagConstraints.BOTH;
       	godPanel.add(PicturePanel11,c8);
       	
           
        add(godPanel);
        this.setJMenuBar( menuBar );
    }																																								
	private void makeMenuItem(String MenuTitle) {  
        menuItem = new JMenuItem( MenuTitle );
        menuItem.setActionCommand( "MenuSomething" + MenuTitle );
        menuItem.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println(MenuTitle);
																												
				if(MenuTitle=="Close"){
					//closes program
					System.exit(0);
				}//end of if MenuTitle equals close
				
				if(MenuTitle=="Help"){
					makeLabel("No_Help_For_You");
				}//end of if MenuTitle equals help
			}//action performed
		});//add action listener
        																										
        menu.add(menuItem);
        menu.add( menuItem );
        menuBar.add( menu );        
	}//end of make MenuItem																												
	private void makeLabel(String label2) {
		if(labella!= null){
    		labella.setText(label2);
    	}else{
    			labella = new JLabel(label2);
    			labella.setFont(new Font("TimesRoman", Font.BOLD, 24));
    			labella.setForeground(Color.WHITE);
    			infoPanel.add(labella);
    		}//end of if else
	}//end of make Label
	private void makeLabel2(String label1) {
		if(labella2!= null){
    		labella2.setText(label1);
    	}else{
    			labella2 = new JLabel(label1);
    			labella2.setFont(new Font("TimesRoman", Font.BOLD, 24));
    			labella2.setForeground(Color.WHITE);
    			labella2.setIcon(new ImageIcon("C:\\Users\\SJHSStudent\\workspace\\sdf\\kingswood.png"));
    			SuppliesPanel.add(labella2);
    			
    		}//end of if else
	}//end of make Label	
	private void makeLabel3(String label3) {
		if(labella3!= null){
    		labella3.setText(label3);
    	}else{
    			labella3 = new JLabel(label3);
    			labella3.setFont(new Font("TimesRoman", Font.BOLD, 24));
    			labella3.setForeground(Color.WHITE);
    			labella3.setIcon(new ImageIcon("C:\\Users\\SJHSStudent\\workspace\\sdf\\industry_food_blue.png"));
    			FoodPanel.add(labella3);
    			
    		}//end of if else
	}//end of make Label
	private void makeLabel4(String label4) {
		if(labella4!= null){
    		labella4.setText(label4);
    	}else{
    			labella4 = new JLabel(label4);
    			labella4.setFont(new Font("TimesRoman", Font.BOLD, 24));
    			labella4.setForeground(Color.WHITE);
    			labella4.setIcon(new ImageIcon("C:\\Users\\SJHSStudent\\workspace\\sdf\\people-icon-10047.png"));
    			SurvivorPanel.add(labella4);
    			
    		}//end of if else
	}//end of make Label
	private void makeLabel5() {
		if(labella5!= null){
			labella5.setIcon(new ImageIcon(PictureUpdate));
    	}else{
    			labella5 = new JLabel();
    			labella5.setIcon(new ImageIcon(PictureUpdate));
    			PicturePanel.add(labella5);
    	}
    			
	}//end of make Label	
	private void makeLabel6(String label6) {
		if(labella6!= null){
    		labella6.setText(label6);
    	}else{
    			labella6 = new JLabel(label6);
    			labella6.setFont(new Font("TimesRoman", Font.BOLD, 24));
    			labella6.setForeground(Color.WHITE);
    			PicturePanel11.add(labella6);
    		}//end of if else
	}//end of make Label
	
	
	private void makeShapeButton(String Title )
    {
		
        JButton button = new JButton(Title);
        if(Title=="Begin Turn")
        {
        	button.setIcon(new ImageIcon("C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\Start_here_media_playback.png"));
        }
        if(Title=="Build"){
        	button.setIcon(new ImageIcon("C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\50px-Equip_ori_razvad_ca.png"));
        }
        buttonPanel.add(button);
        button.addActionListener(new ActionListener()
        
            {	
				private int die1;
				public void actionPerformed(ActionEvent event)
                {	
					days++;
					makeLabel6("You survived " + days + " days");
					System.out.println("You lived " +days + " days");
	               if(food<=0)
						{
							System.out.println("You Lose");
							makeLabel("You starved and Died out");
							
							    try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
								System.exit(0);                 
							   return;
						}//if lose
						if(Survivors<=0)
							{
								System.out.println("You Lose");
								makeLabel("Everybody died");
								try {
								    Thread.sleep(3000);
								                   
								} catch(InterruptedException ex) {
								    ex.printStackTrace();
								}
								 System.exit(0); 
								 return;
							}//if lose
					if(FarmOn==true)
					{
						food += Farmnum;
					}
					
						
					if(Title=="Build"&&flagShelter == true &&Supplies>=4)
					{
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						PictureUpdate="C:\\Users\\SJHSStudent\\workspace\\sdf\\Shelter.png";
						makeLabel5();
						System.out.println("Shelter Building!!");
						makeLabel("Built a Shelter- +1 Survivor");
						Survivors+=1;
						people++;
						Supplies-=4;
						return;
						
					}else{
						makeLabel("Not enough Supplies to Build");
						
					}//end of else if
					if(Title=="Build"&&flagGoodShelter == true &&Supplies>=8)
					{
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\logo-footer.png";
						makeLabel5();
						System.out.println("GoodShelter Building!!");
						makeLabel("Built a Good Shelter- +2 Survivor");
						Survivors+=2;
						people+=2;
						Supplies-=8;
						return;
						
					}else{
						makeLabel("Not enough Supplies to build");
					}//end of else if
					if(Title=="Build"&&flagMasterShelter== true &&Supplies>=12)
					{
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						System.out.println("MasterShelter Building!!");
						makeLabel("Built a MasterShelter- +3 Survivor");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\250813-Chicken-House-with-one-gray-chicken-color-pdf.png";
						makeLabel5();
						Survivors+=3;
						people+=3;
						Supplies-=12;
						return;
					}//end of if
					if(Title=="Build"&&flagFarm== true && Supplies>=8&&food>=4)
					{
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						System.out.println("Farm Building!!");
						makeLabel("Built Farm +1 food each turn");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\tractor.png";
						makeLabel5();
						Supplies-=8;
						food-=4;
						Farmnum++;
						FarmOn= true;
						return;
					}// if Title Build farm end

					if(Title=="Begin Turn"){
					
						
						food-=Survivors;
						
						System.out.println("Ate "+ Survivors +" Rations");
						die1 = (int)(Math.random()*3) + 1;
						if(die1 == 1)
						{
							
							PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
							PictureUpdate= "C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\Donate-Icon.png";
							makeLabel5();
							loot = "food";
							food+= Survivors*2;
						}//if food rolled
						if(die1 ==2)
						{
							PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
							PictureUpdate= "C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\kingswood.png";
							makeLabel5();
							loot = "Supplies";
							Supplies += Survivors*2;
						}
						if(die1 ==3)
						{
							loot= "Uh oh";
						}
						if(loot== "Uh oh"){
							TroubleCall();
						}else{
							makeLabel("Your Survivor(s) has Scavenged "+ loot );
							
						}//end of else
					}//end of if Title is Begin Turn
					
					makeLabel3("food= " +food);
					makeLabel2("Supplies= " +Supplies);
					makeLabel4("Survivors= " +Survivors);
					flagGoodShelter= false;
					flagMasterShelter= false;
					flagShelter= false;
					flagFarm =false;
                 }//end of action performed

				private void TroubleCall() {
					die2 = (int)(Math.random()*19) + 1;
					switch(die2){
					case 1:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
					
						makeLabel("You found a new Survivor");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\Survivor.png";
						makeLabel5();
						people++;
						Survivors++;
						break;
					case 2:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Plentiful Harvest- gain 4 food");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\tractor.png";
						makeLabel5();
						food +=4;
						break;
					case 3:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Scavenge The plane- gain 4 supplies");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\plane.png";
						makeLabel5();
						Supplies+=4;
						break;
					case 4:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Deer Hunt- gain 2 food");
						PictureUpdate = "C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\cursor.png";
						makeLabel5();
						food +=2;
						break;
					case 5:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Death- remove 1 survivor");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
						Survivors-=1;
						break;
					case 6:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Wild Fire- remove 4 supplies");
						PictureUpdate= "C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\Farm-Fresh_fire.png";
						makeLabel5();
						Supplies-=4;
						break;
					case 7:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Hunger- remove 3 hunger");
						food-=3;
						break;
					case 8:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Boar Attack- remove 4 food");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\boar.png";
						makeLabel5();
						food-=4;
						break;
					case 9:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Repairs- remove 3 supplies");
						PictureUpdate= "C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\48px-Gnome-system-run.svg.png";
						makeLabel5();
						Supplies-=3;
						break;
					case 10:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Death- remove 1 survivor");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
						Survivors-=1;
						break;
					case 11:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Death- remove 1 survivor");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
						Survivors-=1;
						break;
					case 12:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Death- remove 1 survivor");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
						Survivors-=1;
						break;
					case 13:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("killed a bear - gain 8 food");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\bear.png";
						makeLabel5();
						food+=8;
						break;
					case 14:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Native Attack!- remove 4 supplies and 4 food");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
						food-=4;
						Supplies-=4;
						break;
					case 15:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Found an Abandoned Native farm");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\tractor.png";
						makeLabel5();
						Farmnum++;
						FarmOn= true;
						break;
					case 16:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Survivor is a Canibal- gain 10 food and remove 1 survivor");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
						food+=10;
						Survivors--;
						break;
					case 17:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Bear Attack- remove 8 food");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\bear.png";
						makeLabel5();
						food-=8;
						break;
					case 18:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Attacked the natives- gain 4 food and 4 supplies");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\Donate-Icon.png";
						makeLabel5();
						food+=4;
						Supplies+=4;
						break;
					case 19:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("Food goes bad- remove half food");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
						food/=2;
						break;
					case 20:
						PlaySound("C:\\Users\\SJHSStudent\\Downloads\\ButtonClick.wav");
						makeLabel("SLEEPPPPPPPP-  remove " + Survivors + "food");
						PictureUpdate="C:\\Users\\SJHSStudent\\Documents\\Dylan\\src\\skull-icon-59230.png";
						makeLabel5();
					}//end of switch
				}//end of Trouble Call
            });//end of Action Listener
    }//end of MakeSoundButton	
}//end of SoundFrame
