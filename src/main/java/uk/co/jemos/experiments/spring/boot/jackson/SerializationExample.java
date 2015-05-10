package uk.co.jemos.experiments.spring.boot.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tedonema on 09/05/2015.
 */
public class SerializationExample {

    private final Logger LOG = LogManager.getLogger(SerializationExample.class);

    public static void main(String[] args) throws IOException, ParseException
    {
        new SerializationExample().doWork();


    }

    private void doWork() throws ParseException, IOException {
        LOG.error("Try this");
        ObjectMapper mapper = new ObjectMapper();
        Album album = new Album("Kind Of Blue");
        album.setLinks(new String[]{"link1", "link2"});
        List<String> songs = new ArrayList<String>();
        songs.add("So What");
        songs.add("Flamenco Sketches");
        songs.add("Freddie Freeloader");
        album.setSongs(songs);
        Artist artist = new Artist();
        artist.name = "Miles Davis";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        artist.birthDate = format.parse("26-05-1926");
        album.setArtist(artist);
        album.addMusician("Miles Davis", "Trumpet, Band leader");
        album.addMusician("Julian Adderley", "Alto Saxophone");
        album.addMusician("Paul Chambers", "double bass");
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
        mapper.setDateFormat(outputFormat);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        File resultFile = new File("/Users/tedonema/tmp/album.json");
        mapper.writeValue(resultFile, album);

        Album retrievedAlbum = mapper.readValue(resultFile, Album.class);
        LOG.info(retrievedAlbum.toString());
    }
}
