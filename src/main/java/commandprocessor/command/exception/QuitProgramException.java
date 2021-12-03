package commandprocessor.command.exception;

/**
 * Exception used to terminate the program.
 */
public class QuitProgramException extends RuntimeException {

    public QuitProgramException() {
        super("Quit program exception");
    }
}
