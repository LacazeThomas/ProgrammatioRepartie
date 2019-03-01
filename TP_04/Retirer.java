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

public class Retirer extends Thread{
	public BAL2 mb;

	public Retirer(BAL2 parMoniteur){
		mb = parMoniteur;
	}
	
	public void run(){
		while(true){
	try {
				System.out.println("lit : "+mb.read());
			}  catch (InterruptedException e) {
			}	
		}
		
	}
}