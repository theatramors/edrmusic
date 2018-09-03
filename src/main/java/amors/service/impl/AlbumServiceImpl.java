package amors.service.impl;

import amors.entity.*;
import amors.repository.*;
import amors.service.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository repository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Album> getAlbums() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Album findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public byte[] getAlbumCover(Long id) {
        return Objects.requireNonNull(repository.findById(id).orElse(null)).getFileContent().getFileContent();
    }
}
