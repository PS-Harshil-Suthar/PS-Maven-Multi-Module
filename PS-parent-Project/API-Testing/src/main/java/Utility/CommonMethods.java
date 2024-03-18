package Utility;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.jayway.jsonpath.JsonPath;
import org.skyscreamer.jsonassert.*;
import init.BaseClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonMethods extends BaseClass {

    // Request specification objects for API calls with and without API key
    private final RequestSpecification reqSpecWithApiKey;
    private final RequestSpecification reqSpecWithoutApiKey;
    private final RequestSpecification reqSpecWitApiKeyText;

 
    HashMap<String, String> param = new HashMap<String, String>() {};
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();

    public CommonMethods() {
        // Initialize request specification objects using base class methods
        reqSpecWithApiKey = getReqSpecWithApiKey();
        reqSpecWithoutApiKey = getReqSpecWithoutApiKey();
        reqSpecWitApiKeyText = getReqSpecWithApiKeyText();
    }

    /**
     * Method to make an API call
     *
     * @param method     HTTP method type (GET, POST, PUT, PATCH)
     * @param requestBody   Request body data for POST, PUT, PATCH methods
     * @param endpoint   API endpoint URL
     * @return Response object containing the API response
     */
    public Response callAPI(String method, List<String> requestBody, String endpoint) {
        Response res = null;
        // Set the request specification based on whether API key is required
        RequestSpecification reqSpec = reqSpecWithApiKey;
        System.out.println(endpoint);
        
        if (method.equalsIgnoreCase("GET")) {
            // Send GET request and extract the response
            res = given(reqSpec)
                    .when()
                    .get(endpoint)
                    .then()
                    .extract()
                    .response();
        } else if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("PATCH")) {
            // Send POST, PUT, or PATCH request with request body data and extract the response
            res = given(reqSpec)
                    .when()
                    .body(requestBody)
                    .request(method, endpoint)
                    .then()
                    .extract()
                    .response();
        }

        return res;
    }
    
    public Response callAPIWithJson(String method, String requestBody, String endpoint) {
        Response res = null;
        // Set the request specification based on whether API key is required
        RequestSpecification reqSpec = reqSpecWithApiKey;
      
        
        if (method.equalsIgnoreCase("GET")) {
            // Send GET request and extract the response
            res = given(reqSpec)
                    .when()
                    .get(endpoint)
                    .then()
                    .extract()
                    .response();
        } else if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("PATCH")) {
            // Send POST, PUT, or PATCH request with request body data and extract the response
            res = given(reqSpec)
                    .when()
                    .body(requestBody)
                    .request(method, endpoint)
                    .then()
                    .extract()
                    .response();
        }
        return res;
    }
    
    
    public Response callAPIWithText(String method, String requestBody, String endpoint) {
        Response res = null;
        // Set the request specification based on whether API key is required
        RequestSpecification reqSpec = reqSpecWitApiKeyText;
      
        
        if (method.equalsIgnoreCase("GET")) {
            // Send GET request and extract the response
            res = given(reqSpec)
                    .when()
                    .get(endpoint)
                    .then()
                    .extract()
                    .response();
        } else if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("PATCH")) {
            // Send POST, PUT, or PATCH request with request body data and extract the response
            res = given(reqSpec)
                    .when()
                    .body(requestBody)
                    .request(method, endpoint)
                    .then()
                    .extract()
                    .response();
        }
        return res;
    }
    
    
    
    
    
    public Response callAPIWithParam(String method, Map<String, String> testData, String endpoint,String Key,String Value) {
    	
    	 Response res = null;
         // Set the request specification based on whether API key is required
         RequestSpecification reqSpec = reqSpecWithApiKey;
         
        String endpointwithpathparam = endpoint + "?" + Key + "=" + Value;
      
        if (method.equalsIgnoreCase("GET")) {
            // Send GET request and extract the response
            res = given(reqSpec)
                    .when()
                    .get(endpointwithpathparam)
                    .then()
                    .extract()
                    .response();
        } else if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("PATCH")) {
            // Send POST, PUT, or PATCH request with request body data and extract the response
            res = given(reqSpec)
                    .when()
                    .body(testData)
                    .request(method, endpoint)
                    .then()
                    .extract()
                    .response();
        }
        return res;
    }
    
    
