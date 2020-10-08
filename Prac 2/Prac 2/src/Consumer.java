import org.jcsp.lang.*;

/** Consumer class: reads one int from input channel, displays it, then
  * terminates.
  */
public class Consumer implements CSProcess
  { 
	private AltingChannelInputInt channel;
  	private ChannelOutputInt item;
  	private int name;

    public Consumer (final AltingChannelInputInt in, final ChannelOutputInt item, int name)
      { 
    	channel = in;
        this.item = item;
        this.name = name;
      } // constructor

    public void run ()
      { 
	    	for(int start = 0; start<100; start++) {
	    		item.write(1);
	    		System.out.println("Consumer "+ name + ": " + channel.read());
	    				        
	    	}
	    	item.write(-name);
      } // run

  } // class Consumer