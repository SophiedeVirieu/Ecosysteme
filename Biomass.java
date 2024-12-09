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
    protected int x;
    protected int y;

    public Biomass(int x, int y) {
        this.x = x;
        this.y = y;
        this.predators = new ArrayList<species>();
        this.ground = new ArrayList<grounds>();
    }

    public void setY(int y) {
        this.y = y;
        //faire un try - catch avec une exception de ma conception
    }

    public void setX(int x) {
        this.x = x;
    }

    protected void is_eaten(int strenght){

    }
}
