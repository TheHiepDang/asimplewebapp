package com.starhub.sites.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starhub.sites.api.dto.HeaderItemDTO;
import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.HeaderItem;
import com.starhub.sites.domain.MainBanner;
import com.starhub.sites.repository.MainBannerRepository;
import com.starhub.sites.repository.MainHeaderRepository;
import com.starhub.sites.rest.MainBannerResourceImpl;
import com.starhub.sites.rest.MainHeaderResourceImpl;
import com.starhub.sites.service.MainBannerService;
import com.starhub.sites.service.MainHeaderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainHeaderResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private MainHeaderRepository mainHeaderRepositoryMock;

    @Mock
    private MainHeaderService mainHeaderServiceMock;

    @InjectMocks
    private MainHeaderResourceImpl mainHeaderResourceMock;

    private MockMvc mockedMockMvc;

    private List<HeaderItem> headerItems;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockedMockMvc = MockMvcBuilders.standaloneSetup(mainHeaderResourceMock).build();
        headerItems = new ArrayList<>();
        headerItems.add(new HeaderItem("item1"));
        headerItems.add(new HeaderItem("item2"));
        headerItems.add(new HeaderItem("item3"));
        headerItems.add(new HeaderItem("item4"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testSetHeaderItemsShouldReturn200() throws Exception {
        this.mockMvc.perform(post("/api/starhub/mainHeader/setHeader")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(headerItems)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testSetHeaderItemsShouldReturn403() throws Exception {
        this.mockMvc.perform(post("/api/starhub/mainHeader/setHeader")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(headerItems)))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testGetMainHeaderItems() throws Exception {
        when(mainHeaderRepositoryMock.findAll())
                .thenReturn(new ArrayList());
        when(mainHeaderServiceMock.getMainHeaderItems()).thenReturn(new ArrayList<>());
        this.mockedMockMvc.perform(get("/api/starhub/mainHeader"))
                .andExpect(status().isOk());
    }
}