package com.example;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
/**
 * Test whole application
 * @author ivan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IvzelTestProjectForNullpointerApplication.class)
@WebAppConfiguration
public class ApplicationTests {

	private MockMvc mvc;
	
    @Autowired
    private WebApplicationContext webApplicationContext;
	
	@Before
	public void prepare(){
		this.mvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void isOKNoDate() throws Exception {
		mvc.perform(get("/currency/api/rate/USD"))
		.andExpect(status().is(200));
	}

	@Test
	public void isOkWithDate() throws Exception {
		mvc.perform(get("/currency/api/rate/USD/2015-10-08"))
		.andExpect(status().is(200));
	}
	
	@Test
	public void isContentIsJson() throws Exception {
		mvc.perform(get("/currency/api/rate/USD/2015-09-24"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void isDataCorrect() throws Exception {
		mvc.perform(get("/currency/api/rate/USD/2015-09-24"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.code", is("USD")))
		.andExpect(jsonPath("$.rate", is("66,0410")))
		.andExpect(jsonPath("$.date", is("2015-09-24")));
	}
	@Test
	public void isTomorrowIfNoDate() throws Exception {
		String tomorrowStr = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE);
		mvc.perform(get("/currency/api/rate/USD"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.date", is(tomorrowStr)));
	}
}
