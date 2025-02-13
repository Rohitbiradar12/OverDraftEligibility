package com.od.tcs.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.od.tcs.api.model.TCSReply;
import com.od.tcs.api.model.TCSRequest;
import com.od.tcs.api.service.ODEligibilityService;

@Endpoint
public class ODEligibilityEndpoint {

	private static final String NAMESPACE_URI = "http://www.tigo.com/TCS";
	
	@Autowired
	private ODEligibilityService oDEligibilityService;
	
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="TCSRequest")
	@ResponsePayload
	public TCSReply processEligibility(@RequestPayload TCSRequest request) {
		return oDEligibilityService.checkOdEligibility(request);
	}
}
