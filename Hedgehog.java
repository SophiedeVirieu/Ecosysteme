public class Hedgehog extends Animal{

    public Hedgehog(int x, int y) {
        super(x, y);
        this.specie = species.HEDGEHOG;

        this.predators.add(species.FALCON);
        this.predators.add(species.WOLF);
        this.myFood.add(TerrainResources.food.GRASS);
        this.myFood.add(TerrainResources.food.BERRIES);
        this.ground.add(grounds.FOREST);
        this.ground.add(grounds.PLAIN);

        this.speed = 1;
        this.camouflage = 2;
        this.calories = 5;
    }

    @Override
    protected void reproduce() {
        new Hedgehog(this.x+1, this.y);
    };
}
