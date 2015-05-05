import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class testtable extends JFrame {

    public testtable() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        JPanel top = new JPanel();
        top.setBorder(new LineBorder(Color.RED, 1, true));

        JPanel bottom = new JPanel();
        bottom.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JPanel left = new JPanel();
        left.setBorder(new EtchedBorder(EtchedBorder.RAISED));

        JPanel right = new JPanel();
        right.setBorder(new MatteBorder(5, 5, 5, 5, Color.BLUE));

        JPanel center = new JPanel();
        center.setBorder(new BevelBorder(BevelBorder.RAISED));

        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(bottom, BorderLayout.SOUTH);
        getContentPane().add(left, BorderLayout.WEST);
        getContentPane().add(right, BorderLayout.EAST);
        getContentPane().add(center, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new testtable().setVisible(true);
            }
        });
    }
}