package amors.controller;

import amors.service.api.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtistController {
    @Autowired
    private ArtistService service;
    
    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public ModelAndView getArtists() {
        ModelAndView modelAndView = new ModelAndView("artistsTab");
        modelAndView.addObject("artists", service.getArtists(0, 20));
        return modelAndView;
    }
    
    // TODO Реализовать вкладку с артистом
    @RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
    public ModelAndView getArtist(@PathVariable Long id) {
        return new ModelAndView();
    }
    
    // TODO Переделать получение логотипа артиста
    @RequestMapping(value = "/artist/{id}/logo", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getArtistLogo(@PathVariable Long id) {
        return service.getArtistLogo(id);
    }
}
