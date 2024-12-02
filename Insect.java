import java.util.*;
/**
 * Class Insect 
 */
public class Insect {
    /** Number of rounds before getting hungry */
    private int hunger;
    /** Date of the last meal */
    private int lastMeal;
    /** Abscissa */
    private int abscissa;
    /** Ordinate */
    private int ordinate;
    public static Random rand = new Random();

    /** Constructor */
    public Insect(int nbHunger, int x, int y) {
        hunger = nbHunger;
        lastMeal = rand.nextInt(nbHunger);
        abscissa = x;
        ordinate = y;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getLastMeal() {
        return lastMeal;
    }

    public void setLastMeal(int lastMeal) {
        this.lastMeal = lastMeal;
    }

    public int getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(int abscissa) {
        this.abscissa = abscissa;
    }

    public int getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(int ordinate) {
        this.ordinate = ordinate;
    }

    public String toString() {
        return "I am in (" + abscissa + "," + ordinate + "), I can stay " + hunger +
                " without eating, I had my last meal " + lastMeal + " rounds ago\n";
    }
    /**
     * feed the animal if needed
     */
    public void eat() {
        // one more round since the last meal
        lastMeal++;
        // if need to eat
        if (lastMeal == hunger) {
            System.out.println("Eat");
            // last meal this round
            lastMeal = 0;
        }
    }
} 