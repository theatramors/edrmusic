package amors.service;

import amors.entity.Artist;
import amors.repository.ArtistRepository;
import amors.service.api.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistRepository repository;
    
    @Override
    public List<Artist> getArtists(int start, int max) {
        Pageable size = PageRequest.of(start, max);
        Page<Artist> all = repository.findAll(size);
        return all.getContent();
    }
    
    @Override
    public Artist findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public byte[] getArtistLogo(Long id) {
        return Objects.requireNonNull(repository.findById(id).orElse(null)).getFileContent().getFileContent();
    }
}
