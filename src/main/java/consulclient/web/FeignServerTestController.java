package consulclient.web;

import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testfeign")
public class FeignServerTestController {
	
	private static Logger logger = LoggerFactory.getLogger(FeignServerTestController.class);
	
	@RequestMapping(value="/serviceGet",method=RequestMethod.GET)
	public String helloService(@RequestParam String name) {
		sleep("get");
		return "server2:HelloServiceImpl name :"+name;
	}
	
	@RequestMapping(value="/serviceHead", method=RequestMethod.HEAD)
	public String helloService(@RequestHeader String name,
			@RequestHeader String password) {
		sleep("header");
		return "server2:helloServiceHead name :"+name +" password:"+password;
	}
	
	@RequestMapping(value="/servicePost", method=RequestMethod.POST)
	public String helloService(@RequestBody Map<String, String> map) {
		sleep("post");
		return map.toString();
	}

	private void sleep(String methodName) {
		int sleepMinTime = new Random().nextInt(3000);
		logger.info("server2:helloService "+methodName+" sleepMinTime: "+sleepMinTime);
		try {
			Thread.sleep(sleepMinTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
