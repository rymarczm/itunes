package credit.suisse.songsprocessor.itunes.parser.asserts;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import credit.suisse.songsprocessor.itunes.parser.SearchResult;
import org.junit.Assert;

import java.util.List;

public class SearchResultAssert {

    private SearchResult searchResult;

    public SearchResultAssert(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    public SearchResultAssert hasResultCount(final int resultCount) {
        Assert.assertEquals(resultCount, searchResult.getResultCount().intValue());
        return this;
    }

    public SearchResultAssert hasWrapperType(final String wrapperType, final int recordNo) {
        List<SearchItem> itemList=searchResult.getResults();
        SearchItem item=itemList.get(recordNo);
        if (item!=null) {
            Assert.assertEquals("wrapperTypes are not equal", wrapperType, item.getWrapperType());
        } else {
            Assert.fail("no record with recordNo "+recordNo);
        }
        return this;
    }

    public SearchResultAssert hasTrackName(final String trackName, final int recordNo) {
        List<SearchItem> itemList=searchResult.getResults();
        SearchItem item=itemList.get(recordNo);
        if (item!=null) {
            Assert.assertEquals("Track names are not equal", trackName, item.getTrackName());
        } else {
            Assert.fail("no record with recordNo "+recordNo);
        }
        return this;
    }
}
