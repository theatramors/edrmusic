package amors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Image")
    private byte[] image;
    
    @OneToMany
    @JoinColumn(name = "ArtistId")
    private Set<Album> albums;
    
    @OneToMany
    @JoinColumn(name = "ArtistId")
    private Set<Song> songs;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public Set<Album> getAlbums() {
        return albums;
    }
    
    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
    
    public Set<Song> getSongs() {
        return songs;
    }
    
    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
