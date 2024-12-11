public abstract class Terrain_ressources {
    protected int calories;
    protected int TTR_Max; // Time To Regenerate in number of rounds
    protected int TTR;
    protected int x;
    protected int y;
    protected boolean Alive; // If the plant as not been eaten yet, it's alive, if not, it's dead

    //Constructeur
    public Terrain_ressources(boolean alive, int x, int y, int TTR, int TTR_Max, int calories) {
        Alive = alive;
        this.y = y;
        this.x = x;
        this.TTR = TTR;
        this.TTR_Max = TTR_Max;
        this.calories = calories;
    }


    // Getter
    public int getCalories() {
        return calories;
    }

    public int getTTR() {
        return TTR;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTTR_Max() {
        return TTR_Max;
    }

    public boolean isAlive() {
        return Alive;
    }

    // Methode de class
    public void Regeneartion() {
        if (this.TTR <= 0) {
            this.TTR = 0;
            this.Alive = true;
        } else {
            this.TTR -= 1;
        }
    }

    public int Eaten() {
        this.Alive = false;
        this.TTR = this.TTR_Max;
        return this.calories;
    }
}
