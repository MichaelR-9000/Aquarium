

public class Player {

    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;//a boolean to denote if the hero is alive or dead.

    int randx = (int)(Math.random() * 10);
    int randy = (int)(Math.random() * 10)-3;



    public Player(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx =randx;
        dy =randy;
        width = 60;
        height = 60;
        isAlive = true;

    }// constructor

    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (xpos < 120) {//bounce off left wall


            dx=-dx;

        }
        if (ypos < 20) { //bounce off top wall

            dy=-dy;

        }
        if (xpos > 900-width) { //bounce off right  wall
            dx=-dx;

        }
        if (ypos > 650-height) { //bounce off bottom wall
            dy=-dy;

        }


    }


}
