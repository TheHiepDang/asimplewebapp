package com.starhub.sites.service;

import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MainBannerServiceTest {

    @Autowired
    private MainBannerService mainBannerService;

    @Test
    public void testSetGetBanner() throws Exception {
        mainBannerService.setBanner(new MainBannerDTO("I'm special", "desc", "url", "cta", "cta"));
        MainBannerDTO mainBannerDTO = mainBannerService.getBannerByPageType(PageType.MOBILE);
        assertEquals("I'm special", mainBannerDTO.getTitle());
    }

}