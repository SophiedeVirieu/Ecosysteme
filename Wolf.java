public class Wolf extends Animal {

    public Wolf(int x, int y) throws BadGroundException {
        super(x, y);
        this.specie = species.WOLF;

        this.prews.add(species.DEER);
        this.prews.add(species.HEDGEHOG);
        this.ground.add(grounds.FOREST);
        this.ground.add(grounds.PLAIN);

        this.speed = 4;
        this.camouflage = 3;
    }

    @Override
    protected void reproduce() throws BadGroundException{
        new Wolf(this.x+1, this.y);
    };

}
