package amors.controller;

import amors.dto.SongInfo;
import amors.entity.Artist;
import amors.entity.Song;
import amors.service.api.AlbumService;
import amors.service.api.ArtistService;
import amors.service.api.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    private SongService songService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ArtistService artistService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView("homeTab");
        modelAndView.addObject("artists", artistService.getArtists(0, 4));
        modelAndView.addObject("albums", albumService.getAlbums(0, 4));
        modelAndView.addObject("songs", songService.getSongs(0, 5));
        return modelAndView;
    }
    
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public ModelAndView getGamesPage() {
        return new ModelAndView("games");
    }
    
    @RequestMapping(value = "/snake", method = RequestMethod.GET)
    public ModelAndView snakeGame() {
        return new ModelAndView("snake");
    }
    
    @RequestMapping(value = "/upload_file", method = RequestMethod.POST)
    public String fileUpload(SongInfo songInfo, @RequestParam MultipartFile file) {
        Song song = new Song();
        try {
            byte[] bytes = file.getBytes();
            Artist artist = new Artist();
            artist.setName(songInfo.getArtistName().equals("") ? null : songInfo.getArtistName());
            song.setArtist(artist);
            song.setSongTitle(songInfo.getSongTitle().equals("") ? null : songInfo.getSongTitle());
            // song.setFile(bytes);
            // dataService.addSong(song);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
