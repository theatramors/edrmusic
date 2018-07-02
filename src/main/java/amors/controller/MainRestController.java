package amors.controller;

import amors.dto.SongInfo;
import amors.service.api.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {
    private DataService dataService;
    
    @Autowired
    public MainRestController(DataService dataService) {
        this.dataService = dataService;
    }
    
    @RequestMapping(value = "/audio/{id}", method = RequestMethod.GET)
    public byte[] getSongFile(@PathVariable int id) {
        return dataService.getSongFile(id);
    }
    
    @RequestMapping(value = "/artist/{id}/logo", method = RequestMethod.GET)
    public byte[] getArtistLogo(@PathVariable Long id) {
        return dataService.getArtistLogo(id);
    }
    
    @RequestMapping(value = "/album/{id}/cover", method = RequestMethod.GET)
    public byte[] getAlbumCover(@PathVariable Long id) {
        return dataService.getAlbumCover(id);
    }
    
    @RequestMapping(value = "/getdata", method = RequestMethod.POST)
    public String getData() {
        StringBuilder response = new StringBuilder();
        List<SongInfo> stringList = dataService.getAllSongsInfo();
        for (int i = 0; i < stringList.size(); i++) {
            response.append(stringList.get(i).getArtistName()).append(" - ").append(stringList.get(i).getSongTitle()).append("\n");
        }
        
        // for (SongInfo song : dataService.getAllSongsInfo()) {
        //     response.append(song.getArtistName()).append(" - ").append(song.getSongTitle()).append("\n");
        // }
        return response.toString();
    }
}
