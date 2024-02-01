import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game implements ActionListener {

    JFrame frame = new JFrame("Tic Tac Toe");
    JPanel text_panel = new JPanel();
    JButton res_button = new JButton();
    JPanel button_panel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean firstPlayer_turn;
    Random random = new Random();

    public Game() {

// Frame
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null); // To launch the frame in the center of the screen
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.ORANGE); // Content pane holds the objects
        frame.setVisible(true);
        frame.add(text_panel, BorderLayout.NORTH);
        frame.add(button_panel);

// Text
        text.setFont(new Font("SansSerif", Font.BOLD, 70));
        text.setText("Tic Tac Toe");
        text.setForeground(Color.ORANGE);

// Text Panel
        text_panel.add(text);
        text_panel.setBackground(Color.BLACK);

// Restart Button
        res_button.setText("Restart");
        res_button.setFont(new Font("SansSerif", Font.BOLD, 50));
        res_button.setForeground(Color.ORANGE);
        res_button.setBackground(Color.BLACK);
        res_button.setFocusable(false); // To prevent access to restart button except clicking

// Buttons
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.BLACK);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFocusable(false); // To prevent access to buttons except clicking
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Serif", Font.BOLD, 120));
            buttons[i].setBackground(Color.BLACK);
        }

// Start
        try
        {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        firstTurn();

    }

    public void firstTurn() {

        if (random.nextInt(2) == 0) {
            firstPlayer_turn = true;
            text.setText("X Turn");
        } else {
            firstPlayer_turn = false;
            text.setText("O Turn");
        }
    }

    public boolean isAnyWin() {

// Checking horizontal combos
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) &&
                    buttons[i + 1].getText().equals(buttons[i + 2].getText())) {
                return true;
            }
        }

// Checking vertical combos
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) &&
                    buttons[i + 3].getText().equals(buttons[i + 6].getText())) {
                return true;
            }
        }

// Checking left to right diagonal combo
        if (buttons[0].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[8].getText())) {
            return true;
        }

// Checking right to left diagonal combo
        return (buttons[2].getText().equals(buttons[4].getText()) &&   // Since it's the last return statement
                buttons[4].getText().equals(buttons[6].getText()));    // of the boolean method
    }                                                                  // you can only return its result

    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }


    public void check() {

// Check No Wins
        if (!isAnyWin() && isBoardFull()) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            text.setText("Game Over");
            setResButton();
            restartGame();

        }

// Check X
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))


        ) {
            xWins(0, 1, 2);
        }

        if (
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))


        ) {
            xWins(3, 4, 5);
        }

        if (
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))


        ) {
            xWins(6, 7, 8);
        }

        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))


        ) {
            xWins(0, 3, 6);
        }

        if (
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))


        ) {
            xWins(1, 4, 7);
        }

        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))


        ) {
            xWins(2, 5, 8);
        }

        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))


        ) {
            xWins(0, 4, 8);
        }

        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))


        ) {
            xWins(2, 4, 6);
        }


// Check O

        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))


        ) {
            oWins(0, 1, 2);
        }

        if (
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))


        ) {
            oWins(3, 4, 5);
        }

        if (
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))


        ) {
            oWins(6, 7, 8);
        }

        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))


        ) {
            oWins(0, 3, 6);
        }

        if (
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))


        ) {
            oWins(1, 4, 7);
        }

        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))


        ) {
            oWins(2, 5, 8);
        }

        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))


        ) {
            oWins(0, 4, 8);
        }

        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))


        ) {
            oWins(2, 4, 6);
        }

    }

    public void setResButton() {
        frame.add(res_button, BorderLayout.SOUTH);
    }

    public void restartGame() {
        res_button.addActionListener(e -> {
            frame.remove(res_button);
            for (int i = 0; i < 9; i++) {
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setBackground(Color.BLACK);
            }
            firstTurn();
        });
    }

    public void xWins(int a, int b, int c) {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("X Won");
        buttons[a].setBackground(Color.ORANGE);
        buttons[b].setBackground(Color.ORANGE);
        buttons[c].setBackground(Color.ORANGE);
        setResButton();
        restartGame();

    }

    public void oWins(int a, int b, int c) {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("O Won");
        buttons[a].setBackground(Color.ORANGE);
        buttons[b].setBackground(Color.ORANGE);
        buttons[c].setBackground(Color.ORANGE);
        setResButton();
        restartGame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (firstPlayer_turn) {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        firstPlayer_turn = false;
                        text.setText("O Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        firstPlayer_turn = true;
                        text.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }
}
