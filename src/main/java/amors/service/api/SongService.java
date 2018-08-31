package amors.service.api;

import amors.entity.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    List<Song> findAll(int start, int end);

    Song findById(Long id);
}
