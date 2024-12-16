import base.Terrain2D;
import javax.swing.*;

public class Main {
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