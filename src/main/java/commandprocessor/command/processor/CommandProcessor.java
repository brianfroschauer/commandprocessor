package commandprocessor.command.processor;

import commandprocessor.command.Command;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface CommandProcessor {

    /**
     * Execute all provided commands.
     *
     * @param commands the commands to be executed.
     * @return the command output as a list of {@link CommandOutput}.
     */
    List<CommandOutput> execute(final @NotNull File file, final @NotNull List<Command> commands);

    /**
     * Execute the provided command.
     *
     * @param command the command to be executed.
     * @return the command output as a list of {@link CommandOutput}.
     */
    CommandOutput execute(final @NotNull File file, @NotNull final Command command);
}
