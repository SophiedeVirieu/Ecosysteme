import java.util.Random;
import java.util.Scanner;


public class Simulation {

    private int end;
    private Animal[] animals;
    private int[] sizewl;
    //private terrain board;
    public static Random rand = new Random();
    public void turn_simulation(){}
    public void ending(){}
    public Simulation(int[] size, int[] animal_numbers) throws BadGroundException {
        end = 0;
        init_terrain(size);
        init_animals(animal_numbers);
    }
    private void init_terrain(int[] size){
        sizewl = new int[2];
        sizewl[0]=size[0];
        sizewl[1]=size[1];
    };
    private void init_animals(int[] animal_numbers) throws BadGroundException {
        int c = 0; // c holds the total number of animals to create
        for (int animalNumber : animal_numbers) {c = c + animalNumber;}

        animals = new Animal[c];
        int n = 0; //Index of each animal type
        for (int i = 0; i < animal_numbers.length; i++){
            for (int j = 0; j < animal_numbers[i]; j++){
                switch (i){
                    case 0:
                        animals[n+j] = new Crab(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 1:
                        animals[n+j] = new Deer(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 2:
                        animals[n+j] = new Falcon(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 3:
                        animals[n+j] = new Hedgehog(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 4:
                        animals[n+j] = new JellyFish(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 5:
                        animals[n+j] = new Seagull(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 6:
                        animals[n+j] = new Snake(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 7:
                        animals[n+j] = new Turtle(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
                    case 8:
                        animals[n+j] = new Wolf(rand.nextInt(sizewl[0]), rand.nextInt(sizewl[1]));
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
