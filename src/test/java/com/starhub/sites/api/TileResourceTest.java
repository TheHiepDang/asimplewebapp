package com.starhub.sites.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.Tile;
import com.starhub.sites.repository.TilesRepository;
import com.starhub.sites.rest.TileResourceImpl;
import com.starhub.sites.service.TilesService;
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

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TileResourceTest {

    public static final String API_STARHUB_TILE_PAGE_TYPE = "/api/starhub/tile/{pageType}";
    public static final String API_STARHUB_TILE_SET_TILE = "/api/starhub/tile/setTile";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private TilesRepository tilesRepositoryMock;

    @Mock
    private TilesService tilesServiceMock;

    @InjectMocks
    private TileResourceImpl tileResourceMock;

    private MockMvc mockedMockMvc;

    private List<Tile> tiles;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockedMockMvc = MockMvcBuilders.standaloneSetup(tileResourceMock).build();
        tiles = new ArrayList<>();
        tiles.add(new Tile(PageType.MOBILE, "title", "desc", "imgurl", "ctatext", "ctaurl", "sbt1", "sbt2", "sbt3"));
        tiles.add(new Tile(PageType.MOBILE, "title2", "desc", "imgurl", "ctatext", "ctaurl", "sbt1", "sbt2", "sbt3"));
        tiles.add(new Tile(PageType.MISC, "title3", "desc", "imgurl", "ctatext", "ctaurl", "sbt1", "sbt2", "sbt3"));
    }

    @Test
    public void testGetTileByPageType() throws Exception {
        when(tilesRepositoryMock.findAll())
                .thenReturn(new ArrayList());
        when(tilesServiceMock.getTileByPageType(anyString())).thenReturn(new ArrayList<>());
        this.mockedMockMvc.perform(get(API_STARHUB_TILE_PAGE_TYPE, PageType.MOBILE.toString()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testSetTileShouldReturn200() throws Exception {
        this.mockMvc.perform(post(API_STARHUB_TILE_SET_TILE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(tiles)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testSetTileShouldReturn403() throws Exception {
        this.mockMvc.perform(post(API_STARHUB_TILE_SET_TILE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(tiles)))
                .andExpect(status().isForbidden());
    }
}