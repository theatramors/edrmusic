package amors.dao.api;

import amors.entity.Artist;

import java.util.List;

public interface ArtistDao {
    List<Artist> getArtists();
    
    List<Artist> getArtists(int start, int end);
    
    Artist getArtistById(Long id);
    
    byte[] getArtistLogo(Long id);
}
