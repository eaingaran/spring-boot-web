package uk.co.jemos.experiments.spring.boot.mvc.test.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import uk.co.jemos.experiments.spring.boot.mvc.Example;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by tedonema on 09/05/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Example.class)
@WebAppConfiguration
@IntegrationTest("{server.port=0}")
public class ExampleIT {

    private static final Logger LOG = LogManager.getLogger(ExampleIT.class);

    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        template = new TestRestTemplate();
    }

    @Test
    public void testExample() throws Exception {
        LOG.info("Starting");
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody(), equalTo("Hello World"));
        LOG.info("Ending");
    }
}
