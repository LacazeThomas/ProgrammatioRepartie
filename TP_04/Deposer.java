import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;


public class Deposer extends Thread{

	public BAL2 mb;
	String lettre;

	public Deposer(BAL2 parMoniteur, String parlettre){
		mb = parMoniteur;
		lettre = parlettre;
	}
	
	public void run() {
		if(mb.write(lettre) == false){
			System.out.println("plein");
		}else{
			System.out.println("ecrit : "+lettre);
		}
	}	
}