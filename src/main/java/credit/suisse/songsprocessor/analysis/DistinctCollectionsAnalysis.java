package credit.suisse.songsprocessor.analysis;

import credit.suisse.songsprocessor.itunes.parser.SearchItem;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class DistinctCollectionsAnalysis implements Analysis {

    private long dictinctCollections;

    @Override
    public void analyze(List<SearchItem> items) {
        dictinctCollections=items.stream().filter(distinctByKey(SearchItem::getCollectionName)).count();
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Override
    public void print() {
        System.out.println("Analysis: Number of different collections : "+dictinctCollections);
    }
}
