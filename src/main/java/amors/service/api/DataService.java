package amors.service.api;

import amors.dto.SongInfo;
import amors.entity.Album;
import amors.entity.Artist;
import amors.entity.Song;

import java.util.List;

public interface DataService {
    void addSong(Song song);
    
    List<Song> getSongs();
    
    List<Song> getSongs(int start, int max);
    
    List<SongInfo> getAllSongsInfo();
    
    List<Song> getSongsByArtist(String artist);
    
    byte[] getSongFile(int id);
    
    List<Artist> getArtists();
    
    List<Artist> getArtists(int start, int max);
    
    Artist getArtist(Long id);
    
    byte[] getArtistLogo(Long id);
    
    List<Album> getAlbums();
    
    List<Album> getAlbums(int start, int max);
    
    Album getAlbum(Long id);
    
    byte[] getAlbumCover(Long id);
}
