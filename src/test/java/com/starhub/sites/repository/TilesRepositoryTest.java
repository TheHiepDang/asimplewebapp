package com.starhub.sites.repository;

import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.Tile;
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
public class TilesRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TilesRepository tilesRepositoryMock;

    @Test
    public void testGetByPageType() throws Exception {
        entityManager.persist(new Tile(PageType.MOBILE, "title", "desc", "imgurl", "ctatext", "ctaurl", "sbt1", "sbt2", "sbt3"));
        entityManager.persist(new Tile(PageType.MOBILE, "title2", "desc", "imgurl", "ctatext", "ctaurl", "sbt1", "sbt2", "sbt3"));
        entityManager.persist(new Tile(PageType.MISC, "title3", "desc", "imgurl", "ctatext", "ctaurl", "sbt1", "sbt2", "sbt3"));
        List<Tile> tiles = tilesRepositoryMock.getByPageType(PageType.MOBILE);
        assertEquals(2, tiles.size());
    }
}