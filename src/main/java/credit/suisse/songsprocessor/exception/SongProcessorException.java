package credit.suisse.songsprocessor.exception;

public class SongProcessorException extends Exception {

    public SongProcessorException(String message) {
        super(message);
    }

    public SongProcessorException(String message, Throwable cause) {
        super(message, cause);
    }
}
