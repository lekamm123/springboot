package com.in28minutes.springboot.Controller;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.Application;
import com.in28minutes.springboot.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;
	@Test
	public void testRetrieveSurveyQuestion() {
		//fail("Not yet implemented");
		//String url= "http://localhost:"+port+"/surveys/Survey1/questions/Question1";
		
		String url= "http://localhost:"+port+"/surveys/Survey1/questions";
		
		Question question = new Question("dontcare",
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		//String output = restTemplate.getForObject(url, String.class);
		HttpHeaders header= new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
	//	HttpEntity entity= new HttpEntity<Question>(null,header);
	
	//	ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		
		HttpEntity entity= new HttpEntity<Question>(question,header);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.POST,entity,String.class);
	String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		//System.out.println("Response:"+response.getBody());
	System.out.println("Respone:Post:"+actual);
		//assertTrue(response.getBody().contains("\"id\":\"Question1\""));
		//String expected ="{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";
	//	try {
		//	JSONAssert.assertEquals(expected, response.getBody(), false);
		//} catch (JSONException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}

}
