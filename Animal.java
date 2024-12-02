import java.util.*;
import static java.lang.Integer.min;

public abstract class Animal {

    public int sat_max = 10;
    public enum species {CRAB, JELLY_FISH, SEAGULL, DEER, WOLF, HEDGEHOG,
        SNAKE, FALCON, SHARK, TURTLE};
    public enum sexes {M, F};
    public enum grounds {WATER, SAND, PLAIN, FOREST};

    protected int satiety;
    protected int bites;
    protected species specie;
    protected List<species> predators;
    protected List<species> prews;
    protected List<grounds> ground;
    protected List<Simulation.food> myFood;
    protected int voracity;
    protected sexes sex;
    protected int speed;
    protected int camouflage;
    protected int calories;
    protected int x;
    protected int y;


    private Random rand = new Random();

    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
        this.satiety = rand.nextInt(sat_max-1)+1;
        this.bites = 0;
        this.voracity = rand.nextInt(10);

        if (this.satiety %2 == 0){this.sex = sexes.M;}
        else{this.sex = sexes.F;}

        this.predators = new ArrayList<species>();
        this.prews = new ArrayList<species>();
        this.ground = new ArrayList<grounds>();
        this.myFood = new ArrayList<Simulation.food>();
    }
//faire un classe commune entre TerrainResources et Animal
    protected void eat(TerrainResources food) {
        this.satiety = min(sat_max, this.satiety + food.calories);
    }

    public void setY(int y) {
        this.y = y;
        //faire un try - catch avec une exception de ma conception
    }

    public void setX(int x) {
        this.x = x;
    }
}
