package amors.service.impl;

import amors.entity.Song;
import amors.repository.SongRepository;
import amors.service.api.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    @Transactional
    public List<Song> findAll(int start, int max) {
        Pageable size = PageRequest.of(start, max);
        Page<Song> all = songRepository.findAll(size);
        return all.getContent();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }
}
