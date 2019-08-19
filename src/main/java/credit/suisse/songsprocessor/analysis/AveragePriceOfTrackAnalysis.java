package credit.suisse.songsprocessor.analysis;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.OptionalDouble;

@Getter
public class AveragePriceOfTrackAnalysis implements Analysis {

    private BigDecimal averagePriceOfTrack;

    @Override
    public void analyze(List<SearchItem> items) {
        OptionalDouble average = items.stream().map(SearchItem::getTrackPrice).mapToDouble(BigDecimal::doubleValue).average();
        if (average.isPresent()) {
            averagePriceOfTrack = BigDecimal.valueOf(average.getAsDouble()).setScale(2, RoundingMode.HALF_UP);
        }
    }

    @Override
    public void print() {
        System.out.println("Analysis: Average price of track is "+averagePriceOfTrack);
    }
}
