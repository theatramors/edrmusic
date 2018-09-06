package amors.service.api;

import amors.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAlbums();

    Album findById(Long id);

    byte[] getAlbumCover(Long id);
}
