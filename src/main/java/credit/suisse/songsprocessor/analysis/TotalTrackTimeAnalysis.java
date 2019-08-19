package credit.suisse.songsprocessor.analysis;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import credit.suisse.songsprocessor.itunes.parser.SearchResult;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Getter
public class TotalTrackTimeAnalysis implements Analysis{

    private long hours;

    private long minutes;

    private long seconds;

    @Override
    public void analyze(List<SearchItem> items) {
        Long totalTrackTimeMillis=items.stream().collect(Collectors.summingLong(SearchItem::getTrackTimeMillis));
        hours = TimeUnit.MILLISECONDS.toHours(totalTrackTimeMillis);
        minutes = TimeUnit.MILLISECONDS.toMinutes(totalTrackTimeMillis) - TimeUnit.HOURS.toMinutes(hours);
        seconds = TimeUnit.MILLISECONDS.toSeconds(totalTrackTimeMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTrackTimeMillis));
    }

    public void print() {
        System.out.format("Analysis: Total track time: %d hours, %d minutes, %d seconds \n", hours, minutes, seconds);
    }
}
