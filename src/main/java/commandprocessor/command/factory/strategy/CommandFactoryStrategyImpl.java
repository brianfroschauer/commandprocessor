package commandprocessor.command.factory.strategy;

import commandprocessor.command.factory.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandFactoryStrategyImpl implements CommandFactoryStrategy {

    private final List<CommandFactory> factories;

    public CommandFactoryStrategyImpl(final CommandFactory... factories) {
        this.factories = new ArrayList<>();
        // Always present for unrecognized commands,
        // it is used as fallback in case there is no
        // factory for the provided command name
        this.factories.add(new UnrecognizedCommandFactory());
        this.factories.addAll(Arrays.asList(factories));
    }

    @Override
    public CommandFactory getFactory(final @NotNull String commandName) {
        return factories.stream()
                .filter(factory -> factory.getCommandName().getName().equals(commandName))
                .findFirst()
                .orElseGet(UnrecognizedCommandFactory::new);
    }
}
