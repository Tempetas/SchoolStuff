package Circles;

import sum.kern.Fenster;
import javax.swing.JPanel;

public class BetterScreen extends Fenster {
    public BetterScreen(final int pBreite, final int pHoehe) {
        super(pBreite, pHoehe);
    }

    //The only change, allows to access the jpanel from the pen class
    public JPanel getPanel() {
        return this.privatPanel();
    }
}