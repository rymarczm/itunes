package credit.suisse.songsprocessor.itunes.parser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SearchItem {

    String wrapperType;

    String kind;

    Long artistId;

    Long collectionId;

    String artistName;

    String collectionName;

    String trackName;

    Long trackId;

    String collectionCensoredName;

    String trackCensoredName;

    String artistViewUrl;

    String collectionViewUrl;

    String trackViewUrl;

    String previewUrl;

    String artworkUrl30;

    String artworkUrl100;

    String artworkUrl60;

    BigDecimal collectionPrice;

    BigDecimal trackPrice;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime releaseDate;

    String collectionExplicitness;

    Integer discNumber;

    Integer discCount;

    Integer trackCount;

    Integer trackNumber;

    Long trackTimeMillis;

    String country;

    String currency;

    String primaryGenreName;

    Boolean isStreamable;

    String trackExplicitness;

}
