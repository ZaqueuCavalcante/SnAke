package graphics;

import javax.swing.JFrame;

import actors.nodes.Node;
import actors.snakes.Snake;
import basis.MatrixGraph;

public class GraphicsInterface extends JFrame {

    private static final long serialVersionUID = 1L;

    public GraphicsInterface() {
        add(new Panel());
        setTitle("SnA*ke");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void show(Node node) {}

    public void show(Snake snake) {}

    public void show(MatrixGraph matrixGraph) {}

}
