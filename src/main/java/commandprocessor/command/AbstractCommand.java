package commandprocessor.command;

import commandprocessor.command.name.CommandName;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents an abstract command. It has an abstract execute
 * method that depends on specific implementation of this command.
 */
public abstract class AbstractCommand implements Command {

    private final CommandName commandName;

    public AbstractCommand(final @NotNull CommandName commandName) {
        this.commandName = commandName;
    }

    /**
     * @return the command name.
     */
    public CommandName getCommandName() {
        return commandName;
    }
}
