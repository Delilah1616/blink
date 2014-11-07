import uk.ac.mdx.cs.asip.SimpleSerialBoard;
import uk.ac.mdx.cs.asip.AsipClient;


public class LightSwitch extends SimpleSerialBoard {

	public LightSwitch(String port) {
		super(port);
		// TODO Auto-generated constructor stub
		
		try{
			setPinMode(13, AsipClient.OUTPUT);
			Thread.sleep(500);
			setPinMode(2, AsipClient.INPUT_PULLUP);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
				}
	
	public void switchLoop() {
		int buttonState = AsipClient.LOW;
		int oldstate = AsipClient.LOW;
		while (true) { 
			buttonState = digitalRead(2);
			
			if ((buttonState != oldstate) && (buttonState == AsipClient.HIGH)){
				digitalWrite(13, AsipClient.HIGH);
			}
			
			else if ( buttonState != oldstate ){
				digitalWrite(13, AsipClient.LOW);
			}
			
			oldstate = buttonState;
		}
	}
		}
