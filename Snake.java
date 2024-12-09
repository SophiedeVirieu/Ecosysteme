public class Snake extends Animal {

    public Snake(int x, int y) throws BadGroundException {
        super(x, y);
        this.specie = species.SNAKE;

        this.prews.add(species.CRAB);
        this.predators.add(species.SEAGULL);
        this.predators.add(species.FALCON);
        this.ground.add(grounds.SAND);
        this.ground.add(grounds.PLAIN);

        this.speed = 2;
        this.camouflage = 3;
        this.calories = 5;
    }

    @Override
    protected void reproduce() throws BadGroundException{
        new Turtle(this.x+1, this.y);
    };
}
