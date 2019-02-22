/**
 * 
 */
import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;
//Perimetre d'une classe
//Perimetre du container


//Exclusion est classe scope est donc commun à tous les ensembles de cette classe
class Exclusion{}

public class Affichage extends Thread{
	String texte; 
	static Exclusion exclusionImpression = new Exclusion(); //Classe scope 
	static SemaphoreBinaire sem = new SemaphoreBinaire(1);

	public Affichage (String txt){
		texte=txt;
	}
	
	public void run(){
		//synchronized()
		sem.syncWait();
		for (int i=0; i<texte.length(); i++){
			System.out.print(texte.charAt(i));
			try {
				sleep(100);
			} catch(InterruptedException e){

			};
		}
		sem.syncSignal();
	}
}