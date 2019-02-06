package play;

public class Play implements Runnable{
	
	public Play() {
		run();
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello snake!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
