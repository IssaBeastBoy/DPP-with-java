import org.jcsp.lang.*;

/** Producer class: produces one random integer and sends on
  * output channel, then terminates.
  */
public class Producer implements CSProcess
  { private ChannelOutputInt channel;
  	private int range;

    public Producer (final ChannelOutputInt out, int range)
      { 
    	channel = out;
    	this.range = range;
      } // constructor

    public void run ()
      { 
    	for(int count = 0; count<100; count++) {
    		int item = (int)(Math.random()*100)+range;
            channel.write(item);
    	}
    	channel.write(-range);
      } // run

  } // class Producer
