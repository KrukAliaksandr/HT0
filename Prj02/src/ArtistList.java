import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ArtistList {
    HashMap<String, HashMap<String, HashMap<String, File>>> ArtistList;
    HashMap<String, HashMap<String, File>> AlbumList;
    HashMap<String, File> TrackList;

    public HashMap<String, HashMap<String, HashMap<String, File>>> getArtistList(ArrayList<File> ourFiles) throws InvalidDataException, IOException, UnsupportedTagException {
        ArtistList = new HashMap<String, HashMap<String, HashMap<String, File>>>();
        AlbumList = new HashMap<String, HashMap<String, File>>();
        TrackList = new HashMap<String, File>();
        String currentSongName = "  ";
        String currentSongArtist = "";
        String currentSongAlbum = "";
        long currentSongLength;
        Mp3File currentMp3File;
        for (File currentFile : ourFiles) {
            currentMp3File = new Mp3File(currentFile);
            currentSongLength = currentMp3File.getLengthInSeconds();
            if (currentMp3File.hasId3v1Tag()) {
                ID3v1 id3v1Tag = currentMp3File.getId3v1Tag();
                currentSongName = id3v1Tag.getTrack();
                currentSongArtist = id3v1Tag.getArtist();

                if (id3v1Tag.getAlbum().length() == 0) {
                    currentSongAlbum = "UnknownAlbum";
                } else {
                    currentSongAlbum = id3v1Tag.getAlbum();
                }
            } else if (currentMp3File.hasId3v2Tag()) {
                ID3v2 id3v2Tag = currentMp3File.getId3v2Tag();
                currentSongName = id3v2Tag.getTrack();
                currentSongArtist = id3v2Tag.getArtist();

                if (id3v2Tag.getAlbum() != null) {
                if (id3v2Tag.getAlbum().length() == 0) {
                    currentSongAlbum = "UnknownAlbum";
                } else {
                    currentSongAlbum = id3v2Tag.getAlbum();
                }}

            } else {
                System.out.println("Wrong Format on :" + currentFile.getName());
continue;
            }

            if (ArtistList.containsKey(currentSongArtist)) {
                AlbumList = ArtistList.get(currentSongArtist);
                if (AlbumList.containsKey(currentSongAlbum)) {
                    TrackList = AlbumList.get(currentSongAlbum);
                    if (TrackList.containsKey(currentFile.getAbsolutePath())) {
                        System.out.println("File:" + currentFile.getAbsolutePath() + "already exists and will be rewritten");

                    } else {
                        TrackList.put(currentFile.getAbsolutePath(), currentFile);
                    }
                } else {
                    TrackList = new HashMap<String, File>();
                    TrackList.put(currentFile.getAbsolutePath(), currentFile);
                    AlbumList.put(currentSongAlbum, TrackList);
                }

            } else TrackList = new HashMap<String, File>();
            TrackList.put(currentFile.getAbsolutePath(), currentFile);
            AlbumList = new HashMap<String, HashMap<String, File>>();
            AlbumList.put(currentSongAlbum, TrackList);
            ArtistList.put(currentSongArtist, AlbumList);
            System.out.println("Name :" + currentSongName + ".Artist :" + currentSongArtist + ".Length :" + currentSongLength + ".Album :" + currentSongAlbum);
        }
        return ArtistList;
    }

}
