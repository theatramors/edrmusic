package amors.service;

import amors.entity.Album;
import amors.repository.AlbumRepository;
import amors.service.api.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository repository;
    
    @Override
    public List<Album> getAlbums(int start, int max) {
        Pageable size = PageRequest.of(start, max);
        Page<Album> all = repository.findAll(size);
        return all.getContent();
    }
    
    @Override
    public Album findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public byte[] getAlbumCover(Long id) {
        return Objects.requireNonNull(repository.findById(id).orElse(null)).getFileContent().getFileContent();
    }
}
