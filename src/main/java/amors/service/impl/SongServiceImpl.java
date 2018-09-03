package amors.service.impl;

import amors.entity.*;
import amors.repository.*;
import amors.service.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

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
