package org.cbtf.f2f.findamentor;

import org.cbtf.f2f.Family2FamilyApp;
import org.cbtf.f2f.common.F2FMediaTypes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This integration class is for testing the {@link FirstPotentialMentorController}. It relies on data that is loaded
 * from the data-dev.sql file.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Family2FamilyApp.class)
@WebAppConfiguration
public class FirstPotentialMentorControllerIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //The configuration is loaded from the data-dev.sql file for the test. Contacts 16-19
    }

    @Test
    public void userFound_HasMatch_MatchIsReturned() throws Exception {
        String user1MatchUrl = "/api/users/anakin@nomail.com/first-potential-mentor";
        mockMvc.perform(MockMvcRequestBuilders.get(user1MatchUrl))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(F2FMediaTypes.JSON_CONTENT_TYPE))
                .andExpect(jsonPath("$.firstName", is("Padme")))
                .andExpect(jsonPath("$.lastName", is("Amidala")));
    }

    @Test
    public void userNotFound_NotFoundStatusReturned() throws Exception {
        String user1MatchUrl = "/api/users/noman@nomail.com/first-potential-mentor";
        mockMvc.perform(MockMvcRequestBuilders.get(user1MatchUrl))
                .andExpect(status().isNotFound());
    }

    @Test
    public void matchNotFound_NotFoundStatusReturned() throws Exception {
        String user1MatchUrl = "/api/users/darth@nomail.com/first-potential-mentor";
        mockMvc.perform(MockMvcRequestBuilders.get(user1MatchUrl))
                .andExpect(status().isNotFound());
    }
}