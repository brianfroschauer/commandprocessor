package commandprocessor.command;

import commandprocessor.command.message.CommandMessage;
import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.command.output.CommandOutputImpl;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an unrecognized command.
 */
public class UnrecognizedCommand extends AbstractCommand {

    public UnrecognizedCommand() {
        super(CommandName.UNRECOGNIZED);
    }

    @Override
    public CommandOutput execute(final @NotNull File file) {
        return new CommandOutputImpl(file, CommandMessage.UNRECOGNIZED_COMMAND.getMessage());
    }
}
