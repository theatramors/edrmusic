package amors.service;

import amors.dao.api.AlbumDao;
import amors.dao.api.ArtistDao;
import amors.dao.api.SongDao;
import amors.dto.SongInfo;
import amors.entity.Album;
import amors.entity.Artist;
import amors.entity.Song;
import amors.service.api.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DataServiceImpl implements DataService {
    private SongDao songDao;
    private ArtistDao artistDao;
    private AlbumDao albumDao;
    
    @Autowired
    public DataServiceImpl(SongDao songDao, ArtistDao artistDao, AlbumDao albumDao) {
        this.songDao = songDao;
        this.artistDao = artistDao;
        this.albumDao = albumDao;
    }
    
    @Override
    public void addSong(Song song) {
        songDao.addSong(song);
    }
    
    @Override
    public List<Song> getSongs() {
        return songDao.getSongs();
    }
    
    @Override
    public List<Song> getSongs(int start, int max) {
        return songDao.getSongs(start, max);
    }
    
    @Override
    public List<SongInfo> getAllSongsInfo() {
        return songDao.getAllSongsInfo();
    }
    
    @Override
    public List<Song> getSongsByArtist(String artist) {
        return songDao.getSongsByArtist(artist);
    }
    
    @Override
    public byte[] getSongFile(int id) {
        return songDao.getSongFile(id);
    }
    
    @Override
    public List<Artist> getArtists() {
        return artistDao.getArtists();
    }
    
    @Override
    public List<Artist> getArtists(int start, int end) {
        return artistDao.getArtists(start, end);
    }
    
    @Override
    public Artist getArtist(Long id) {
        return artistDao.getArtistById(id);
    }
    
    @Override
    public byte[] getArtistLogo(Long id) {
        return artistDao.getArtistLogo(id);
    }
    
    @Override
    public List<Album> getAlbums() {
        return albumDao.getAlbums();
    }
    
    @Override
    public List<Album> getAlbums(int start, int max) {
        return albumDao.getAlbums(start, max);
    }
    
    @Override
    public Album getAlbum(Long id) {
        return albumDao.getAlbum(id);
    }
    
    @Override
    public byte[] getAlbumCover(Long id) {
        return albumDao.getAlbumCover(id);
    }
}
