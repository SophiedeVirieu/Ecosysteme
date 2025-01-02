package base;
import Animals.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;



public class Simulation {
    public enum Decisions {REPRODUCE, EAT, FLEE, ATTACK, MIGRATE} //Possible behaviors for the animals
    private int end; // =1 when the simulation is ended, =0 when it is still running
    private ArrayList<Animal> animals = new ArrayList<Animal>(); // List of the animals in the simulation.
    private int[] sizewl; // Size [width, length] of the game board TODO: Is it useful?
    //private terrain board;
    public static Random rand = new Random();

    public Simulation(int[] size, int[] animal_numbers) throws BadGroundException {
        /*
        This function runs the simulation.
        size : the size of the game board (width,height)
        animal_numbers : the number of animals from each species in order : Crab,Deer,Falcon,Hedgehog,JellyFish,Seagull,Snake,Turtle,Wolf
         */
        this.end = 0;
        init_terrain(size);
        init_animals(animal_numbers);

        while(this.end==0){
            turn_simulation();
        }
        ending();
        System.out.println("Simulation ended.");
    }


    public void turn_simulation() {
        /*
        This function simulates a turn : It asks what each animal wants to do, then makes them do it. TODO : Make the turn ending (refreshing data, making some animals die, etc...)
         */
        ArrayList<Animal> flee = new ArrayList<Animal>();
        ArrayList<Animal> attack = new ArrayList<Animal>();
        ArrayList<Animal> reproduce = new ArrayList<Animal>();
        ArrayList<Animal> migrate = new ArrayList<Animal>();
        ArrayList<Animal> eat = new ArrayList<Animal>();
        for (Animal a : this.animals) { //Ask each animal what it wants to do
            switch (a.decide()) {
                case Decisions.FLEE:
                    flee.add(a);
                    break;
                case Decisions.ATTACK:
                    attack.add(a);
                    break;
                case Decisions.REPRODUCE:
                    reproduce.add(a);
                    break;
                case Decisions.MIGRATE:
                    migrate.add(a);
                    break;
                case Decisions.EAT:
                    eat.add(a);
                    break;
            }
        }
        for (Animal a : flee) { //Let the animal do what it wanted to do. Will have to be completed when the functions are implemented in Animal.java
            a.flee();
        }
        for (Animal a : attack) {
            a.attack();
        }
        for (Animal a : reproduce) {
            a.reproduce();
        }
        for (Animal a : migrate) {
            a.migrate();
        }
        for (Animal a : eat) { //TODO : HAVE TO LOOK WHAT FOOD TO GIVE TO EAT TO THE ANIMAL based on its coordinates !
            int x = a.x;
            int y = a.y;

            /*
            Here, look for the thing the animal eats...
             */
            a.eat();
        }
        turn_end();
    }

    private void turn_end(){
        ArrayList<Animal> survivors = new ArrayList<Animal>(); //Is a new array list each turn ?? Normally yes, bc it is a local variable
        for (int i = 0; i < animals.size(); i++) { //Kill related animals
            Animal a = animals.get(i);
            if (a.satiety > 0) {//TODO : Is the satiety stat really equivalent to hp?
                survivors.add(a);
            }
            else{
                a.kill(); //Does an animal have to do something when killed?
            }
        }
        this.animals = survivors; //Replace the list with the updated list of animals. DOES IT WORK ? SHOULD I COPY THE LIST BC SURVIVORS WILL BE DESTROYED AT END OF FUNTION CALL ?
    }

    public void ending(){}

    private void init_terrain(int[] size){
        this.sizewl = new int[2];
        this.sizewl[0]=size[0];
        this.sizewl[1]=size[1];
    }

    private void init_animals(int[] animal_numbers) throws BadGroundException {
        int n = 0; //Index of each animal type
        for (int i = 0; i < animal_numbers.length; i++){
            for (int j = 0; j < animal_numbers[i]; j++){
                switch (i){ //Is there a better way to do this ?? Like by putting class references into an array ?
                    case 0:
                        this.animals.add(new Crab(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 1:
                        this.animals.add(new Deer(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 2:
                        this.animals.add(new Falcon(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 3:
                        this.animals.add(new Hedgehog(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 4:
                        this.animals.add(new JellyFish(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 5:
                        this.animals.add(new Seagull(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 6:
                        this.animals.add(new Snake(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 7:
                        this.animals.add(new Turtle(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                    case 8:
                        this.animals.add(new Wolf(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1])));
                }
            }
            n += animal_numbers[i]; // Next index
        }
    }

    public static void main(String[] args) throws BadGroundException {
        Scanner scan = new Scanner(System.in);
        int[] size = new int[2];
        System.out.println("Enter the board width");
        size[0] = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the board height");
        size[1] = Integer.parseInt(scan.nextLine());

        System.out.println("Enter the number of animals with this syntax : ");
        System.out.println("Crab,Deer,Falcon,Hedgehog,JellyFish,Seagull,Snake,Turtle,Wolf");
        String s = scan.nextLine();
        String[] result = s.split("[,]");
        int[] animal_numbers = new int[result.length];
        try{
            for (int i = 0; i < result.length; i++){
                int x = Integer.parseInt(String.valueOf(result[i]));
                animal_numbers[i] = x;
            }
        }
        catch(Exception e){
            System.out.println("Please enter the correct data: ");
            System.out.println("Crab,Deer,Falcon,Hedgehog,JellyFish,Seagull,Snake,Turtle,Wolf");
        }

        Simulation sim = new Simulation(size, animal_numbers);

        while(sim.end == 0){sim.turn_simulation();}
        sim.ending();
    }
}
