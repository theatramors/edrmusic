package amors.dao;

import amors.dao.api.ArtistDao;
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
public class ArtistDaoImpl implements ArtistDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Artist> getArtists() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT artist.id, artist.name, artist.albums, artist.songs FROM Artist AS artist");
        List<Object[]> objects = query.list();
        List<Artist> artists = new ArrayList<>();
        for (Object[] object : objects) {
            Artist artist = new Artist();
            artist.setId((Long) object[0]);
            artist.setName((String) object[1]);
            artist.setAlbums((Set<Album>) object[2]);
            artist.setSongs((Set<Song>) object[3]);
            artists.add(artist);
        }
        return artists;
    }
    
    @Override
    public List<Artist> getArtists(int start, int max) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT artist.id, artist.name, artist.albums, artist.songs FROM Artist AS artist");
        // query.setFirstResult(start).setMaxResults(max);
        List<Object[]> objects = (List<Object[]>) query.list();
        List<Artist> artists = new ArrayList<>();
        for (Object[] object : objects) {
            Artist artist = new Artist();
            artist.setId((Long) object[0]);
            artist.setName((String) object[1]);
            // artist.setAlbums((Set<Album>) object[2]);
            // artist.setSongs((Set<Song>) object[3]);
            artists.add(artist);
        }
        return artists;
    }
    
    @Override
    public Artist getArtistById(Long id) {
        return sessionFactory.getCurrentSession().get(Artist.class, id);
    }
    
    @Override
    public byte[] getArtistLogo(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT artist.image FROM Artist AS artist WHERE artist.id = :id");
        query.setParameter("id", id);
        return (byte[]) query.uniqueResult();
    }
}
