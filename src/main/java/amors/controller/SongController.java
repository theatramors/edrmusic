package amors.controller;

import amors.service.api.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SongController {
    @Autowired
    private SongService service;
    
    // TODO Переделать получение файда песни
    @RequestMapping(value = "/song/{id}/file", method = RequestMethod.GET)
    public byte[] getArtistLogo(@PathVariable Long id) {
        return service.findById(id).getFileContent().getFileContent();
    }
}
