package amors.service.api;

import amors.entity.*;

import java.util.*;

public interface ArtistService {
    List<Artist> getArtists();

    Artist findById(Long id);

    byte[] getArtistLogo(Long id);
}
