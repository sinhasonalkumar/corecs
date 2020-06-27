package corecs.designpattern.observerpattern.subscriber;

import corecs.designpattern.observerpattern.event.Event;

public class SubscriberImpl implements Subscriber {
	
	private String subscriberName;
	
	public SubscriberImpl(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	@Override
	public void push(Event event) {
		System.out.println(subscriberName + " -> Received Message :: " + event.getMessage());
	}

}
