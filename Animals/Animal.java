package Animals;
import Resources.TerrainResources;
import base.Biomass;
import base.Terrain2D;

import java.util.*;
import static java.lang.Integer.min;

public abstract class Animal extends Biomass {

    public int sat_max = 10;

    public enum sexes {M, F};
    protected int satiety;
    protected Biomass.species specie;
    protected List<Biomass.species> prews;
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

    protected void eat(Biomass food) {
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
    protected abstract void reproduce();

    protected void detect_food(){

    }

    protected void detect_predator(){
        //
    }

    protected void migrate(){

    }

    protected void flee(){

    }

    protected void attack(){

    }

    protected void decide(){

    }
}
