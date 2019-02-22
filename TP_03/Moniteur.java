import java.io.Console;
public class Moniteur {
	
	String[] lettre = {"a","b","c","d","*"};
	int queue = 0;
	int tete = 0;
	String[] buffer = new String[lettre.length];
	int available = 0;

	public Moniteur(){
	}

	public synchronized void read(){
		//Tant que occupé
		if(!lettre[queue].equals("*")){
			while(available <= 0){
				try {
					wait(500);
				} catch(InterruptedException e){
				};
			}
			System.out.println(lettre[queue]);
			queue++;
			available--;
			notifyAll();
		}
	}

	public synchronized void write(){
		//Tant que pas occupé
		if(!lettre[tete].equals("*")){
			while(available > lettre.length){
				try {
					wait(100);
				} catch(InterruptedException e){
				};
			}
			System.out.print("écriture\n");
			buffer[tete] = lettre[tete];
			available++;
			tete++;
			notifyAll();
		}
	}
}