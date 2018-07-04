package amors.controller;

import amors.service.api.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService service;
    
    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public ModelAndView getAlbums() {
        ModelAndView modelAndView = new ModelAndView("albumsTab");
        modelAndView.addObject("albums", service.getAlbums(0, 20));
        return modelAndView;
    }
    
    // TODO Реализовать вкладку с альбомом
    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public ModelAndView getAlbum(@PathVariable Long id) {
        return new ModelAndView();
    }
    
    // TODO Переделать получение логотипа артиста
    @RequestMapping(value = "/album/{id}/cover", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getAlbumCover(@PathVariable Long id) {
        return service.getAlbumCover(id);
    }
}
