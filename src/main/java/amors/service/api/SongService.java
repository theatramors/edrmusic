package amors.service.api;

import amors.entity.*;

import java.util.*;

public interface SongService {
    List<Song> findAll();

    List<Song> findAll(int start, int end);

    Song findById(Long id);
}
