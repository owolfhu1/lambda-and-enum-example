
/*
 * fileName : Microwave.java
 * author : Orion Wolf-Hubbard
 * date : 9/25/2017
 * purpose : to cook some Food.java
 */

public class Microwave {

    //class properties
    private boolean on = false;
    private Food contents;

    //turns the microwave on and off
    NoArgVoid power = () -> {
        on = !on;
        System.out.println("You turn the microwave " + (on ? "on." : "off."));
    };

    //loads microwave
    OneFoodVoid load = food -> {
        contents = food;
        System.out.println("You load a " + contents.getType());
    };

    //unloads microwave
    NoArgFood unload = () -> {
        Food temp = contents;
        System.out.println("You unload a " + contents.getType());
        contents = null;
        return temp;
    };

    //cooks for given seconds
    OneIntVoid cook = seconds ->  {
        int cookTime = seconds;
        System.out.println("Beginning microwave.");
        for (int s = 0; s < seconds; s++) {
            contents.cook();
            System.out.println("time left: " + --cookTime);
        }
        System.out.println("DING DING DING! Finished cooking!");
    };

    //is the microwave on?
    NoArgBoolean isOn = () -> on;

}

@FunctionalInterface
interface OneIntVoid {
    void act(int input) throws InterruptedException;
}

@FunctionalInterface
interface NoArgBoolean {
    boolean act();
}

@FunctionalInterface
interface OneFoodVoid {
    void act(Food food);
}

@FunctionalInterface
interface NoArgFood {
    Food act();
}

@FunctionalInterface
interface NoArgVoid {
    void act();
}
