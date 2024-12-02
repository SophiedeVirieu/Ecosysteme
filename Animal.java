import java.util.*;

public abstract class Animal {

    public int sat_max = 10;
    public enum species {CRAB, JELLY_FISH, SEAGULL, DEER, WOLVE, HEDGEHOG,
        SNAKE, FALCON, SHARK, TURTLE};
    public enum sexes {M, F};
    public enum grounds {WATER, SAND, PLAIN, FOREST};

    protected int satiety;
    protected int bites;
    protected species specie;
    protected List<species> predators;
    protected List<species> prews;
    protected List<grounds> ground;
    protected int voracity;
    protected sexes sex;
    protected int speed;
    protected int camouflage;
    protected int calories;


    private Random rand = new Random();

    public Animal() {
        this.satiety = rand.nextInt(sat_max-1)+1;
        this.bites = 0;
        this.voracity = rand.nextInt(10);

        if (this.satiety %2 == 0){this.sex = sexes.M;}
        else{this.sex = sexes.F;}

        this.predators = new ArrayList<species>();
        this.prews = new ArrayList<species>();
        this.ground = new ArrayList<grounds>();

    }


}
