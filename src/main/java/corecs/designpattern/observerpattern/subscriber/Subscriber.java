package corecs.designpattern.observerpattern.subscriber;

import corecs.designpattern.observerpattern.event.Event;

public interface Subscriber {

	public void push(Event event);
}
