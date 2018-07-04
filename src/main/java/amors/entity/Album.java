package amors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    
    @OneToMany
    @JoinColumn(name = "album_id")
    private Set<Song> songs;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_content_id")
    private FileContent fileContent;
    
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
    
    public Artist getArtist() {
        return artist;
    }
    
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    
    public Set<Song> getSongs() {
        return songs;
    }
    
    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
    
    public FileContent getFileContent() {
        return fileContent;
    }
    
    public void setFileContent(FileContent fileContent) {
        this.fileContent = fileContent;
    }
}