//    public Response callAPIWithTextParam(String method, Map<String, String> testData, String endpoint,String Key,String Value) {
//    	
//   	 Response res = null;
//        // Set the request specification based on whether API key is required
//        RequestSpecification reqSpec = reqSpecWithApiKey;
//        
//       String endpointwithpathparam = endpoint + "?" + Key + "=" + Value;
//     
//       
//     
//       if (method.equalsIgnoreCase("GET")) {
//           // Send GET request and extract the response
//           res = given(reqSpec)
//                   .when()
//                   .get(endpointwithpathparam)
//                   .then()
//                   .extract()
//                   .response();
//       } else if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("PATCH")) {
//           // Send POST, PUT, or PATCH request with request body data and extract the response
//           res = given(reqSpec)
//                   .when()
//                   .body(testData)
//                   .request(method, endpoint)
//                   .then()
//                   .extract()
//                   .response();
//       }
//       return res;
//   }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Response callAPIWithoutKey(String method, Map<String, String> testData, String endpoint) {
        Response res = null;
        // Set the request specification based on whether API key is required
        RequestSpecification reqSpec = reqSpecWithoutApiKey;

        if (method.equalsIgnoreCase("GET")) {
            // Send GET request and extract the response
            res = given(reqSpec)
                    .when()
                    .get(endpoint)
                    .then()
                    .extract()
                    .response();
        } else if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("PATCH")) {
            // Send POST, PUT, or PATCH request with request body data and extract the response
            res = given(reqSpec)
                    .when()
                    .body(testData)
                    .request(method, endpoint)
                    .then()
                    .extract()
                    .response();
        }

        return res;
    }

    /**
     * Method to verify the JSON schema of the API response
     *
     * @param res            Response object containing the API response
     * @param schemaFileName Name of the JSON schema file to validate against
     * @throws IOException if there is an error reading the schema file
     * @throws JSONException 
     */
    
    
    

    public void verifyJsonSchema(Response res, String schemaFileName) throws IOException, ParseException, JSONException {
    	
         
         // String jsonSchema = new String(Files.readAllBytes(schemaFileName);

         // Assert that the response body matches the JSON schema
//       res.then()
//                 .assertThat()
//                 .body(JsonSchemaValidator.matchesJsonSchema(schemaFileName));
        // Get the file path of the JSON schema based on the given file name
    	
    	
    	
    	 String data = new String(Files.readAllBytes(Paths.get("src/test/java/schemas/" + schemaFileName).toAbsolutePath()));
    
    	
    	 
    	 if(data.startsWith("[")) {
    		 StringBuilder data1 = new StringBuilder(data);
    		 data1.insert(0,"{\"root\":");
    		 data1.insert(data1.length(),"}");
    		 StringBuilder data2 = new StringBuilder(res.getBody().asString());
    		 data2.insert(0,"{\"root\":");
    		 data2.insert(data2.length(),"}");
    		
    		 
    	
 
    	//.assertEquals(data1.toString(), data2.toString(), JSONCompareMode.STRICT_ORDER);
    			
    		 
    		 String failureMessage = "Filed is Missing:";
    		 try {
    		     JSONAssert.assertEquals(failureMessage,data1.toString(),data2.toString(), JSONCompareMode.NON_EXTENSIBLE);
    		 } 
    		 catch (AssertionError ae) {
    		     System.out.println(ae);
    		 }
    		 
    		 
//    		 ObjectMapper mapper = new ObjectMapper();
//    		    JsonNode s1Json = mapper.readTree(data1.toString());
//    		    JsonNode s2Json = mapper.readTree(data2.toString());
//    		    System.out.println(s1Json.equals(s2Json));
//    		    
    		 
    		 
    		
    	 UnityJSONParser parser = new UnityJSONParser(data1.toString());
    	        for (String singlePath : parser.getPathList()) {
    	            
    	          //      Object object = JsonPath.parse(json.toJSONString()).read(singlePath);   
    	        }
    	 
    	 }
    	 
    	 
    
    	else {
    		 
    		
        UnityJSONParser parser = new UnityJSONParser(data);
        for (String singlePath : parser.getPathList()) {
            	
                Object object = JsonPath.parse(res.getBody()).read(singlePath);   
        }
    	 }
    }
    

}
