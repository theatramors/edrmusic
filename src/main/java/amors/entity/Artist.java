package amors.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"artist", "songs"})
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist")
    private Set<Album> albums;

    @JsonIgnoreProperties({"artist", "album"})
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist")
    private Set<Song> songs;

    @ManyToOne
    @JoinColumn(name = "file_content_id")
    private FileContent fileContent;

    @Column(name = "genre")
    private String genre;

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

    public FileContent getFileContent() {
        return fileContent;
    }

    public void setFileContent(FileContent fileContent) {
        this.fileContent = fileContent;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
