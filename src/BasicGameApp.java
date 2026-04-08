//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

//NOTES: MAKE THING TO CONTROL POWER OF KICK, Soft, Medium, and Heavy Kicks
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.*;



//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable, KeyListener, MouseListener{

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
    public JPanel panel;
   
	public BufferStrategy bufferStrategy;
    public Image Background;        //images for objects
	public Image ballPic;
    public Image ronaldopic;
    public Image messipic;
    public Image refpic;
    public Image Messiwin;
    public Image Ronaldowin;

   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
	private Ball bally;         //different objects
    private Player ronaldo;
    private Player messi;
    private Referee ref;


   // Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {
      
      setUpGraphics();

        //randomness
        //(int)(math.random()* range) + offset
        //range 0-9

        
       
      //variable and objects
      //create (construct) the objects needed for the game and load up
        //Creates ball
		ballPic = Toolkit.getDefaultToolkit().getImage("Ball.png");//load the picture
        bally = new Ball(483,317);
//Creates Ronaldo
        ronaldopic = Toolkit.getDefaultToolkit().getImage("Ronaldo.jpg");
		ronaldo = new Player(383,300);
//Creates Messi
        messipic = Toolkit.getDefaultToolkit().getImage("Messi.jpeg");
        messi = new Player(583,300);
        //background
        Background = Toolkit.getDefaultToolkit().getImage("Soccerfield.jpeg");
        //referee
        refpic = Toolkit.getDefaultToolkit().getImage("Ref.jpeg");
        ref = new Referee(300,300);
        Messiwin = Toolkit.getDefaultToolkit().getImage("MESSIWIN.jpg");
        Ronaldowin = Toolkit.getDefaultToolkit().getImage("RONALDOWIN.jpg");
        //win screens for ronaldo and messi


	}// BasicGameApp()

   
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up
	public void run() {

      //for the moment we will loop things forever.
		while (true) {

         moveThings();  //move all the game objects
         render();  // paint the graphics
         pause(20); // sleep for 10 ms
		}
	}


	public void moveThings()
	{
      //calls the move( ) code in the objects
		bally.move();
        ronaldo.move();
        messi.move();
        ref.move();
        Kicking();
        tackle();
        win();
        redcard();
        ronaldo.scale();
        messi.scale();



	}

    public void Kicking() {

        //if ball hits player. Ball gains the player's direction and gains speed, player loses speed
        if (bally.hitbox.intersects(ronaldo.hitbox) &&  ronaldo.iskicking == false) {

            ronaldo.iskicking = true;

            System.out.println("KICK");
            bally.dx = ronaldo.dx;
            bally.dy = ronaldo.dy;
            ronaldo.dx = ronaldo.dx -1;
            ronaldo.dy = ronaldo.dy -1;


        }



        if (!bally.hitbox.intersects(ronaldo.hitbox)) {
                ronaldo.iskicking = false;

            }//ronaldo kicking ball

        if (bally.hitbox.intersects(messi.hitbox) && messi.iskicking == false) {        //messi kicking ball

            messi.iskicking = true;

            System.out.println("KICK");
            bally.dx = messi.dx;
            bally.dy = messi.dy;
            messi.dx = messi.dx -1;
            messi.dy = messi.dy -1;


        }


        if (!bally.hitbox.intersects(messi.hitbox)) {
            messi.iskicking = false;
        }




    }
//if players interact with eachother. Gain or lose speed depending on who's faster initially
    public void tackle(){
        if (ronaldo.hitbox.intersects(messi.hitbox) && messi.istackling == false) {
            if (ronaldo.dx > messi.dx) {
                messi.dx = ronaldo.dx + 3;
                messi.dy = ronaldo.dy + 3;
                ronaldo.dx = messi.dx -2;
                ronaldo.dy = messi.dy -2;
                messi.istackling = true;

                System.out.println("RONALDO TACKLES");

            }
            if (ronaldo.dx < messi.dx) {
                ronaldo.dx = messi.dx + 3;
                ronaldo.dy = messi.dy + 3;
                messi.dx = ronaldo.dx -2;
                messi.dy = ronaldo.dy -2;
                ronaldo.istackling = true;

                System.out.println("MESSI TACKLES");

            }
        }


//specifying conditions for tackle
        if (ronaldo.hitbox.intersects(messi.hitbox) && messi.istackling == false) {
            messi.istackling = true;
        }
        if (!ronaldo.hitbox.intersects(messi.hitbox)) {
            messi.istackling = false;
        }

        if (messi.hitbox.intersects(ronaldo.hitbox) && ronaldo.istackling == false) {
            ronaldo.istackling = true;
        }
        if (!messi.hitbox.intersects(ronaldo.hitbox)) {
            ronaldo.istackling = false;
        }


    }
//if ref interacts with player. player's direction will reverse
    public void redcard(){
        if (ref.hitbox.intersects(messi.hitbox) && ref.isredcarding == false) {
            messi.dx = -messi.dx;
            messi.dy = -messi.dy;
            ref.isredcarding = true;
        }
        if (!ref.hitbox.intersects(messi.hitbox)) {
            ref.isredcarding = false;
        }
        if (ref.hitbox.intersects(ronaldo.hitbox) && ref.isredcarding == false) {
            ronaldo.dx = -ronaldo.dx;
            ronaldo.dy = -ronaldo.dy;
            ref.isredcarding = true;
        }
        if (!ref.hitbox.intersects(ronaldo.hitbox)) {
            ref.isredcarding = false;
        }




    }
