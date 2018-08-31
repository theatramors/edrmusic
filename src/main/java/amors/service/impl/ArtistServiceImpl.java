package amors.service.impl;

import amors.entity.Artist;
import amors.repository.ArtistRepository;
import amors.service.api.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    @Transactional
    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    @Override
    @Transactional
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public byte[] getArtistLogo(Long id) {
        return Objects.requireNonNull(artistRepository.findById(id).orElse(null)).getFileContent().getFileContent();
    }
}
