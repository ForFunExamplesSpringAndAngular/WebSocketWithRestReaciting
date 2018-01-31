package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ComunicationFeed {
	
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	@RequestMapping(value = "chanel/send", method = RequestMethod.GET)
	public void sendMessageForProperChanel(@RequestParam("chanelName") String chanelName, @RequestParam("message") String message) {
		System.out.println("Wysy³am do odpowiedniego socketu.");
		webSocket.convertAndSend(chanelName, new Greeting(message));
	}
	
	
}
