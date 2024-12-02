import java.util.*;

/** simulation of a simplified ecosystem */
public class Simulation {
    /**
     * animals list of the ecosystem
     */
    private LinkedList<Animal> animals;
    public enum food {FISH, ALGAE, GRASS, BERRIES};


    private int nbRounds;
    public int healing;

    public static Random rand = new Random();

    /**
     * constructor : initialisation of the simulation
     *
     * @param nbAnimals number of insects in the simulation
     * @param rounds    number of rounds of the simulation
     * @param xMax      abscissa max of the zone
     * @param yMax      ordinate max of the zone
     */
    public Simulation(int nbAnimals, int rounds, int xMax, int yMax) {
        nbRounds = rounds;
        // create the collection containing the insects 
        animals = new LinkedList<Insect>();


        // initialisation of n Animals 
        for (int i = 0; i < nbAnimals; i++) {
            // choose type of animal 
            int type = rand.nextInt(2);
            // initial position of the animal 
            int x = rand.nextInt(xMax);
            int y = rand.nextInt(yMax);
            // creation of the inset 
            switch (type) {
                case 0: //Ant
                    animals.add(new Ant(x, y));
                    break;
                case 1:
                    animals.add(new Cicada(x, y));
                    break;
                default:
                    System.err.println("Type of animal not provided");
            }
        }
    }

    /**
     * simulation of the ecosystem
     */
    public void simulate() {
        // number of rounds of the simulation 
        for (int i = 0; i < nbRounds; i++) {
            simulateARound();
            System.out.println(animals);
        }
    }

    /**
     * A round of simulation
     */
    public void simulateARound() {
        // browse the list of insects
        // since version 5.0 : possibility to use an iterator :
        //   for (Insect animal : animals)
        for (int j = 0; j < animals.size(); j++) {
            // before version Java 5.0
            // Insect animal = (Insect)animals.get(j);

            // after version Java 5.0
            Insect animal = animals.get(j);

            // feed the animal if needed
            animal.eat();
        }
    }

    public static void main (String args[]){
        Simulation simu = new Simulation(4, 10, 100, 100);
        simu.simulate();
    }

}