package chessgame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ChessGame {
    public static void main(String[] args) throws IOException {

        LinkedList<Piece> ps = new LinkedList<>();
        BufferedImage all = ImageIO.read(new File("C:\\Users\\gianc\\Git_Hub_Repositories\\ChessGame\\ChessGame\\src\\chessgame\\chess.png"));
        Image imgs[] = new Image[12];

        int ind = 0;
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }

        Piece wking = new Piece(5, 2, true, "king", ps);
        Piece bpawn = new Piece(5, 3, false, "pawn", ps);
        Piece wrook = new Piece(5, 5, true, "rook", ps);

        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 528, 551);

        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (white) {
                            g.setColor(new Color(235, 235, 208));
                        }
                        else {
                            g.setColor(new Color(119, 148, 85));
                        }

                        g.fillRect(i * 64, j * 64, 64, 64);
                        white = !white;

                    }
                    white = !white;
                }
                for (Piece p: ps) {
                    int ind = 0;

                    if (p.name.equalsIgnoreCase("king")) {
                        ind = 0;
                    }
                    if (p.name.equalsIgnoreCase("queen")) {
                        ind = 1;
                    }
                    if (p.name.equalsIgnoreCase("bishop")) {
                        ind = 2;
                    }
                    if (p.name.equalsIgnoreCase("knight")) {
                        ind = 3;
                    }
                    if (p.name.equalsIgnoreCase("rook")) {
                        ind = 4;
                    }
                    if (p.name.equalsIgnoreCase("pawn")) {
                        ind = 5;
                    }
                    if (!p.isWhite) {
                        ind += 6;
                    }
                    g.drawImage(imgs[ind], p.xp * 64, p.yp * 64, this);
                }
            }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}