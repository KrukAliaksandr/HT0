import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
/**
 * correct arguments input format is
 *  С:\\users\\audio
 */
    public static void main(String[] args) throws InvalidDataException, IOException, UnsupportedTagException {

        ArrayList<File> ls = new ArrayList<>();
        for (String arg : args) {
            Mp3Finder.findAllMp3Audio(new File(arg), ls);
        }
        ArtistList artistList = new ArtistList();
        HtmlClass htmlClass = new HtmlClass();
        htmlClass.createHtml(artistList.getArtistList(ls));
    }

}

