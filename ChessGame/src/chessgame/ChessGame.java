package chessgame;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChessGame {
    public static void main(String[] args) {

        LinkedList<Piece> ps = new LinkedList<>();

        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 528, 551);

        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (white) {
                            g.setColor(Color.white.darker());
                        }
                        else {
                            g.setColor(Color.black.brighter());
                        }

                        g.fillRect(i * 64, j * 64, 64, 64);
                        white = !white;

                    }
                    white = !white;
                }
            }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}