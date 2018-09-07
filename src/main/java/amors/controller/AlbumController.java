package amors.controller;

import amors.entity.Album;
import amors.service.api.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(value = "")
    public List<Album> getAlbums() {
        return albumService.getAlbums();
    }

    @GetMapping(value = "/{id}")
    public Album getAlbum(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @GetMapping(value = "/{id}/cover")
    public byte[] getAlbumCover(@PathVariable Long id) {
        return albumService.getAlbumCover(id);
    }
}
