public class Moniteur {

	String buffer;
	Boolean available;

	public Moniteur(){
		available = true;
		buffer = "Init";	
	}

	public synchronized void read(){
		//Tant que occupé
		while(available == false){
			try {
				sleep(100);
			} catch(InterruptedException e){
			};
		}
		System.out.println(buffer);
		available = false;
		notifyAll();
	}

	public synchronized void write(String parWrite){
		//Tant que pas occupé
		while(available == true){
			try {
				sleep(100);
			} catch(InterruptedException e){
			};
		}
		buffer = parWrite;
		available = true;
		notifyAll();
	}
}