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

public class Deposer extends Thread{

	public Moniteur mb;

	public Deposer(Moniteur parMoniteur){
		mb = parMoniteur;
	}
	
	public void run(){
		mb.write();
	}
}