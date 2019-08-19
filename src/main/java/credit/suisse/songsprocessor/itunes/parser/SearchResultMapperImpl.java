package credit.suisse.songsprocessor.itunes.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import credit.suisse.songsprocessor.exception.SongParsingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SearchResultMapperImpl implements SearchResultMapper {

    @Override
    public SearchResult parse(InputStream inputStream) throws SongParsingException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final SearchResult searchResult;
        try {
            searchResult = mapper.readValue(inputStream, SearchResult.class);
            return searchResult;
        } catch (Exception ex) {
            throw new SongParsingException("Problem during parsing ",ex);
        }
    }
}
