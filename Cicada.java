import java.util.Random;

public class Cicada extends Insect {

    public Cicada(int x, int y) {
        super(3, x, y);
    }

    @Override
    public String toString() {
        return "I am a Cicada. " + super.toString();
    }
}
