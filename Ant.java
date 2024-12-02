public class Ant extends Insect {

    public Ant(int x, int y) {
        super(5, x, y);
    }

    @Override
    public String toString() {
        return "I am an Ant. " + super.toString();
    }
}
