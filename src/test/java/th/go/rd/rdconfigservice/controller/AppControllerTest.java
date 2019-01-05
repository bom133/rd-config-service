package th.go.rd.rdconfigservice.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	// TESTCASE SUCCESS ADD HEADER
	@Test
	public void testAPPInfoCallSuccess() throws Exception {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", "application/json");
		headers.add("Accept-Language", "us");
		ResponseEntity<String> entity = new TestRestTemplate().exchange("http://localhost:" + port + "/config/appinfo",
				HttpMethod.GET, new HttpEntity<Object>(headers), String.class);
		String res = entity.getBody();
		 System.out.println("[000]>" + res);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(null != res);
	}

	// TESTCASE SUCCESS NON HEADER
	@Test
	public void testAPPInfoCallSuccessNonHeader() throws Exception {
		
		ResponseEntity<String> entity = restTemplate.getForEntity("/config/appinfo", String.class, new HashMap<String,String>());
		String res = entity.getBody();
		System.out.println("[001]>" + res);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(null != res);
	}
}
