public class Greenhouse {
    String name;
    boolean sprinklerson;
    int numberofflowers;

    public static void main(String[] args) {
        Greenhouse greenhouse = new Greenhouse();


    }

    public Greenhouse() {
        System.out.println("Hello World! Good luck on your exams!");
        name = "Planting Parameters at the CSG";
        sprinklerson = true;
        numberofflowers = 31;
        System.out.println("Welcome to " + name + "! It is " + sprinklerson + " that we are watering plants right now. We have " + numberofflowers + " flowers!");
        numberofflowers = 900;
        System.out.println("Welcome to " + name + "! It is " + sprinklerson + " that we are watering plants right now. We have " + numberofflowers + " flowers!");
        randomReplant();
        veggieOfTheDay("tomato");
        countFlowers();
        changeTemperature();
        Plant kimPlant = new Plant(3, "orange", true);
        kimPlant.printInfo();
        Plant myPlant = new Plant(5,"red", true);
        myPlant.printInfo();
        starTriangle(3);

    }

    public void randomReplant() {
        int randomInt;
        randomInt = (int) (Math.random() * 15);
        System.out.println("We are replanting " + randomInt + " vegetables today!");
    }

    public void veggieOfTheDay(String veggie) {
        System.out.println("today's chosen veggie is " + veggie);

    }

    public void countFlowers() {

        for (int x = 0; x < 7; x = x + 1) {
            System.out.println(x);
        }
        System.out.println(); // just adding this to create space between loops in dos window


        for (int x = 20; x < 111; x = x + 30) {
            System.out.println(x);
        }
        System.out.println(); // just adding this to create space between loops in dos window

        for (int x = 8; x > -1; x = x - 1) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }

    public void changeTemperature() {
        double randomNum;
        randomNum = (double) (Math.random() * 0.9999999);

        if (randomNum < 0.25){
            System.out.println("The temperature has decreased by 2 degrees");
        }
        if (randomNum >= 0.25 && randomNum<0.5){
            System.out.println("The temperature has decreased by 1 degree");
        }
        if (randomNum >= 0.5 && randomNum<0.75){
            System.out.println("The temperature has increased by 1 degree");
        }
        if (randomNum >= 0.75 && randomNum <1){
            System.out.println("The temperature has increased by 2 degrees");
        }

    }
    public void starTriangle(int size){


        for (int x = 1; x <= size; x = x+1) {
            System.out.println("*");
            for (int i = 0; i<x; ++i){
            System.out.print("*");


        }
        }
    }

}
