import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {

		Moniteur mb = new Moniteur();
		Producteur producteur = new Producteur(mb);
		Consommateur consommateur = new Consommateur(mb);


		producteur.mb.read();
		producteur.mb.write("test");
	}

}
