package commandprocessor.command.factory.strategy;

import commandprocessor.command.factory.CommandFactory;
import org.jetbrains.annotations.NotNull;

public interface CommandFactoryStrategy {

    /**
     * Gets the {@link CommandFactory} given the command name.
     *
     * @param commandName the command name.
     * @return the concrete command factory.
     */
    CommandFactory getFactory(final @NotNull String commandName);
}
