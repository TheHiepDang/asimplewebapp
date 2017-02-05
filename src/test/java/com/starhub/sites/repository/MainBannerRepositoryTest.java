package com.starhub.sites.repository;

import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.MainBanner;
import com.starhub.sites.repository.MainBannerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Hiep Dang on 2/5/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class MainBannerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MainBannerRepository mainBannerRepositoryMock;

    @Test
    public void testGetByPageID() throws Exception {
        entityManager.persist(new MainBanner(PageType.MOBILE, "http", "title", "Tested", "ctatext", "ctaurl"));
        MainBanner mainBanner = mainBannerRepositoryMock.getByPageID(PageType.MOBILE);
        assertEquals("Tested", mainBanner.getDescription());
    }
}