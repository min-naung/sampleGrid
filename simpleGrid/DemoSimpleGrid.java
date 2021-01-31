import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class DemoSimpleGrid {
    public static void main( String args[] ) {
	SimpleScreen canvas = new SimpleScreen();
        canvas.setBackground( Color.white );

        final int NoButtons = 2;
        JButton buttons[] = new JButton [ NoButtons ];

        buttons[0] = new JButton ("Clear");
        buttons[0].addActionListener( new ButtonAction( buttons[0], canvas ));
        buttons[1] = new JButton ("Switch Grid");
        buttons[1].addActionListener( new ButtonAction( buttons[1], canvas ));

        JPanel p1 = new JPanel();
        for(int ii = 1; ii <= NoButtons; ii++ )
            p1.add( buttons[ii-1] );

        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );
        panel.add(   canvas, BorderLayout.CENTER );
        panel.add(       p1, BorderLayout.SOUTH );

        JFrame frame = new JFrame("Draw Simple Grid");
        frame.getContentPane().setLayout( new BorderLayout() );
        frame.getContentPane().add( panel );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 700, 500);
        frame.setVisible(true);
    }
}


class ButtonAction implements ActionListener {
    private JButton b;
    private SimpleScreen gs;

    public ButtonAction ( JButton b, SimpleScreen gs ) {
        this.b  = b;
        this.gs = gs;
    }

    public void actionPerformed ( ActionEvent e ) {
        String s = new String( e.getActionCommand() );

        if( s.compareTo("Clear") == 0 ) { gs.clearScreen(); }

        if( s.compareTo("Switch Grid") == 0 ) {
            if ( gs.grop.getGrid() == true ) {
                gs.grop.setGrid( false );
                gs.clearScreen();
            } else {
                gs.drawGrid();
            }
        }
    }
}
