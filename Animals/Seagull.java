package Animals;
import Resources.TerrainResources;
import base.Terrain2D;

public class Seagull extends Animal {

    public Seagull(int x, int y) {
        super(x, y);
        this.specie = species.SEAGULL;

        this.preys.add(species.CRAB);
        this.preys.add(species.SNAKE);
        this.predators.add(species.FALCON);
        this.predators.add(species.SNAKE);
        this.predators.add(species.SHARK);
        this.myFood.add(TerrainResources.food.FISH);
        this.ground.add(grounds.WATER);
        this.ground.add(grounds.SAND);
        this.ground.add(grounds.PLAIN);

        this.speed = 3;
        this.camouflage = 1;
        this.calories = 4;
    }

    @Override
    public void reproduce() {
        if (this.ground.contains(Terrain2D.getTerrain(this.x +1, this.y))) {
            new Seagull(this.x + 1, this.y);
            super.reproduce();
        }
    }
}
