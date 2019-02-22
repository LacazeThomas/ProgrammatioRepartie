import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame 
{
    private final int LARG=850, HAUT=75, OCU=29;
    JButton[] sonButton = new JButton[OCU];
    Thread[] tache = new Thread[OCU];
    Boolean[] stop = new Boolean[OCU];
    UnMobile[] sonMobile = new UnMobile[OCU];
    
    public UneFenetre()
    {
        super("prog");
        Semaphore sem = new Semaphore(2);
        this.setLayout(new GridLayout(OCU,2));
        for(int i=0;i<OCU;i++){
            stop[i] = false;
            sonMobile[i] = new UnMobile(LARG, HAUT,sem);
            sonButton[i] = new JButton("Stop");
            this.getContentPane().add(sonMobile[i]);
            this.getContentPane().add(sonButton[i]);
            tache[i] = new Thread(sonMobile[i]);
            tache[i].start();
            sonButton[i].addActionListener(listener);
        }
        setSize(LARG+LARG,HAUT*OCU);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
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
                        src.setText("Stop");
                    }else{
                        stop[i] = true;
                        tache[i].suspend();
                        src.setText("Resume");
                    }
                }
            }
        }
    };
    
}
