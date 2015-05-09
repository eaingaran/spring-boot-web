package uk.co.jemos.experiments.multimodule.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.co.jemos.experiments.multimodule.test.integration.Example;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tedonema on 09/05/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ExampleUnitTest {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleUnitTest.class);

    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new Example()).build();
    }

    @Test
    public void testExample() throws Exception {
        LOG.info("Starting");
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
        LOG.info("Ending");
    }
}
