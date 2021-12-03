package commandprocessor.command;

import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.command.output.CommandOutputImpl;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

/**
 * This command print the full path of the current directory.
 */
public class CurrentDirectoryCommand extends AbstractCommand {

    public CurrentDirectoryCommand() {
        super(CommandName.PWD);
    }

    public CommandOutput execute(final @NotNull File file) {
        return new CommandOutputImpl(file, file.getAbsolutePath());
    }
}
