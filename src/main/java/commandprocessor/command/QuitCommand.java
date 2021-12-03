package commandprocessor.command;

import commandprocessor.command.exception.QuitProgramException;
import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

/**
 * This command interrupt the program.
 */
public class QuitCommand extends AbstractCommand {

    public QuitCommand() {
        super(CommandName.QUIT);
    }

    @Override
    public CommandOutput execute(final @NotNull File file) {
        throw new QuitProgramException();
    }
}