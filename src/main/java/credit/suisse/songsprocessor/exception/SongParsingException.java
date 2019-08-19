package credit.suisse.songsprocessor.exception;

public class SongParsingException extends SongProcessorException {

    public SongParsingException(String message) {
        super(message);
    }

    public SongParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
