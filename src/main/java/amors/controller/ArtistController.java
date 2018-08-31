package amors.controller;

import amors.entity.Artist;
import amors.service.api.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artist getArtist(@PathVariable Long id) {
        return artistService.findById(id);
    }

    @RequestMapping(value = "/{id}/logo", method = RequestMethod.GET)
    public byte[] getArtistLogo(@PathVariable Long id) {
        return artistService.getArtistLogo(id);
    }
}
