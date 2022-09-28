// 
// Decompiled by Procyon v0.5.36
// 

package sum.kern;

import java.awt.event.ActionEvent;
import java.awt.FontMetrics;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

class Warnung extends JDialog implements ActionListener
{
    JButton hatButton;
    JLabel hatLabel1;
    JLabel hatLabel2;
    boolean zOk;
    
    protected Warnung(final JFrame pFenster, final String pMeldung) {
        super(pFenster, "Warnung", true);
        this.getContentPane().setLayout(null);
        this.setResizable(false);
        this.setSize(300, 150);
        this.setLocation(200, 100);
        (this.hatButton = new JButton("Ok")).addActionListener(this);
        this.hatButton.setLocation(120, 70);
        this.hatButton.setSize(60, 30);
        this.getContentPane().add(this.hatButton);
        final FontMetrics fm = pFenster.getGraphics().getFontMetrics();
        final int laenge = fm.stringWidth(pMeldung);
        (this.hatLabel1 = new JLabel("SuM-Fehler:")).setLocation(10, 10);
        this.hatLabel1.setSize(280, 20);
        this.getContentPane().add(this.hatLabel1);
        (this.hatLabel2 = new JLabel(pMeldung)).setLocation(5 + (280 - laenge) / 2, 40);
        this.hatLabel2.setSize(280, 20);
        this.getContentPane().add(this.hatLabel2);
        this.zOk = false;
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent pEvent) {
        this.zOk = pEvent.getActionCommand().equals("Ok");
        this.setVisible(false);
        this.dispose();
    }
    
    protected boolean istOk() {
        return this.zOk;
    }
}
