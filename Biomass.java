import java.util.ArrayList;
import java.util.List;

public abstract class Biomass {

    public enum species {CRAB, JELLY_FISH, SEAGULL, DEER, WOLF, HEDGEHOG,
        SNAKE, FALCON, SHARK, TURTLE};
    public enum grounds {WATER, SAND, PLAIN, FOREST};
    public enum meteos {SUN, RAIN}; //voir si on en fait quelque chose

    protected List<species> predators;
    protected List<grounds> ground;
    protected int calories;
    protected int bites;
    protected int x;
    protected int y;

    public Biomass(int x, int y) throws BadGroundException {
        this.x = x;
        this.y = y;
        this.bites = 0;
        this.predators = new ArrayList<species>();
        this.ground = new ArrayList<grounds>();
    }

    public void setY(int y) throws BadGroundException {
        System.out.println("Le setter a bien été appelé");
        // A CORRIGER
        // si x et y sont dans un terrain de this.ground :
        if (this.x+y<10) {
            this.y = y;
        }
        else {
            throw new BadGroundException();
        }
    }

}
