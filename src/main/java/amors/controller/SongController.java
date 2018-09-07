package amors.controller;

import amors.entity.Song;
import amors.service.api.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(value = "")
    public List<Song> getSongs() {
        return songService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songService.findById(id);
    }

    @GetMapping(value = "/{id}/file")
    public byte[] getArtistLogo(@PathVariable Long id) {
        return songService.findById(id).getFileContent().getFileContent();
    }
}
