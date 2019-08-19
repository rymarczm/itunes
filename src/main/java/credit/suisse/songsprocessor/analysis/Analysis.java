package credit.suisse.songsprocessor.analysis;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import credit.suisse.songsprocessor.itunes.parser.SearchResult;

import java.util.List;

public interface Analysis {

    public void analyze(List<SearchItem> items);

    public void print();
}
