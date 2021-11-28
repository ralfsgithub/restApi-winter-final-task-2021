package com.apicore.requestBodies;

import com.apicore.util.JsonReader;

public class ExampleRequestBody {

    public static final String dir = System.getProperty("user.dir");

    public String createExample(String paymentType, String stateCode, String zipCode, String city) throws Exception {
        String requestBody = null;
        switch (paymentType) {
            case "credit card":
                requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/creditCardRequestBody.json");
                break;
            case "insurance":
                requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/insuranceRequestBody.json");
                break;
            case "financing":
                requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/financingRequestBody.json");
                break;
            case "paypal":
                requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/paypal.json");
                break;
            default:
                System.out.println("Select tax type");
        }
        requestBody = requestBody.replace("$STATE", stateCode);
        requestBody = requestBody.replace("$ZIP", zipCode);
        return requestBody.replace("$CITY", city);
    }
}
