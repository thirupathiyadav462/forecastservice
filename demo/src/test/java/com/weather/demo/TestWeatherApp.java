package com.weather.demo;

	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

	import org.junit.Before;
	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.setup.MockMvcBuilders;
	import org.springframework.web.context.WebApplicationContext;

	public class TestWeatherApp {

		@Autowired
		private WebApplicationContext webApplicationContext;

		private MockMvc mockMvc;

		@Before
		public void setup() {
			mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}

		@Test
		public void testWeather() throws Exception {
			mockMvc.perform(get("/weather")).andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath("$.latt").value("122321")).andExpect(jsonPath("$.time").value("234234"))
					.andExpect(jsonPath("$.longi").value("1134234")).andExpect(jsonPath("$.salary").value(3000));

		}

	}
	
}
