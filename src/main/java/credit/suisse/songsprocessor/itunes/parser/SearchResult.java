package credit.suisse.songsprocessor.itunes.parser;

import lombok.Data;

import java.util.List;

@Data
public class SearchResult {

    Integer resultCount;

    List<SearchItem> results;

}
