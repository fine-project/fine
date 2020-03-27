package blank.app.sample;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/sample")
public class SampleController {

	private static final Logger LOGGER = LogManager.getLogger(SampleController.class);

   @RequestMapping("")
    public SampleResponse login(
    		@RequestBody SampleRequest sampleRequest, HttpServletRequest request) {

    	LOGGER.info("execute sample!");
        LOGGER.info("param1:" + sampleRequest.getParam1());
        LOGGER.info("param2:" + sampleRequest.getParam2());

        SampleResponse sampleResponse = new SampleResponse();
        sampleResponse.setResult(7);
        
    	return sampleResponse;
    }
}