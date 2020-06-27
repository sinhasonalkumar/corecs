package corecs.designpattern.observerpattern.publisher;



import java.util.ArrayList;
import java.util.List;

import corecs.designpattern.observerpattern.event.Event;
import corecs.designpattern.observerpattern.subscriber.Subscriber;

public class PublisherImpl implements Publisher {
	
	private String publisherName;
	
	private List<Subscriber> subscribers;
	
	public PublisherImpl(String publisherName) {
		this.publisherName = publisherName;
		this.subscribers = new ArrayList<Subscriber>();
	}

	@Override
	public void publish(Event event) {
		System.out.println(publisherName + " -> Publishing MessageEvent To All Of Subscribers :: " + event.getMessage());
		this.subscribers.parallelStream()
				   .forEach(curSubscriber -> curSubscriber.push(event));
	}

	@Override
	public void subscribe(Subscriber subscriber) {
		this.subscribers.add(subscriber);
	}

	@Override
	public void unSubscribe(Subscriber subscriber) {
		this.subscribers.remove(subscriber);
	}

}
