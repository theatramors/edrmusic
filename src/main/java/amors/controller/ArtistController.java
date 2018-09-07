package amors.controller;

import amors.entity.Artist;
import amors.service.api.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/artists")
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(value = "")
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }

    @GetMapping(value = "/{id}")
    public Artist getArtist(@PathVariable Long id) {
        return artistService.findById(id);
    }

    @GetMapping(value = "/{id}/logo")
    public byte[] getArtistLogo(@PathVariable Long id) {
        return artistService.getArtistLogo(id);
    }
}
