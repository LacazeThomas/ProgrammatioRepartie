import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame 
{
    private final int LARG=400, HAUT=250, OCU=5;
    JButton[] sonButton = new JButton[OCU];
    Thread[] tache = new Thread[OCU];
    Boolean[] stop = new Boolean[OCU];
    UnMobile[] sonMobile = new UnMobile[OCU];
    
    public UneFenetre()
    {
        super("prog");
        this.setLayout(new GridLayout(OCU,2));
        for(int i=0;i<OCU;i++){
            stop[i] = false;
            sonMobile[i] = new UnMobile(LARG, HAUT);
            sonButton[i] = new JButton("Stop/Resume");
            this.getContentPane().add(sonMobile[i]);
            this.getContentPane().add(sonButton[i]);
            tache[i] = new Thread(sonMobile[i]);
            tache[i].start();
            sonButton[i].addActionListener(listener);
        }
        setSize(LARG+450,HAUT*OCU);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        /*sonMobile = new UnMobile(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(LARG,HAUT);
        setVisible(true);
        setLocation(0, 0);
        tache = new Thread(sonMobile);
        tache.start();*/
        
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            for(int i=0;i<OCU;i++){
                if(src == sonButton[i]){
                    if(stop[i] == true){
                        stop[i] = false;
                        tache[i].resume();
                    }else{
                        stop[i] = true;
                        tache[i].suspend();
                    }
                }
            }
        }
    };
    
}
