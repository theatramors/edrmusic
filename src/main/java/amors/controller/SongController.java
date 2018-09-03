package amors.controller;

import amors.entity.*;
import amors.service.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Song> getSongs() {
        return songService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Song getSongById(@PathVariable Long id) {
        return songService.findById(id);
    }

    @RequestMapping(value = "/{id}/file", method = RequestMethod.GET)
    public byte[] getArtistLogo(@PathVariable Long id) {
        return songService.findById(id).getFileContent().getFileContent();
    }
}
