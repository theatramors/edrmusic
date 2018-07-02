package amors.repository;

import amors.entity.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    // List<Artist> findTop5();
}
