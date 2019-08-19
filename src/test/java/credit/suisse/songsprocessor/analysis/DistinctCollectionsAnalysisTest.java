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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DistinctCollectionsAnalysisTest {

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
        DistinctCollectionsAnalysis analysis = new DistinctCollectionsAnalysis();
        analysis.analyze(items);
        Assert.assertEquals(3, analysis.getDictinctCollections());

    }
}