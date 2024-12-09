import java.util.List;

public abstract class TerrainResources extends Biomass {

    public enum food {FISH, ALGAE, GRASS, BERRIES};

    public TerrainResources(int x, int y) throws BadGroundException {
        super(x, y);
        this.bites = 3; // a resource is eaten in once

    }
}

// Honneur à Monjauze