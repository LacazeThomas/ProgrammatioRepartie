import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {

		BAL2 mb = new BAL2();
		int OCU_CONSO = 5;
		int OCU_PROD = 27;
		String[] lettre = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","*"};
		int y=0;

		Deposer[] producteur = new Deposer[OCU_PROD];
		Retirer[] consommateur  = new Retirer[OCU_CONSO];

		Thread[] thProducteur = new Thread[OCU_PROD];
		Thread[] thConsommateur = new Thread[OCU_CONSO];

		for(int i=0;i<OCU_PROD;i++){
			producteur[i] = new Deposer(mb,lettre[y]);
			y++;
			thProducteur[i] = new Thread(producteur[i]);
			thProducteur[i].start();
		}

		for(int i=0;i<OCU_CONSO;i++){
			consommateur[i] = new Retirer(mb);
			thConsommateur[i] = new Thread(consommateur[i]);
			thConsommateur[i].start();
		}
	}
}
