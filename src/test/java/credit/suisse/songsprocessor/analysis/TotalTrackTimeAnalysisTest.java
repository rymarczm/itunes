package credit.suisse.songsprocessor.analysis;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import credit.suisse.songsprocessor.itunes.parser.SearchResult;
import credit.suisse.songsprocessor.itunes.parser.SearchResultMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TotalTrackTimeAnalysisTest {

    @Autowired
    private SearchResultMapper searchResultMapper;

    private List<SearchItem> items;

    @Before
    public void initItemsToAnalyse() throws Exception{
        File initialFile = new File("src/test/resources/songs.json");
        InputStream targetStream = new FileInputStream(initialFile);
        SearchResult searchResult=searchResultMapper.parse(targetStream);
        items = searchResult.getResults();
    }

    @Test
    public void shouldCalculateCorrectlyDistinctCollections() {
        TotalTrackTimeAnalysis analysis = new TotalTrackTimeAnalysis();
        analysis.analyze(items);
        Assert.assertEquals(3,analysis.getHours());
        Assert.assertEquals(30,analysis.getMinutes());
        Assert.assertEquals(5,analysis.getSeconds());



    }

}