import java.io.File;
import java.util.HashMap;

public class Artist {
    private String name;
    HashMap<String,HashMap<String,File>> albumList;

    public Artist(String name, HashMap<String, HashMap<String, File>> albumList) {
        this.name = name;
        this.albumList = albumList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, HashMap<String, File>> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(HashMap<String, HashMap<String, File>> albumList) {
        this.albumList = albumList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (name != null ? !name.equals(artist.name) : artist.name != null) return false;
        return albumList != null ? albumList.equals(artist.albumList) : artist.albumList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (albumList != null ? albumList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", albumList=" + albumList +
                '}';
    }
}
