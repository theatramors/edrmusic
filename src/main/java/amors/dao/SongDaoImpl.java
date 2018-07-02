package amors.dao;

import amors.dao.api.SongDao;
import amors.dto.SongInfo;
import amors.entity.Album;
import amors.entity.Artist;
import amors.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongDaoImpl implements SongDao {
    private SessionFactory sessionFactory;
    
    @Autowired
    public SongDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void addSong(Song song) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(song);
    }
    
    @SuppressWarnings("unchecked")
    public List<Song> getSongs() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT song FROM Song AS song ORDER BY song.id DESC");
        return query.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Song> getSongs(int start, int max) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT song.id, song.artist, song.album, song.songTitle FROM Song AS song ORDER BY song.id DESC");
        query.setFirstResult(start).setMaxResults(max);
        List<Object[]> objects = query.list();
        List<Song> songs = new ArrayList<>();
        for (Object[] object : objects) {
            Song song = new Song();
            song.setId((Long) object[0]);
            song.setArtist((Artist) object[1]);
            song.setAlbum((Album) object[2]);
            song.setSongTitle((String) object[3]);
            songs.add(song);
        }
        return songs;
    }
    
    @SuppressWarnings("unchecked")
    public List<SongInfo> getAllSongsInfo() {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT song.artist.name, song.songTitle FROM Song AS song ORDER BY song.id DESC");
        List<Object[]> objects = query.list();
        List<SongInfo> songInfoList = new ArrayList<>();
        for (Object[] object : objects) {
            SongInfo songInfo = new SongInfo();
            songInfo.setArtistName((String) object[0]);
            songInfo.setSongTitle((String) object[1]);
            songInfoList.add(songInfo);
        }
        return songInfoList;
    }
    
    @SuppressWarnings("unchecked")
    public List<Song> getSongsByArtist(String artist) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT song FROM Song AS song WHERE song.artist.name = :artist");
        query.setParameter("artist", artist);
        return query.list();
    }
    
    @SuppressWarnings("unchecked")
    public byte[] getSongFile(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT song.file FROM Song AS song WHERE song.id = :id");
        query.setParameter("id", id);
        return (byte[]) query.uniqueResult();
    }
}
