import java.util.*;
import static java.lang.Integer.min;

public abstract class Animal extends Biomass {

    public int sat_max = 10;

    public enum sexes {M, F};
    protected int satiety;
    protected int bites;
    protected species specie;
    protected List<species> prews;
    protected List<TerrainResources.food> myFood;
    protected int voracity;
    protected sexes sex;
    protected int speed;
    protected int camouflage;


    final private Random rand = new Random();

    public Animal(int x, int y) {
        super(x, y);
        this.satiety = rand.nextInt(sat_max-1)+1;
        this.bites = 0;
        this.voracity = rand.nextInt(10);

        if (this.satiety %2 == 0){this.sex = sexes.M;}
        else{this.sex = sexes.F;}

        this.prews = new ArrayList<species>();
        this.myFood = new ArrayList<TerrainResources.food>();
    }

    protected void eat(Biomass food) {
        //if (food in this.myFood)
        this.satiety = min(sat_max, this.satiety + food.calories);
        food.is_eaten(2); //Faire un Override pour les espèces plus puissantes
    }


}
