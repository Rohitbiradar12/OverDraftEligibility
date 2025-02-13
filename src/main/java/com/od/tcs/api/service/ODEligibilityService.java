package com.od.tcs.api.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import com.od.tcs.api.model.TCSReply;
import com.od.tcs.api.model.TCSRequest;

@Service 
public class ODEligibilityService {

    public TCSReply checkOdEligibility(TCSRequest request) {
        TCSReply response = new TCSReply();

        // Check if request or Function is null
        if (request == null || request.getFunction() == null) {
            response.setResult(2); // Code for invalid request
            response.setMessage("Invalid request: Function block is missing.");
            response.setParam1(null);
            return response;
        }

        // Retrieve function parameters safely
        String accountType = request.getFunction().getParam2();
        String amountStr = request.getFunction().getParam3();

        // Check if essential parameters are missing
        if (accountType == null || amountStr == null) {
            response.setResult(3); // Code for missing parameters
            response.setMessage("Invalid request: Required parameters are missing.");
            response.setParam1(null);
            return response;
        }

        int amount;
        try {
            amount = Integer.parseInt(amountStr);
        } catch (NumberFormatException e) {
            response.setResult(4); // Code for invalid amount format
            response.setMessage("Invalid request: Amount must be a valid integer.");
            response.setParam1(null);
            return response;
        }

        // Eligibility check logic
        if ("SAVINGS".equalsIgnoreCase(accountType) && amount <= 10_000_000) {
            response.setResult(0);
            response.setMessage("Eligible for Over Draft");
            response.setParam1(generateAccountReference());
        } else {
            response.setResult(1);
            response.setMessage("Not eligible for Over Draft");
            response.setParam1(null);
        }

        return response;
    }

    // Generate a 12-character unique account reference
    private String generateAccountReference() {
        return "ACC" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }
}
