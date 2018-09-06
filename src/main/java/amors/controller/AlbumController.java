package amors.controller;

import amors.entity.Album;
import amors.service.api.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
