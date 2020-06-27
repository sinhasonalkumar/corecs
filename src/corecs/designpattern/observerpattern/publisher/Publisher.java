package corecs.designpattern.observerpattern.publisher;

import corecs.designpattern.observerpattern.event.Event;
import corecs.designpattern.observerpattern.subscriber.Subscriber;

public interface Publisher {

	public void publish(Event event);
	
	public void subscribe(Subscriber subscriber);
	
	public void unSubscribe(Subscriber subscriber);
}
