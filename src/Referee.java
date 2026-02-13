import java.awt.*;

public class Referee {

    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;
    public boolean isredcarding;

    //a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;

    int randx = (int)(Math.random() * 3)+1;
    int randy = (int)(Math.random() * 3)+1;

    public Referee(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx =randx;
        dy =randy;
        width = 60;
        height = 60;
        isAlive = true;
        hitbox = new Rectangle(xpos,ypos,width,height);

    }// constructor

    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (xpos < -100) {//bounce off left wall


            xpos = 1000;

        }
        if (ypos < -100) { //bounce off top wall

            ypos = 900;

        }
        if (xpos > 1000) { //bounce off right  wall
            xpos = -25;

        }
        if (ypos > 1000) { //bounce off bottom wall
            ypos = -100;

        }

        hitbox = new Rectangle(xpos,ypos,width,height);
        if (dx == 0 && dy == 0){
            dx = 1;
            dy = 1;
        }



    }




}

