package commandprocessor.command;

import commandprocessor.command.message.CommandMessage;
import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.command.output.CommandOutputImpl;
import commandprocessor.file.File;
import commandprocessor.file.FileImpl;
import org.jetbrains.annotations.NotNull;

/**
 * This command creates a directory entry in the cache.
 * If the directory already exists (by name), a message like "Directory
 * already exists" should be printed.
 * <p>
 * Parameters:
 * [dirName] the name of the directory to create. Character limit of 100.
 */
public class MakeDirectoryCommand extends AbstractCommand {

    /**
     * The name of the directory to create.
     */
    private final String directoryName;

    public MakeDirectoryCommand(final @NotNull String directoryName) {
        super(CommandName.MKDIR);
        this.directoryName = directoryName;
    }

    @Override
    public CommandOutput execute(final @NotNull File file) {
        boolean directoryNameExists = file
                .getSubdirectories()
                .stream()
                .anyMatch(f -> f.getName().equals(directoryName));

        if (directoryNameExists) {
            return new CommandOutputImpl(file, CommandMessage.DIRECTORY_ALREADY_EXISTS.getMessage());
        }

        file.addSubdirectory(new FileImpl(directoryName, true));

        return new CommandOutputImpl(file);
    }
}
