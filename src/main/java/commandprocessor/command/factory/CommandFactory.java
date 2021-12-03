package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.name.CommandName;

/**
 * This class declares the factory method that must return an object of a {@link Command} class.
 */
public interface CommandFactory {

    /**
     * @return the command factory name as {@link CommandName}.
     */
    CommandName getCommandName();

    /**
     * Builds the command with the provided arguments.
     *
     * @param arguments the arguments as an array of String.
     * @return the command built.
     */
    Command create(final String... arguments);
}
