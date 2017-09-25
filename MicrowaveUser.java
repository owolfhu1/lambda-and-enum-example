import java.util.Scanner;

/*
 * fileName : MicrowaveUser.java
 * author : Orion Wolf-Hubbard
 * date : 9/25/2017
 * purpose : To use a Microwave.java
 */

public class MicrowaveUser {

    //an array of food types for making food
    private static final FoodType[] FOODS = {
            FoodType.PIZZA, FoodType.SOUP, FoodType.MUFFIN, FoodType.POPCORN, FoodType.HOT_POCKET
    };

    //menu to display when selecting food
    private static final String MENU = "Please select a food:\n" +
            "1) PIZZA: comes FROZEN, takes 12 seconds to cook through one state.\n" +
            "2) SOUP: comes THAWED, takes 8 seconds to cook through one state.\n" +
            "3) MUFFIN: comes THAWED, takes 2 seconds to cook through one state.\n" +
            "4) POPCORN: comes THAWED, takes 15 seconds to cook through one state.\n" +
            "5) HOT POCKET: comes FROZEN, takes 7 seconds to cook through one state.\n" +
            "Please enter selection: ";

    //main method
    public static void main(String... args) throws InterruptedException {

        //gets input from keyboard
        Scanner input = new Scanner(System.in);

        //lets get a microwave to test
        Microwave microwave = new Microwave();

        //turn it on
        microwave.power.act();

        //while the microwave is on we can use it
        while (microwave.isOn.act()) {

            int tempInput = -1;
            System.out.println(MENU);

            //while input is out of range
            while (tempInput < 1 || tempInput > 5) {

                //while input is not an int
                while (!input.hasNextInt()) {
                    System.out.print("Integer required: ");
                    input.next();
                }

                //store input
                tempInput = input.nextInt();

            }

            //make the requested food
            Food food = new Food(FOODS[tempInput - 1]);

            //display the food
            System.out.println("food.toString(): " + food.toString());

            //load it
            microwave.load.act(food);

            //reset tempInput
            tempInput = -1;

            //while input is too low
            while (tempInput < 1 ) {

                //prompt
                System.out.print("How many seconds would you like to cook for?");

                //while input is not an int
                while (!input.hasNextInt()) {
                    System.out.print("Integer required: ");
                    input.next();
                }

                //store input
                tempInput = input.nextInt();

            }

            //cook for given input seconds
            microwave.cook.act(tempInput);

            //unload the food
            food = microwave.unload.act();

            //display the food
            System.out.println("food.toString(): " + food.toString());

            //prompt to turn off or continue
            System.out.print("Enter x to turn the microwave off, any other key to cook something else: ");
            String selection = input.next();
            if (selection.toLowerCase().charAt(0) == 'x')
                microwave.power.act();

        }

    }

}
