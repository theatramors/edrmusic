package amors.service.impl;

import amors.entity.*;
import amors.repository.*;
import amors.service.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

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
