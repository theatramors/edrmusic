package amors.dao;

import amors.dao.api.AlbumDao;
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
import java.util.Set;

@Repository
@SuppressWarnings("unchecked")
public class AlbumDaoImpl implements AlbumDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Album> getAlbums() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT album.id, album.name, album.artist, album.songs FROM Album AS album");
        List<Object[]> objects = query.list();
        List<Album> albums = new ArrayList<>();
        for (Object[] object : objects) {
            Album album = new Album();
            album.setId((Long) object[0]);
            album.setName((String) object[1]);
            album.setArtist((Artist) object[2]);
            album.setSongs((Set<Song>) object[3]);
            albums.add(album);
        }
        return albums;
    }
    
    @Override
    public List<Album> getAlbums(int start, int max) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT album.id, album.name, album.artist, album.songs FROM Album AS album");
        // query.setFirstResult(start).setMaxResults(max);
        List<Object[]> objects = (List<Object[]>) query.list();
        List<Album> albums = new ArrayList<>();
        for (Object[] object : objects) {
            Album album = new Album();
            album.setId((Long) object[0]);
            album.setName((String) object[1]);
            album.setArtist((Artist) object[2]);
            // album.setSongs((Set<Song>) object[3]);
            albums.add(album);
        }
        return albums;
    }
    
    @Override
    public Album getAlbum(Long id) {
        return sessionFactory.getCurrentSession().get(Album.class, id);
    }
    
    @Override
    public byte[] getAlbumCover(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT album.image FROM Album AS album WHERE album.id = :id");
        query.setParameter("id", id);
        return (byte[]) query.uniqueResult();
    }
}
