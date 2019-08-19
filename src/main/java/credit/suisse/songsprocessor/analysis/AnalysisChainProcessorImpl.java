package credit.suisse.songsprocessor.analysis;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class AnalysisChainProcessorImpl implements AnalysisChainProcessor {

    private List<Analysis> analysisList;

    @PostConstruct
    protected void initializeAnalysis() {
        analysisList = new ArrayList<>();
        analysisList.add(new TotalTrackTimeAnalysis());
        analysisList.add(new DistinctCollectionsAnalysis());
        analysisList.add(new AveragePriceOfTrackAnalysis());
    }

    public void processAnalysis(final List<SearchItem> items) {
        analysisList.stream().forEach(analysis -> { analysis.analyze(items); analysis.print(); });
    }

}
