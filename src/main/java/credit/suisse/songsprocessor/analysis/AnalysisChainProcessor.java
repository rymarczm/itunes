package credit.suisse.songsprocessor.analysis;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;

import java.util.List;

public interface AnalysisChainProcessor {

    public void processAnalysis(final List<SearchItem> items);

}