import com.mpatric.mp3agic.Mp3File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class HtmlClass {
    public static final int SECONDS_IN_MINUTES = 60;
    private HashMap<String, HashMap<String, HashMap<String, File>>> ArtistList;
    private HashMap<String, HashMap<String, File>> AlbumList;
    private HashMap<String, File> TrackList;
    private String currentMp3Name;

    public void createHtml(HashMap<String, HashMap<String, HashMap<String, File>>> ArtistList) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\audio_list.html"));
            out.write("<table style=\"border-collapse: collapse; border: none;\">");
            for (String Artist : ArtistList.keySet()) {

                out.write("<tr><td>" + Artist + "</td></tr>");
                AlbumList = ArtistList.get(Artist);
                for (String Album : AlbumList.keySet()) {

                    out.write("<tr><td>" + Album + "</td></tr>");
                    TrackList = AlbumList.get(Album);
                    for (String Title : TrackList.keySet()) {
                        Mp3File currentMp3File = new Mp3File(Title);
                        if (currentMp3File.hasId3v1Tag()) {
                            currentMp3Name = currentMp3File.getId3v1Tag().getTitle();
                        } else if (currentMp3File.hasId3v1Tag()) {
                            currentMp3Name = currentMp3File.getId3v2Tag().getTitle();
                        }
                        StringBuilder log = new StringBuilder();
                        log.append("Name and Length: " + "\n");
                        log.append(Title);
                        log.append(" ");
                        log.append(currentMp3File.getLengthInSeconds());

                        out.write("<tr><td>" + "Name: " + currentMp3Name + " " +
                                (currentMp3File.getLengthInSeconds() / SECONDS_IN_MINUTES + ":"
                                        + currentMp3File.getLengthInSeconds() % SECONDS_IN_MINUTES)
                                + "<a href= \" " + currentMp3File.getFilename() + "  \">" + "" +
                                "Ссылка на локальный файл" + "</a></td></tr>");

                        out.write("<tr><td> </td></tr>");


                    }
                }
            }
            out.write("</table>");
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

