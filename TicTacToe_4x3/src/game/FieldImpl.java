package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FieldImpl extends JFrame implements ActionListener {

    private int x;
    private int y;
    private String value;
    JPanel panel;
    JButton[] button;
    int count = 0;
    int sign = 0;
    JFrame frame;

    public FieldImpl() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(3, 4));
        button = new JButton[12];
        for (int i = 0; i <= 11; i++) {
            button[i] = new JButton();
            frame.add(button[i]);
            button[i].setEnabled(false);
            button[i].addActionListener(this);
        }
        initField();
        frame.pack();
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("TicTacToe 4x3");
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private FieldImpl(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = "_";
    }

    private void initField() {
        button[0].setText("11");
        button[1].setText("12");
        button[2].setText("13");
        button[3].setText("14");
        button[4].setText("21");
        button[5].setText("22");
        button[6].setText("23");
        button[7].setText("24");
        button[8].setText("31");
        button[9].setText("32");
        button[10].setText("33");
        button[11].setText("34");
    }

    public static FieldImpl valueOf(int x, int y) {
        assert (x > 0 && y > 0);
        return new FieldImpl(x, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isMarked() {
        return value != "_";
    }

    public boolean isFree() {
        return !isMarked();
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isX() {
        return this.value == "X";
    }

    public boolean isO() {
        return this.value == "O";
    }

    @Override
    public String toString() {
        return "Field[Zeile: " + (getY() + 1) + " Spalte: " + (getX() + 1) + "]";
    }

    public void setGUI(int x, int y, String val) {
        if (x == 1 && y == 1) {
            button[0].setText(val);
            button[0].setEnabled(true);
        }
        if (x == 1 && y == 2) {
            button[1].setText(val);
            button[1].setEnabled(true);
        }
        if (x == 1 && y == 3) {
            button[2].setText(val);
            button[2].setEnabled(true);
        }
        if (x == 1 && y == 4) {
            button[3].setText(val);
            button[3].setEnabled(true);
        }
        if (x == 2 && y == 1) {
            button[4].setText(val);
            button[4].setEnabled(true);
        }
        if (x == 2 && y == 2) {
            button[5].setText(val);
            button[5].setEnabled(true);
        }
        if (x == 2 && y == 3) {
            button[6].setText(val);
            button[6].setEnabled(true);
        }
        if (x == 2 && y == 4) {
            button[7].setText(val);
            button[7].setEnabled(true);
        }
        if (x == 3 && y == 1) {
            button[8].setText(val);
            button[8].setEnabled(true);
        }
        if (x == 3 && y == 2) {
            button[9].setText(val);
            button[9].setEnabled(true);
        }
        if (x == 3 && y == 3) {
            button[10].setText(val);
            button[10].setEnabled(true);
        }
        if (x == 3 && y == 4) {
            button[11].setText(val);
            button[11].setEnabled(true);
        }
    }

    public void verloren() {
        JOptionPane.showMessageDialog(frame, "Du hast verloren ! :-) ");
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
