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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

class Eingabe extends JDialog implements ActionListener
{
    JButton hatButton;
    JLabel hatLabel;
    JTextField hatEingabe;
    String zEingabe;
    
    protected Eingabe(final JFrame pFenster, final String pMeldung) {
        super(pFenster, "Eingabe", true);
        this.getContentPane().setLayout(null);
        this.setResizable(false);
        this.setSize(300, 130);
        this.setLocation(200, 100);
        (this.hatButton = new JButton("Ok")).addActionListener(this);
        this.hatButton.setLocation(120, 70);
        this.hatButton.setSize(60, 30);
        this.getContentPane().add(this.hatButton);
        final FontMetrics fm = pFenster.getGraphics().getFontMetrics();
        final int laenge = fm.stringWidth(pMeldung);
        (this.hatLabel = new JLabel(pMeldung)).setLocation(10, 10);
        this.hatLabel.setSize(280, 20);
        this.getContentPane().add(this.hatLabel);
        (this.hatEingabe = new JTextField("")).setLocation(10, 40);
        this.hatEingabe.setSize(280, 20);
        this.getContentPane().add(this.hatEingabe);
        this.zEingabe = "";
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent pEvent) {
        final boolean lOk = pEvent.getActionCommand().equals("Ok");
        this.zEingabe = this.hatEingabe.getText();
        this.setVisible(false);
        this.dispose();
    }
    
    protected String eingabe() {
        return this.zEingabe;
    }
}
