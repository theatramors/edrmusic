package amors.service.api;

import amors.entity.Song;

import java.util.List;

public interface SongService {
    List<Song> getSongs(int start, int max);
    
    Song findById(Long id);
}
