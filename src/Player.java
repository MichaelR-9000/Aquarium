import java.awt.*;

public class Player {

    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;//a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;
    public boolean iskicking;
    public boolean istackling;
    public boolean isUP;
    public boolean isDown;
    public boolean isRight;
    public boolean isLeft;

    int randx = (int)(Math.random() * 10)+1;
    int randy = (int)(Math.random() * 10)-3;



    public Player(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx =randx;
        dy =randy;
        width = 60;
        height = 60;
        isAlive = true;
        hitbox = new Rectangle(xpos,ypos,width,height);
        isUP = false;
        isDown = false;
        isRight = false;
        isLeft = false;


    }// constructor

    public void move() {

        if(isUP == true){
            dy = -10;
        }
        if(!isUP && isDown == false){
            dy = 0;
        }
        if(isDown == true){
            dy = 10;
        }


        if(isRight == true){
            dx = 10;
        }
        if(isLeft == true){
            dx = -10;
        }
        if(isRight == false && isLeft == false){
            dx = 0;
        }

        if (xpos < 0) { //bounce off left wall
            dx = -dx;

        }
        if (ypos < 0) { //bounce off top wall
            dy = -dy;

        }
        if (xpos > 1000-width) { //bounce off right  wall
            dx = -dx;

        }
        if (ypos > 700-height) { //bounce off bottom wall
            dy = -dy;

        }

        xpos = xpos + dx;
        ypos = ypos + dy;


        hitbox = new Rectangle(xpos,ypos,width,height);



    }



}
