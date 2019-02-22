import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {

		Moniteur mb = new Moniteur();
		int OCU = 10;
		Deposer[] consommateur = new Deposer[OCU];
		Retirer[] producteur = new Retirer[OCU];

		Thread[] thProducteur = new Thread[OCU];
		Thread[] thConsommateur = new Thread[OCU];

		for(int i=0;i<OCU;i++){
			consommateur[i] = new Deposer(mb);
			producteur[i] = new Retirer(mb);

			thProducteur[i] = new Thread(producteur[i]);
			thConsommateur[i] = new Thread(consommateur[i]);
	
			thConsommateur[i].start();
			thProducteur[i].start();
		}
		
	}

}
