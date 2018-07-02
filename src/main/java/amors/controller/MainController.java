package amors.controller;

import amors.dto.SongInfo;
import amors.entity.Artist;
import amors.entity.Song;
import amors.repository.AlbumRepository;
import amors.repository.ArtistRepository;
import amors.repository.SongRepository;
import amors.service.api.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
	@Autowired
	private DataService dataService;
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private AlbumRepository albumRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView("homeTab");
		modelAndView.addObject("songs", songRepository.findById(31L));
		modelAndView.addObject("albums", albumRepository.findAll());
		modelAndView.addObject("artists", artistRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/artists", method = RequestMethod.GET)
	public ModelAndView getArtists() {
		ModelAndView modelAndView = new ModelAndView("artistsTab");
		modelAndView.addObject("artists", dataService.getArtists());
		return modelAndView;
	}
	
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
	public ModelAndView getArtist(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("songs", dataService.getArtist(id).getSongs());
		return modelAndView;
	}
	
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public ModelAndView getAlbums() {
		ModelAndView modelAndView = new ModelAndView("albumsTab");
		modelAndView.addObject("albums", dataService.getAlbums());
		return modelAndView;
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public ModelAndView getAlbum(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("songs", dataService.getAlbum(id).getSongs());
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
			song.setFile(bytes);
			dataService.addSong(song);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
