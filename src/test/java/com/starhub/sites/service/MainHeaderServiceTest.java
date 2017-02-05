package com.starhub.sites.service;

import com.starhub.sites.api.dto.HeaderItemDTO;
import com.starhub.sites.domain.HeaderItem;
import com.starhub.sites.service.MainHeaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MainHeaderServiceTest {

    @Autowired
    private MainHeaderService mainHeaderService;

    @Test
    public void testGetSetMainHeaderItems() throws Exception {
        List<HeaderItemDTO> headerItems = new ArrayList<>();
        headerItems.add(new HeaderItemDTO("item1"));
        headerItems.add(new HeaderItemDTO("item2"));
        headerItems.add(new HeaderItemDTO("item3"));
        headerItems.add(new HeaderItemDTO("item4"));
        mainHeaderService.setHeaderItemsBatch(headerItems);
        List<HeaderItemDTO> headerItemList = mainHeaderService.getMainHeaderItems();
        assertEquals(4, headerItemList.size());

    }
}