package amors.controller;

import amors.entity.*;
import amors.service.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/albums")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Album> getAlbums() {
        return albumService.getAlbums();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album getAlbum(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @RequestMapping(value = "/{id}/cover", method = RequestMethod.GET)
    public byte[] getAlbumCover(@PathVariable Long id) {
        return albumService.getAlbumCover(id);
    }
}
