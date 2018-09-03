package amors.service.api;

import amors.entity.*;

import java.util.*;

public interface AlbumService {
    List<Album> getAlbums();

    Album findById(Long id);

    byte[] getAlbumCover(Long id);
}
