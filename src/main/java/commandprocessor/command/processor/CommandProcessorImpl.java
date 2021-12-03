package commandprocessor.command.processor;

import commandprocessor.command.Command;
import commandprocessor.command.exception.QuitProgramException;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessorImpl implements CommandProcessor {

    @Override
    public List<CommandOutput> execute(final @NotNull File file, final @NotNull List<Command> commands) {
        final List<CommandOutput> commandOutputList = new ArrayList<>();

        File current = file;

        try {
            for (final Command command: commands) {
                final CommandOutput commandOutput = command.execute(current);
                commandOutputList.add(commandOutput);
                current = commandOutput.getFile();
            }
        } catch (QuitProgramException ignored) {

        }

        return commandOutputList;
    }

    @Override
    public CommandOutput execute(@NotNull File file, @NotNull Command command) {
        return command.execute(file);
    }
}
