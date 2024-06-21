package pizzaplaces;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;

class MyCanvas extends JPanel implements ActionListener {
    Label myPrompt1;
    TextField value1;
    Button addButton;
    int ovalWidth = 300;
    int ovalHeight = 300;

    public MyCanvas() {
        init();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        int x = (width - ovalWidth) / 2;
        int y = (height - ovalHeight) / 2;
        g.setColor(Color.yellow);
        g.fillOval(x, y, ovalWidth, ovalHeight);
    }

    public void init() {
        myPrompt1 = new Label("Enter pizza size (in pixels):");
        value1 = new TextField(10);
        addButton = new Button("Change Size");

        add(myPrompt1);
        add(value1);
        add(addButton);
        addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int newSize = Integer.parseInt(value1.getText());
        if (newSize > 0) {
            ovalWidth = newSize;
            ovalHeight = newSize;
            repaint();
        }
    }
}

public class pizza {
    public static void main(String[] a) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 600, 600);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
    }
}
