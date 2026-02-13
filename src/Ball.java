import java.awt.*;

/**
 * Created by chales on 11/6/2017.
 */
public class Ball {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;//a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;
    public int scoreleft;
    public int scoreright;
    public boolean isscoring;
    public boolean isrightwin;
    public boolean isleftwin;




    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public Ball(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx =0;
        dy =0;
        width = 60;
        height = 60;
        isAlive = true;
        hitbox = new Rectangle(xpos,ypos,width,height);
 
    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (xpos < 120) {//bounce off left wall


            dx=-dx/2;
            if (dx == 0 ){
                dx=1;
            }

        }
        if (ypos < 20) { //bounce off top wall

            dy=-dy/2;
            if (dy == 0 ){
                dy=1;
            }

        }
        if (xpos > 900-width) { //bounce off right  wall
            dx=-dx/2;
            if (dx == 0 ){
                dx=-1;
            }

        }
        if (ypos > 650-height) { //bounce off bottom wall
            dy=-dy/2;
            if (dy == 0 ){
                dy=-1;
            }

        }

        if (xpos < 120 && ypos>275 && ypos < 375 && isscoring == false) {

            System.out.println("GOAL ON LEFT");
            isscoring = true;
            scoreleft = scoreleft+1;
            System.out.println("The score is " +scoreleft+" on left "+scoreright+" on right");

        }
        if (xpos > 780 && ypos>275 && ypos < 375 && isscoring == false) {
            isscoring = true;
            System.out.println("GOAL ON RIGHT");
            scoreright = scoreright+1;
            System.out.println("The score is "+scoreleft+" on left "+scoreright+" on right");

        }
        if (xpos > 120 && ypos<375 && ypos > 275 && xpos < 780)
        {
            isscoring = false;
        }
            hitbox = new Rectangle(xpos,ypos,width,height);



    }
}






