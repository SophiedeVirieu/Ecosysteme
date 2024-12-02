import java.util.*;

public abstract class Animal {

    public int sat_max = 10;
    public enum species {CRABE, MEDUSE, MOUETTE, CHEVREUIL, LOUP, HERISSON,
        SERPENT, FAUCON, REQUIN, TURTLE};
    public enum sexes {M, F};
    public enum grounds {WATER, SAND, };

    private int satiety;
    private int bites;
    private List<species> predators;
    private List<species> prews;
    private int voracity;
    private sexes sex;
    private int speed;
    private int camouflage;


    Random rand = new Random();

    public Animal() {
        this.satiety = rand.nextInt(sat_max-1)+1;
        this.bites = 0;
        this.voracity = rand.nextInt(10);

        if (this.satiety %2 == 0){this.sex = sexes.M;}
        else{this.sex = sexes.F;}
    }


}
