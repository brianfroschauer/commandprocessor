package commandprocessor.command;

import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.command.output.CommandOutputImpl;
import commandprocessor.file.File;
import commandprocessor.file.FileImpl;
import org.jetbrains.annotations.NotNull;

/**
 * This command creates a "file" in the current directory.
 *
 * Parameters:
 * [fileName] the name of the file to create. Character limit of 100.
 */
public class CreateFileCommand extends AbstractCommand {

    /**
     * The name of the file to create.
     */
    private final String fileName;

    public CreateFileCommand(final @NotNull String fileName) {
        super(CommandName.TOUCH);
        this.fileName = fileName;
    }

    @Override
    public CommandOutput execute(final @NotNull File file) {
        boolean fileNameExists = file
                .getSubdirectories()
                .stream()
                .anyMatch(subdirectory -> subdirectory.getName().equals(fileName));

        if (fileNameExists) {
            return new CommandOutputImpl(file);
        }

        file.addSubdirectory(new FileImpl(fileName, false));

        return new CommandOutputImpl(file);
    }
}
