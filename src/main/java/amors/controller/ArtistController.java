package amors.controller;

import amors.entity.*;
import amors.service.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
