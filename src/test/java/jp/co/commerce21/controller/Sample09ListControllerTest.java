package jp.co.commerce21.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class Sample09ListControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@WithMockUser(username="admin", roles="ADMIN")
	void sample09ListControllerAdminUser () throws Exception {
		
		mockMvc.perform(get("/sample09/list"))
			.andExpect(status().isOk())
			.andExpect(model().hasNoErrors())
			.andExpect(content().string(containsString("検索条件")))
			.andExpect(view().name("sample09/list"));
	}
	
	@Test
	@WithMockUser(username="user", roles="GENERAL")
	void sample09ListControllerGeneralUser () throws Exception {
		
		mockMvc.perform(get("/sample09/list"))
			.andExpect(status().isOk())
			.andExpect(model().hasNoErrors())
			.andExpect(content().string(containsString("検索条件")))
			.andExpect(view().name("sample09/list"));
	}
}
