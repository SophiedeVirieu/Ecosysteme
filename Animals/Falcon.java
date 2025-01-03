package Animals;

public class Falcon extends Animal {

    public Falcon(int x, int y) {
        super(x, y);
        this.specie = species.FALCON;

        this.prews.add(species.SEAGULL);
        this.prews.add(species.SNAKE);
        this.prews.add(species.HEDGEHOG);
        this.predators.add(species.WOLF);
        this.ground.add(grounds.PLAIN);

        this.speed = 4;
        this.camouflage = 1;
    }

    @Override
    public void reproduce() {
        new Falcon(this.x+1, this.y);
    };
}
