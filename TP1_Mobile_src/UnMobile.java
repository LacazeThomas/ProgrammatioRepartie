import java.awt.*;
import javax.swing.*;
import java.io.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
	final int sonPas = 10, sonTemps=10, sonCote=10;
	Semaphore sem;
	Color color;
	Boolean in = false;
    
    UnMobile(int telleLargeur, int telleHauteur, Semaphore parSem){
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		sem = parSem;
		setSize(telleLargeur, telleHauteur);
    }

    public void run(){	
			while (true) {
		
				for (sonDebDessin=0; sonDebDessin <= saLargeur/3; sonDebDessin+= sonPas){
					
					color = Color.black;
					repaint();
					try{Thread.sleep(sonTemps);}
					catch (InterruptedException telleExcp)
						{telleExcp.printStackTrace();}
				}
				sem.syncWait();
				for (sonDebDessin= saLargeur/3; sonDebDessin <= saLargeur/3*2; sonDebDessin+= sonPas){
					
					color = Color.red;
					repaint();
					try{Thread.sleep(sonTemps);}
					catch (InterruptedException telleExcp)
						{telleExcp.printStackTrace();}
				}
				sem.syncSignal();
				for (sonDebDessin= saLargeur/3*2; sonDebDessin <= saLargeur/3*3; sonDebDessin+= sonPas){
					
					color = Color.black;
					repaint();
					try{Thread.sleep(sonTemps);}
					catch (InterruptedException telleExcp)
						{telleExcp.printStackTrace();}
				}
				for (sonDebDessin=saLargeur; sonDebDessin >= saLargeur/3*2; sonDebDessin-= sonPas){
					color = Color.black;
					repaint();
					try{Thread.sleep(sonTemps);}
					catch (InterruptedException telleExcp)
						{telleExcp.printStackTrace();}
				}
				sem.syncWait();
				for (sonDebDessin=saLargeur/3*2; sonDebDessin >= saLargeur/3*1; sonDebDessin-= sonPas){
					color = Color.red;
					repaint();
					try{Thread.sleep(sonTemps);}
					catch (InterruptedException telleExcp)
						{telleExcp.printStackTrace();}
				}
				sem.syncSignal();
				for (sonDebDessin=saLargeur/3*1; sonDebDessin >= 0; sonDebDessin-= sonPas){
					color = Color.black;
					repaint();
					try{Thread.sleep(sonTemps);}
					catch (InterruptedException telleExcp)
						{telleExcp.printStackTrace();}
				}
			}

    }

    public void paintComponent(Graphics telCG){
		super.paintComponent(telCG);
		telCG.setColor(color);
		telCG.fillRect(sonDebDessin, saHauteur/3, sonCote, sonCote);
    }
}