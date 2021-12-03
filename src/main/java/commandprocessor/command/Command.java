package commandprocessor.command;

import commandprocessor.command.output.CommandOutput;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Command {

    /**
     * Execute the command.
     *
     * @param file the file in which the command is executed.
     * @return the output of the command as {@link CommandOutput}.
     */
    CommandOutput execute(final @NotNull File file);
}
