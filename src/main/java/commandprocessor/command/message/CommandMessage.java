package commandprocessor.command.message;

import org.jetbrains.annotations.NotNull;

/**
 * Enumeration used for all output messages of the command line processor.
 */
public enum CommandMessage {

    INVAlID_COMMAND("Invalid command"),
    INVALID_FILE("Invalid file or folder name"),
    UNRECOGNIZED_COMMAND("Unrecognized command"),
    DIRECTORY_ALREADY_EXISTS("Directory already exists"),
    DIRECTORY_NOT_FOUNT("Directory not found");

    private final String message;

    CommandMessage(final @NotNull String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
