package amors.service.impl;

import amors.entity.Album;
import amors.repository.AlbumRepository;
import amors.service.api.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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
