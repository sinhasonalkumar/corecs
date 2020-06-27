package corecs.designpattern.observerpattern.event;


public class EventImpl implements Event{

	private String message;

	public EventImpl(String mesaage) {
		this.message = mesaage;
	}
	
	public String getMessage() {
		return message;
	}	
	
}
