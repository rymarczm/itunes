package credit.suisse.songsprocessor;

import credit.suisse.songsprocessor.analysis.AnalysisChainProcessor;
import credit.suisse.songsprocessor.analysis.AnalysisChainProcessorImpl;
import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import credit.suisse.songsprocessor.itunes.parser.SearchResult;
import credit.suisse.songsprocessor.itunes.parser.SearchResultMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class SongsProcessorApplication implements CommandLineRunner {

    @Autowired
    private SearchResultMapper searchResultMapper;

    @Autowired
    private AnalysisChainProcessor analysisChainProcessor;

    public static void main(String[] args) {
        SpringApplication.run(SongsProcessorApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        if (args!=null && args.length>0) {
            InputStream inputStream = getClass()
                    .getClassLoader().getResourceAsStream(args[0]);
            if (inputStream != null) {
                SearchResult searchResult = searchResultMapper.parse(inputStream);
                List<SearchItem> songItems = searchResult.getResults().stream().filter(searchItem -> searchItem.getKind().equals("song")).collect(Collectors.toList());
                analysisChainProcessor.processAnalysis(songItems);
            } else {
                log.info("File " + args[0] + "was not found");
            }
        } else {
            log.info("Please type name of file with songs");
        }
    }
}
