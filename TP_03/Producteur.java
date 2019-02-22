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


public class Producteur extends Thread{

	public Moniteur mb;

	public Producteur(Moniteur parMoniteur){
		mb = parMoniteur;
	}
	
	public void run(){
	}
}