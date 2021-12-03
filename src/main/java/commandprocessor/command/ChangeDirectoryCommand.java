package commandprocessor.command;

import commandprocessor.command.message.CommandMessage;
import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.command.output.CommandOutputImpl;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This command changes the current path to a sub-directory (by name).
 * If the name does not exist, a message like "Directory not found" should be displayed.
 *
 * This command should also accept the dirName of "..", which indicates the current directory
 * should be changed to the parent. If the current directory is "root", no message should be
 * displayed.
 *
 * Parameters:
 * [dirName] the name of the sub-directory to change current path to.
 */
public class ChangeDirectoryCommand extends AbstractCommand {

    /**
     * Indicates if the directory to change is the parent.
     */
    private static final String CHANGE_DIRECTORY_TO_PARENT = "..";

    /**
     * The name of the sub-directory to change current path to.
     */
    private final String directoryName;

    public ChangeDirectoryCommand(final @NotNull String directoryName) {
        super(CommandName.CD);
        this.directoryName = directoryName;
    }

    @Override
    public CommandOutput execute(final @NotNull File file) {
        if (CHANGE_DIRECTORY_TO_PARENT.equals(directoryName)) {
            final File parent = file.getParent();
            return Objects.isNull(parent) ? new CommandOutputImpl(file) : new CommandOutputImpl(parent);
        }

        return file.getSubdirectories()
                .stream()
                .filter(subdirectory -> subdirectory.isDirectory() && subdirectory.getName().equals(directoryName))
                .findFirst()
                .map(CommandOutputImpl::new)
                .orElseGet(() -> new CommandOutputImpl(file, CommandMessage.DIRECTORY_NOT_FOUNT.getMessage()));
    }
}