//code for win screen Messi
    public void win(){
        if (bally.scoreright>2){
            messi.dx = 0;
            messi.dy = 0;
            ronaldo.dx = 0;
            messi.dx = 0;
            ref.dx = 0;
            ref.dy = 0;
            bally.dy = 0;
            bally.dx = 0;
            System.out.println("MESSI WINS!!!");
            bally.isrightwin = true;



        }

//code for win screen Ronaldo
        if (bally.scoreleft>2){
            messi.dx = 0;
            messi.dy = 0;
            ronaldo.dx = 0;
            messi.dx = 0;
            ref.dx = 0;
            ref.dy = 0;
            bally.dy = 0;
            bally.dx = 0;
            System.out.println("RONALDO WINS!!!");
            bally.isleftwin = true;

        }



    }
	
   //Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
   
      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout
   
      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();  
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
   
      panel.add(canvas);  // adds the canvas to the panel.
       canvas.addKeyListener(this);
       // add mouse motion to canvas
       canvas.addMouseListener(this);
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
      
      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }


	//paints things on the screen using bufferStrategy
	private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the image of the field
        g.drawImage(Background, 0, 0, WIDTH, HEIGHT, null);
        g.drawImage(ballPic, bally.xpos, bally.ypos, bally.width, bally.height, null);
        g.drawImage(ronaldopic, ronaldo.xpos, ronaldo.ypos, ronaldo.width, ronaldo.height, null);
        g.drawImage(messipic, messi.xpos, messi.ypos, messi.width, messi.height, null);
        g.drawImage(refpic, ref.xpos, ref.ypos, 75, 75, null);
        if (bally.isrightwin == true) {  //makes win screen for messi victory
            g.drawImage(messipic, 0, 0, WIDTH, HEIGHT, null);
            g.fillRect(10, 20, 90, 40);
            g.setColor(Color.red);
            g.drawString("MESSI WINS", 10, 35);
        }
        if (bally.isleftwin == true) {  //makes win screen for Ronaldo victory
            g.drawImage(ronaldopic, 0, 0, WIDTH, HEIGHT, null);
            g.fillRect(10, 20, 90, 40);
            g.setColor(Color.red);
            g.drawString("RONALDO WINS", 10, 35);
        }
        //makes score
        g.setColor(Color.white);
        g.fillRect(10, 20, 90, 40);
        g.setColor(Color.red);
        g.drawString("Ronaldo:" + bally.scoreleft, 10, 35);
        g.drawString("Messi:" + bally.scoreright, 10, 55);

        //make stamina bars

        int RonStam;
        int MesStam;

        RonStam = 130;
        if (ronaldo.isSprint == true) {
            RonStam = RonStam - 12;
        }

            //Ronaldo Stamina
            g.setColor(Color.white);
            g.fillRect(60, 640, 140, 30);
            g.setColor(Color.red);
            g.fillRect(64, 645, RonStam, 20);

            //Messi Stamina
            g.setColor(Color.white);
            g.fillRect(820, 642, 140, 30);
            g.setColor(Color.red);
            g.fillRect(825, 647, 130, 20);


            g.dispose();

            bufferStrategy.show();

    }
    public void keyPressed(KeyEvent e) {

        System.out.println(e.getKeyCode());

        /*if (e.getKeyCode() == 50) {
            ronaldo.width =60;
            ronaldo.height =60;
            ronaldo.istiny = false;
            ronaldo.ishuge = false;
            System.out.println("medium");
        }*/
        /*if (e.getKeyCode() == 49) {
            ronaldo.istiny = true;
            ronaldo.ishuge = false;
            System.out.println("RONALDO IS TINY");
        }*/

        /*if (e.getKeyCode() == 51) {
            ronaldo.ishuge = true;
            ronaldo.istiny = false;

            System.out.println("RONALDO IS HUGE");
        }*/

        if (e.getKeyCode() == 16) {
            System.out.println("Ronaldo Sprinting");
            ronaldo.isSprint = true;
        }

        if (e.getKeyCode() == 87) {
            ronaldo.isUP = true;
        }
        if (e.getKeyCode() == 83) {
            ronaldo.isDown = true;
        }

        if (e.getKeyCode() == 68) {
            ronaldo.isRight = true;
        }
        if (e.getKeyCode() == 65) {
            ronaldo.isLeft = true;
        }


        if (e.getKeyCode() == 38) {
            messi.isUP = true;
        }
        if (e.getKeyCode() == 40) {
            messi.isDown = true;
        }


        if (e.getKeyCode() == 39) {
            messi.isRight = true;
        }
        if (e.getKeyCode() == 37) {
            messi.isLeft = true;
        }


    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) { // Stop character movement
        System.out.println(e.getKeyCode());

        if (e.getKeyCode() == 16) {
            System.out.println("Ronaldo Sprinting");
            ronaldo.isSprint = false;
        }

        if (e.getKeyCode() == 87) {
            System.out.println("not going up");
            ronaldo.isUP = false;
        }
        if (e.getKeyCode() == 83) {
            System.out.println("not going down");
            ronaldo.isDown = false;
        }
        if (e.getKeyCode() == 68) {
            System.out.println("not going east");
            ronaldo.isRight = false;
        }
        if (e.getKeyCode() == 65) {
            System.out.println("not going west");
            ronaldo.isLeft = false;
        }

        if (e.getKeyCode() == 38) {
            messi.isUP = false;
        }
        if (e.getKeyCode() == 40) {
            messi.isDown = false;
        }


        if (e.getKeyCode() == 39) {
            messi.isRight = false;
        }
        if (e.getKeyCode() == 37) {
            messi.isLeft = false;
        }

    }
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered the screen");

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
