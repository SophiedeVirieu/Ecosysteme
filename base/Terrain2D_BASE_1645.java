package base;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Terrain2D extends JPanel {
    private final int[][] heights;
    private final int cellSize = 10; // Taille de chaque "case" du terrain

    public Terrain2D(int width, int height) {
        heights = generateTerrain(width, height);
        smoothTerrain(heights, 5); // Appliquer un lissage sur x itérations
    }

    // Génération d'un terrain 2D avec des hauteurs aléatoires
    private int[][] generateTerrain(int width, int height) {
        int[][] terrain = new int[width][height];
        Random random = new Random();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                terrain[x][y] = random.nextInt(256); // Hauteurs entre 0 et 255
            }
        }

        return terrain;
    }

    // Lissage du terrain en moyennant chaque cellule avec ses voisins
    private void smoothTerrain(int[][] terrain, int iterations) {
        int width = terrain.length;
        int height = terrain[0].length;

        for (int iter = 0; iter < iterations; iter++) {
            int[][] temp = new int[width][height];
            int nb_voisin = 3;
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int sum = 0;
                    int count = 0;

                    // Moyenne des voisins
                    for (int dx = -nb_voisin; dx <= nb_voisin; dx++) {
                        for (int dy = -nb_voisin; dy <= nb_voisin; dy++) {
                            int nx = x + dx;
                            int ny = y + dy;

                            if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                                sum += terrain[nx][ny];
                                count++;
                            }
                        }
                    }
                    temp[x][y] = sum / count; // Moyenne des hauteurs voisines
                }
            }
            // Copier le terrain lissé temporaire vers l'original
            for (int x = 0; x < width; x++) {
                System.arraycopy(temp[x], 0, terrain[x], 0, height);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int x = 0; x < heights.length; x++) {
            for (int y = 0; y < heights[x].length; y++) {
                int height = heights[x][y];

                // Attribuer une couleur en fonction de la hauteur
                if (height < 123) {
                    g2d.setColor(new Color(63, 72, 204)); // Bleu pour l'eau
                    g2d.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    if (new Random().nextDouble() < 0.05) {
                        new Fish(x,y);
                        g2d.setColor(new Color(0, 170, 180)); // Bleu cyan
                        int centerX = x * cellSize + cellSize / 4; // Position horizontale du cercle
                        int centerY = y * cellSize + cellSize / 4; // Position verticale du cercle
                        int diameter = cellSize/2 ; // Diamètre du cercle
                        g2d.fillOval(centerX, centerY, diameter, diameter);
                    }


                } else if (height < 125) {
                    g2d.setColor(new Color(255, 242, 0)); // Jaune pour le Sable
                    g2d.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    if (new Random().nextDouble() < 0.05) {
                        new Algues(x,y);
                        g2d.setColor(new Color(13, 66, 28)); // Bleu cyan
                        int centerX = x * cellSize + cellSize / 4; // Position horizontale du cercle
                        int centerY = y * cellSize + cellSize / 4; // Position verticale du cercle
                        int diameter = cellSize/2 ; // Diamètre du cercle
                        g2d.fillOval(centerX, centerY, diameter, diameter);
                    }

                } else if (height < 129) {
                    g2d.setColor(new Color(181, 230, 29)); // vert claire pour la plaine
                    g2d.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    if (new Random().nextDouble() < 0.05) {
                        new Herb(x,y);
                        g2d.setColor(new Color(111, 125, 29)); // Bleu cyan
                        int centerX = x * cellSize + cellSize / 4; // Position horizontale du cercle
                        int centerY = y * cellSize + cellSize / 4; // Position verticale du cercle
                        int diameter = cellSize/2 ; // Diamètre du cercle
                        g2d.fillOval(centerX, centerY, diameter, diameter);
                    }

                } else {
                    g2d.setColor(new Color(34, 177, 76));
                    g2d.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    if (new Random().nextDouble() < 0.05) {
                        new Berry(x,y);
                        g2d.setColor(new Color(178, 34, 34)); // Rouge foncé
                        int centerX = x * cellSize + cellSize / 4; // Position horizontale du cercle
                        int centerY = y * cellSize + cellSize / 4; // Position verticale du cercle
                        int diameter = cellSize/2 ; // Diamètre du cercle
                        g2d.fillOval(centerX, centerY, diameter, diameter);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int width = 172; // Largeur du terrain en cases
        int height = 108; // Hauteur du terrain en cases

        JFrame frame = new JFrame("Terrain 2D");
        Terrain2D terrain = new Terrain2D(width, height);

        frame.add(terrain);
        frame.setSize(width * 10, height * 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
