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
    public boolean ishuge;
    public boolean istiny;

    public int Stamina;
    public boolean isSprinting;
    public long lastSprintTime = 0;
    public long sprintCooldown = 2000; // 2 seconds cooldown
    public long sprintDuration = 500; //max sprint time (0.5 sec)

    public int maxStamina = 140;
    public long lastRegenTime = 0;

    int randx = (int) (Math.random() * 10) + 1;
    int randy = (int) (Math.random() * 10) - 3;


    public Player(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx = randx;
        dy = randy;
        width = 60;
        height = 60;
        isAlive = true;
        hitbox = new Rectangle(xpos, ypos, width, height);
        /*isUP = false;
        isDown = false;
        isRight = false;
        isLeft = false;
        //Size
        ishuge = false;
        istiny = false;*/
        Stamina = 130;



    }// constructor

    public void move() {

        if (isUP == true) {
                dy = -10;
            }
        if (isUP == true && isSprinting == true && Stamina>0) {
            dy = -20;
        }



            if (!isUP && isDown == false) {
                dy = 0;
            }
            if (isDown == true) {
                    dy = 10;
            }
        if (isDown == true && isSprinting == true && Stamina>0) {
            dy = 20;
        }


            if (isRight == true) {
                    dx = 10;
            }
        if (isRight == true && isSprinting == true && Stamina>0) {
            dx = 20;
        }
            if (isLeft == true) {
                    dx = -10;
            }
        if (isLeft == true && isSprinting == true && Stamina>0) {
            dx = -20;
        }
            if (isRight == false && isLeft == false) {
                dx = 0;
            }

            if (xpos < 155) { //bounce off left wall
                xpos = 160;

            }
            if (ypos < 60) { //bounce off top wall
                ypos = 65;

            }
            if (xpos > 795) { //bounce off right  wall
                xpos = 790;

            }
            if (ypos > 610 - height) { //bounce off bottom wall
                ypos = 550;

            }

            if (isSprinting == true && Stamina > 0){
               Stamina -= 2; //drains faster while sprinting
            } else {
                if (Stamina < maxStamina -10){
                    Stamina += 1; //regen when not sprinting
                }
            }
            //stop sprint if empty
            if (Stamina <= 0) {
                Stamina = 0;
                isSprinting = false;
            }

            if(Stamina>maxStamina){
                Stamina = maxStamina;

            }


            xpos = xpos + dx;
            ypos = ypos + dy;


            hitbox = new Rectangle(xpos, ypos, width, height);
        }

        public void scale () {
            if (istiny == true) {
                width = 35;
                height = 35;
                dx = 30;
                dy = 30;
            }
            if (ishuge == true) {
                width = 100;
                height = 100;
                dx = 2;
                dy = 2;
            }

        }


    }


