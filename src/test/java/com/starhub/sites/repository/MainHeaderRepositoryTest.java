package com.starhub.sites.repository;

import com.starhub.sites.domain.HeaderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hiep Dang on 2/5/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class MainHeaderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MainHeaderRepository mainHeaderRepositoryMock;

    @Test
    public void testFindAll() throws Exception {
        entityManager.persist(new HeaderItem("item1"));
        entityManager.persist(new HeaderItem("item2"));
        entityManager.persist(new HeaderItem("item3"));
        List headerItems = mainHeaderRepositoryMock.findAll();
        assertEquals(3, headerItems.size());
    }
}