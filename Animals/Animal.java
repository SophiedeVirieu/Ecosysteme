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
    public int satiety;
    protected Biomass.species specie;
    protected List<Biomass.species> preys;
    protected List<TerrainResources.food> myFood;
    protected int voracity;
    protected sexes sex;
    protected int speed;
    protected int camouflage;
    protected List<Integer> detectedFood;
    protected List<Integer> toFlee;
    public Biomass toEat = null;


    public Animal(int x, int y) {
        super(x, y);
        Random rand = new Random();
        this.satiety = rand.nextInt(sat_max-1)+1;
        this.voracity = rand.nextInt(10);

        if (this.satiety %2 == 0){this.sex = sexes.M;}
        else{this.sex = sexes.F;}

        this.preys = new ArrayList<Biomass.species>();
        this.myFood = new ArrayList<TerrainResources.food>();
        this.detectedFood = new ArrayList<>(Arrays.asList(null, 0));
    }

    public void eat(Biomass food) {
        /* Supposes that this is one of the food's predators */

        food.bites += 2;
        if (food.bites>3){ //if food is dead
            //Simulation is in charge of killing it
            this.satiety = min(sat_max, this.satiety + food.calories);
            this.toEat = null;
        }
        this.detectedFood.set(0, null); // means that the animal has no food in sight

    }

    protected void move(int x_aim, int y_aim) {
        if (!this.ground.contains(Terrain2D.getTerrain(x_aim, y_aim))){
            // forbidden terrain : do not move
            return;
        }

        //Calculation of the vector
        int x_v = x_aim - this.x;
        int y_v = y_aim - this.y;
        double norm = Math.sqrt(x_v*x_v + y_v*y_v);

        //unit vector * speed
        if (this.speed > norm){norm = this.speed;}// do not go further than the aim

        x_v = (int)(x_v*this.speed / norm);
        y_v = (int)(y_v*this.speed / norm);

        //Move to the arrival case
        this.x += x_v;
        this.y += y_v;
    }

    // to call only if the animal is female
    public void reproduce(){
        this.satiety = 2;
    }
    /* create an animal next to this */

    protected void detectFood(){
        /* Search the nearest food */

        List<List<Integer>> detected = new ArrayList<>(); //the list of coordinates of detected food

        for (TerrainResources.food f : myFood){
            detected.addAll(Terrain2D.Neighbours(this.x, this.y, this.voracity, Terrain2D.foodToList.get(f)));
        }

        for (Animal a : Simulation.animals){
            if (this.preys.contains(a.specie) &&
                    Math.sqrt(Math.pow(a.x - this.x, 2) + Math.pow(a.y - this.y, 2)) < this.voracity){
                detected.add(List.of(a.x, a.y));
            }
        }

        // comparison of the distances
        List<Double> distances = new ArrayList<>();
        for (List<Integer> coords : detected){
            distances.add(Math.sqrt(Math.pow(coords.get(0) - this.x, 2) + Math.pow(coords.get(1) - this.y, 2)));
        }
        try {
            int indexMin = distances.indexOf(Collections.min(distances));
            this.detectedFood = detected.get(indexMin);
        }
        catch (Exception e){ // if the list is empty (ie no food in sight)
            this.detectedFood.set(0, null);
        }

    }

    public void detectPredator(){

        List<List<Integer>> detected = new ArrayList<>();
        int radius = 7;
        for (Animal a : Simulation.animals){
            if (a.x >= this.x - radius && a.x <= this.x + radius &&
                    a.y >= this.y - radius && a.y <= this.y + radius &&
                        this.predators.contains(a.specie)){

                detected.add(List.of(a.x, a.y));
            }
        }

        List<Double> distances = new ArrayList<>();
        for (List<Integer> coords : detected){
            distances.add(Math.sqrt(Math.pow(coords.get(0) - this.x, 2) + Math.pow(coords.get(1) - this.y, 2)));
        }
        try {
            int indexMin = distances.indexOf(Collections.min(distances));
            this.toFlee = detected.get(indexMin);
        }
        catch (Exception e){ // if the list is empty (ie no predator in sight)
            this.toFlee.set(0, null);
        }

    }

    public void migrate(){
        // TODO : meteo
        Random rand = new Random();
        int xAim = rand.nextInt(15);
        int yAim = rand.nextInt(15);
        move(xAim, yAim);
    }

    public void flee(){
        // go to the symmetric point of the danger with respect to the animal
        move(2*this.x -this.toFlee.get(0), 2*this.y -this.toFlee.get(1));

    }

    public void attack(){
        move(detectedFood.get(0), detectedFood.get(1));
    }

    public Simulation.Decisions decide(){
        /* criteria between FLEE and ATTACK : what is the nearest */

        if (this.sex == sexes.F && this.satiety >= sat_max-1){
            return Simulation.Decisions.REPRODUCE;
        }

        List<Integer> detected = new ArrayList<>(); //the list of coordinates of detected food

        for (TerrainResources.food f : myFood){
            detected = Terrain2D.Neighbours(this.x, this.y, 0, Terrain2D.foodToList.get(f)).getFirst();
            if (detected.get(0) == this.x && detected.get(1) == this.y){
                // TODO
                //this.toEat = f; de type TerrainResources, pas enum
                return Simulation.Decisions.EAT;
            }
        }

        for (Animal a : Simulation.animals){
            if (this.x == a.x && this.y == a.y &&
                    this.preys.contains(a.specie)){
                this.toEat = a;
                return Simulation.Decisions.EAT;
            }
        }

        this.detectPredator();
        if (this.toFlee.getFirst() != null){
            return Simulation.Decisions.FLEE;
        }

        this.detectFood();
        // TODO : meteo
        if (this.detectedFood.get(0) == null){
            return Simulation.Decisions.MIGRATE;
        }
        return Simulation.Decisions.ATTACK;
    }

}
