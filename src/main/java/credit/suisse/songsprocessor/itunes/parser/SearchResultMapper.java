package credit.suisse.songsprocessor.itunes.parser;

import credit.suisse.songsprocessor.exception.SongParsingException;

import java.io.InputStream;

public interface SearchResultMapper {

    public SearchResult parse(InputStream inputStream) throws SongParsingException;
}
