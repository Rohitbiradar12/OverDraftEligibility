package com.tigo.tcs.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tigo.tcs.TCSReply;
import com.tigo.tcs.TCSRequest;
import com.tigo.tcs.api.service.UserService;

@Endpoint
public class UserEndpoint {

	@Autowired
	private UserService userService;
	
	@Autowired
	private WebServiceTemplate webServiceTemplate;
	
	private static final String NAMESPACE_URI = "http://www.tigo.com/TCS";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "TCSRequest")
	@ResponsePayload
	public TCSReply validate(@RequestPayload TCSRequest request) {
	    TCSReply response = new TCSReply();

	    if (userService.validateUser(request)) {
	        request.getFunction().setParam1(null);

	        try {
	            System.out.println("Sending SOAP Request: " + request);

	            Object rawResponse = webServiceTemplate.marshalSendAndReceive("http://localhost:2222/ws", request);

	            System.out.println("Received Response: " + rawResponse);

	            if (rawResponse instanceof TCSReply) {
	                return (TCSReply) rawResponse;
	            } else {
	                response.setResult(1);
	                response.setMessage("Invalid Response Type");
	                response.setParam1(null);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.setResult(1);
	            response.setMessage("Error in SOAP communication: " + e.getMessage());
	            response.setParam1(null);
	        }
	    } else {
	        response.setResult(1);
	        response.setMessage("Invalid Credentials");
	        response.setParam1(null);
	    }
	    return response;
	}

}
