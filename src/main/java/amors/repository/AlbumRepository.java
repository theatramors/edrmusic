package amors.repository;

import amors.entity.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    // List<Album> findTop5();
}
