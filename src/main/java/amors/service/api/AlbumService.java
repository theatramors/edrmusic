package amors.service.api;

import amors.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAlbums(int start, int max);

    Album findById(Long id);

    byte[] getAlbumCover(Long id);
}
