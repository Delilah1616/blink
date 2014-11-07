import uk.ac.mdx.cs.asip.SimpleSerialBoard;
import uk.ac.mdx.cs.asip.AsipClient;

public class Analoninput extends SimpleSerialBoard {


	public Analoninput (String port) {
    super (port);
    
	try {
		setPinMode(2 + 14, AsipClient.ANALOG);
		Thread.sleep(100);
		setAutoReportInterval(50);
		Thread.sleep(100);
		setPinMode(13, AsipClient.OUTPUT);
	
	}catch (InterruptedException e) {
	e.printStackTrace();
	}
	
	
	
	}
	
	public void switchLooptest() {
		int potValue = analogRead(2);
		//int buttonState = AsipClient.LOW;
		int oldstate = AsipClient.LOW;
		while (true) { 
			potValue = analogRead(2);
			
			digitalWrite(13, AsipClient.HIGH);
			try {
				Thread.sleep(100+potValue);

			digitalWrite(13, AsipClient.LOW);
			Thread.sleep(100+potValue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
	
