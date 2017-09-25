
/*
 * fileName : Food.java
 * author : Orion Wolf-Hubbard
 * date : 9/25/2017
 * purpose : An object we can cook with Microwave.java
 */

public class Food {

    //class variables
    private FoodType type;
    private FoodState state;
    private int secondsBetweenStates;
    private int secondsIntoState;

    //constructor
    public Food (FoodType type) {

        //class properties
        this.type = type;
        this.secondsIntoState = 0;

        //construct food according to type
        switch (type) {

            case PIZZA :
                this.state = FoodState.FROZEN;
                this.secondsBetweenStates = 12;
                break;

            case SOUP :
                this.state = FoodState.THAWED;
                this.secondsBetweenStates = 8;
                break;

            case MUFFIN :
                this.state = FoodState.THAWED;
                this.secondsBetweenStates = 2;
                break;

            case POPCORN :
                this.state = FoodState.THAWED;
                this.secondsBetweenStates = 15;
                break;

            case HOT_POCKET :
                this.state = FoodState.FROZEN;
                this.secondsBetweenStates = 7;
                break;

        }

        //announce that food has been made
        System.out.println("A new " + type + " has been made.");

    }

    //type getter
    public FoodType getType() {
        return type;
    }

    //this will cook the food for one second
    public void cook () throws InterruptedException {

        //wait one second
        Thread.sleep(1000);

        //if it has been long enough, increment state
        if (++secondsIntoState == secondsBetweenStates) {
            secondsIntoState = 0;
            switch (state) {
                case FROZEN: state = FoodState.THAWED; break;
                case THAWED: state = FoodState.COOKED; break;
                case COOKED: state = FoodState.BURNED; break;
                case BURNED: state = FoodState.NUKED; break;
            }
        }

    }

    //toString() override
    @Override
    public String toString() {
        return String.format("This %s is currently %s.", type, state);
    }

}
