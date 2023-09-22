package chessgame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ChessGame {
    public static void main(String[] args) throws IOException {

        LinkedList<Piece> ps = new LinkedList<>();
        BufferedImage all = ImageIO.read(new File("C:\\Users\\gianc\\Git_Hub_Repositories\\ChessGame\\ChessGame\\src\\chessgame\\chess.png"));
        Image imgs[] = new Image[12];

        // Cuts the images of the pieces from the imported image
        int ind = 0;
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }

        // Black Pieces on Board
        Piece bRook1 = new Piece(0, 0, false, "rook", ps);
        Piece bKnight1 = new Piece(1, 0, false, "knight", ps);
        Piece bBishop1 = new Piece(2, 0, false, "bishop", ps);
        Piece bQueen = new Piece(3, 0, false, "queen", ps);
        Piece bKing = new Piece(4, 0, false, "king", ps);
        Piece bBishop2 = new Piece(5, 0, false, "bishop", ps);
        Piece bKnight2 = new Piece(6, 0, false, "knight", ps);
        Piece bRook2 = new Piece(7, 0, false, "rook", ps);

        Piece bPawn1 = new Piece(1, 1, false, "pawn", ps);
        Piece bPawn2 = new Piece(2, 1, false, "pawn", ps);
        Piece bPawn3 = new Piece(3, 1, false, "pawn", ps);
        Piece bPawn4 = new Piece(4, 1, false, "pawn", ps);
        Piece bPawn5 = new Piece(5, 1, false, "pawn", ps);
        Piece bPawn6 = new Piece(6, 1, false, "pawn", ps);
        Piece bPawn7 = new Piece(7, 1, false, "pawn", ps);
        Piece bPawn8 = new Piece(0, 1, false, "pawn", ps);

        // White Pieces on Board
        Piece wRook1 = new Piece(0, 7, true, "rook", ps);
        Piece wKnight1 = new Piece(1, 7, true, "knight", ps);
        Piece wBishop1 = new Piece(2, 7, true, "bishop", ps);
        Piece wQueen = new Piece(3, 7, true, "queen", ps);
        Piece wKing = new Piece(4, 7, true, "king", ps);
        Piece wBishop2 = new Piece(5, 7, true, "bishop", ps);
        Piece wKnight2 = new Piece(6, 7, true, "knight", ps);
        Piece wRook2 = new Piece(7, 7, true, "rook", ps);

        Piece wPawn1 = new Piece(1, 6, true, "pawn", ps);
        Piece wPawn2 = new Piece(2, 6, true, "pawn", ps);
        Piece wPawn3 = new Piece(3, 6, true, "pawn", ps);
        Piece wPawn4 = new Piece(4, 6, true, "pawn", ps);
        Piece wPawn5 = new Piece(5, 6, true, "pawn", ps);
        Piece wPawn6 = new Piece(6, 6, true, "pawn", ps);
        Piece wPawn7 = new Piece(7, 6, true, "pawn", ps);
        Piece wPawn8 = new Piece(0, 6, true, "pawn", ps);

        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 528, 551);

        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;

                // Loop that Draws the Board
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        // Fills in the squares with colors
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
        
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}