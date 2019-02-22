import java.io.Console;
public class Moniteur {

	String buffer;
	Boolean available;

	public Moniteur(){
		available = false;
		buffer = "Init";
	}

	public synchronized void read(){
		//Tant que occupé
		while(available == false){
			try {
				wait(100);
			} catch(InterruptedException e){
			};
		}
		System.out.println(buffer);
		available = false;
		notifyAll();
	}

	public synchronized void write(){
		//Tant que pas occupé
		while(available == true){
			try {
				wait(100);
			} catch(InterruptedException e){
			};
		}

		Console console = System.console();
		String input = console.readLine("Enter input:");

		if(input.equals("q")){
			System.exit(1);
		}
		buffer = input;
		available = true;
		notifyAll();
	}
}