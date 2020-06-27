package corecs.designpattern.observerpattern;

import corecs.designpattern.observerpattern.event.EventImpl;
import corecs.designpattern.observerpattern.publisher.Publisher;
import corecs.designpattern.observerpattern.publisher.PublisherImpl;
import corecs.designpattern.observerpattern.subscriber.Subscriber;
import corecs.designpattern.observerpattern.subscriber.SubscriberImpl;

public class ObserverPatternShowcaseMain {

	public static void main(String[] args) {
		
		Publisher examplePublisher = new PublisherImpl("examplePublisher");
		
		Subscriber subscriber1 = new SubscriberImpl("subscriber1");
		Subscriber subscriber2 = new SubscriberImpl("subscriber2");
		Subscriber subscriber3 = new SubscriberImpl("subscriber3");
		
		examplePublisher.subscribe(subscriber1);
		examplePublisher.subscribe(subscriber2);
		examplePublisher.subscribe(subscriber3);
		
		examplePublisher.publish(new EventImpl("Hello Father Of Rective Programming ! "));
		
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		examplePublisher.unSubscribe(subscriber2);
		
		examplePublisher.publish(new EventImpl("Hello Father Of Rective Programming Again ! "));
		
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
	}
}
