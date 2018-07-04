package amors.service;

import amors.entity.Song;
import amors.repository.SongRepository;
import amors.service.api.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository repository;
    
    @Override
    public List<Song> getSongs(int start, int max) {
        Pageable size = PageRequest.of(start, max);
        Page<Song> all = repository.findAll(size);
        return all.getContent();
    }
    
    @Override
    public Song findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
