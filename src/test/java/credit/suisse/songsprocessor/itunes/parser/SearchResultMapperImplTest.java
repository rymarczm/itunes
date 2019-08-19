package credit.suisse.songsprocessor.itunes.parser;

import credit.suisse.songsprocessor.exception.SongParsingException;
import credit.suisse.songsprocessor.itunes.parser.asserts.SearchResultAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchResultMapperImplTest {

    @Autowired
    private SearchResultMapper searchResultMapper;

    @Test
    public void shouldParseJson() throws FileNotFoundException, SongParsingException {
        File initialFile = new File("src/test/resources/songs.json");
        InputStream targetStream = new FileInputStream(initialFile);
        SearchResult searchResult = searchResultMapper.parse(targetStream);
        new SearchResultAssert(searchResult).hasResultCount(4).hasWrapperType("track",0).hasTrackName("Better Together",0)
                .hasTrackName("Banana Pancakes",1);

    }

    @Test
    public void shouldParseJsonWithAdditionalFields() throws FileNotFoundException, SongParsingException {
        File initialFile = new File("src/test/resources/songs1.json");
        InputStream targetStream = new FileInputStream(initialFile);
        SearchResult searchResult=searchResultMapper.parse(targetStream);
    }

}