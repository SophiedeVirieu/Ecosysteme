package Animals;
import Resources.TerrainResources;
import base.Biomass;
import base.Terrain2D;
import base.Simulation;

import java.util.*;
import static java.lang.Integer.min;

public abstract class Animal extends Biomass {

    public int sat_max = 10;

    public enum sexes {M, F};
    public int satiety; //J'ai mis en variable publique en l'absence d'un getter
    protected Biomass.species specie;
    protected List<Biomass.species> prews; //Tu voulais dire prey ? (proies ?)
    protected List<TerrainResources.food> myFood;
    protected int voracity;
    protected sexes sex;
    protected int speed;
    protected int camouflage;


    public Animal(int x, int y) {
        super(x, y);
        Random rand = new Random();
        this.satiety = rand.nextInt(sat_max-1)+1;
        this.voracity = rand.nextInt(10);

        if (this.satiety %2 == 0){this.sex = sexes.M;}
        else{this.sex = sexes.F;}

        this.prews = new ArrayList<Biomass.species>();
        this.myFood = new ArrayList<TerrainResources.food>();
    }

    public void eat(Biomass food) {
        /* Supposes that this is one of the food's predators */

        food.bites += 2;
        if (food.bites>3){ //Simulation is in charge of killing it
            this.satiety = min(sat_max, this.satiety + food.calories);
        }

    }

    protected void move(int x_aim, int y_aim) {
        if (!this.ground.contains(Terrain2D.getTerrain(x_aim, y_aim))){
            // forbidden terrain
            return;
        }

        //Calculation of the vector
        int x_v = x_aim - this.x;
        int y_v = y_aim - this.y;
        double norm = Math.sqrt(x_v*x_v + y_v*y_v);

        //unit vector * speed
        x_v = (int)(x_v*this.speed / norm);
        y_v = (int)(y_v*this.speed / norm);

        //Move to the arrival case
        this.x += x_v;
        this.y += y_v;
    }

    // to call only if the animal is female
    public abstract void reproduce(); //TODO : Caution : the reproduce function shouldn't create new animals without being very careful ! (It will cause bugs)

    protected void detect_food(){
        /* Search the nearest food */

        List<List<Integer>> aim = new ArrayList<>();

        if (myFood.contains(TerrainResources.food.BERRIES)){
            aim.addAll(Terrain2D.get_Berry());
        }
        if (myFood.contains(TerrainResources.food.FISH)){
            aim.addAll(Terrain2D.get_Fish());
        }
        if (myFood.contains(TerrainResources.food.ALGAE)){
            aim.addAll(Terrain2D.get_Algae());
        }
        if (myFood.contains(TerrainResources.food.GRASS)){
            aim.addAll(Terrain2D.get_Grass());
        }

        //distances ?

    }

    public void detect_predator(){
        //
    }

    public void migrate(){

    }

    public void flee(){

    }

    public void attack(){

    }

    public Simulation.Decisions decide(){
        /* criteria : what is the nearest */
        return Simulation.Decisions.FLEE; //EXEMPLE !
    }
}
