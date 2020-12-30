package graphics;

import javax.swing.JFrame;

public class MyJFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public MyJFrame() {
        add(new MyJPanel());
        setTitle("SnA*ke");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
