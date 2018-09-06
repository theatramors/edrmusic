package amors.controller;

import amors.entity.Song;
import amors.service.api.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
