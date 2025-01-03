package Animals;
import Resources.TerrainResources;

public class Deer extends Animal {

    public Deer(int x, int y) {
        super(x, y);
        this.specie = species.DEER;

        this.predators.add(species.WOLF);
        this.myFood.add(TerrainResources.food.GRASS);
        this.myFood.add(TerrainResources.food.BERRIES);
        this.ground.add(grounds.FOREST);
        this.ground.add(grounds.PLAIN);

        this.speed = 4;
        this.camouflage = 2;
        this.calories = 8;
    }

    @Override
    public void reproduce() {
        new Deer(this.x+1, this.y);
    };
}
