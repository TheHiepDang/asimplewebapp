package com.starhub.sites.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.MainBanner;
import com.starhub.sites.repository.MainBannerRepository;
import com.starhub.sites.rest.MainBannerResourceImpl;
import com.starhub.sites.service.MainBannerService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Hiep Dang on 2/5/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainBannerResourceTest {

    public static final String API_STARHUB_MAIN_BANNER_SET_BANNER = "/api/starhub/mainBanner/setBanner";
    public static final String API_STARHUB_MAIN_BANNER_PAGE_TYPE = "/api/starhub/mainBanner/{pageType}";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private MainBannerRepository mainBannerRepositoryMock;

    @Mock
    private MainBannerService mainBannerServiceMock;

    @InjectMocks
    private MainBannerResourceImpl mainBannerResourceMock;

    private MockMvc mockedMockMvc;

    private MainBannerDTO mainBannerDTO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockedMockMvc = MockMvcBuilders.standaloneSetup(mainBannerResourceMock).build();
        mainBannerDTO = new MainBannerDTO("title", "desc", "url", "cta", "cta");
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testSetBannerShouldReturn200() throws Exception {
        this.mockMvc.perform(post(API_STARHUB_MAIN_BANNER_SET_BANNER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(mainBannerDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testSetBannerShouldReturn403() throws Exception {
        this.mockMvc.perform(post(API_STARHUB_MAIN_BANNER_SET_BANNER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(mainBannerDTO)))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testGetBanner() throws Exception {
        when(mainBannerRepositoryMock.getByPageID(PageType.MOBILE))
                .thenReturn(new MainBanner());
        when(mainBannerServiceMock.getBannerByPageType(PageType.MOBILE)).thenReturn(new MainBannerDTO());
        this.mockedMockMvc.perform(get(API_STARHUB_MAIN_BANNER_PAGE_TYPE, PageType.MOBILE.toString()))
                .andExpect(status().isOk());
    }
}