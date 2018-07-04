package amors.service.api;

import amors.entity.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> getArtists(int start, int max);
    
    Artist findById(Long id);
}
