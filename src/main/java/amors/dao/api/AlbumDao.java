package amors.dao.api;

import amors.entity.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> getAlbums();
    
    List<Album> getAlbums(int start, int max);
    
    Album getAlbum(Long id);
    
    byte[] getAlbumCover(Long id);
}
