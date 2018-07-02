package amors.dao.api;

import amors.dto.SongInfo;
import amors.entity.Song;

import java.util.List;

public interface SongDao {
    void addSong(Song song);
    
    List<Song> getSongs();
    
    List<Song> getSongs(int start, int max);
    
    List<SongInfo> getAllSongsInfo();
    
    List<Song> getSongsByArtist(String artist);
    
    byte[] getSongFile(int id);
}
