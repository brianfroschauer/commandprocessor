package commandprocessor.integration;

import commandprocessor.command.Command;
import commandprocessor.command.exception.QuitProgramException;
import commandprocessor.command.factory.*;
import commandprocessor.command.factory.strategy.CommandFactoryStrategy;
import commandprocessor.command.factory.strategy.CommandFactoryStrategyImpl;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.file.File;
import commandprocessor.file.FileImpl;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseTest {

    protected void runTest(String[] expectedOutput, String... input) {
        final List<String> result = new ArrayList<>();

        File current = new FileImpl(null, "root", true);

        final List<Command> commands = Arrays.stream(input)
                .map(this::buildCommand)
                .collect(Collectors.toList());

        for (Command command : commands) {
            try {
                final CommandOutput output = command.execute(current);
                current = output.getFile();
                result.addAll(output.getOutput());
            } catch (QuitProgramException ignored) {

            }
        }

        final String[] actualOutput = new String[result.size()];
        result.toArray(actualOutput);

        Assert.assertArrayEquals(expectedOutput, actualOutput);
    }

    private Command buildCommand(String command) {
        // Create the command factory strategy and initialize with the concrete command factories
        final CommandFactoryStrategy commandStrategy = new CommandFactoryStrategyImpl(
                new ChangeDirectoryCommandFactory(),
                new CreateFileCommandFactory(),
                new CurrentDirectoryCommandFactory(),
                new ListCommandFactory(),
                new MakeDirectoryCommandFactory(),
                new QuitCommandFactory()
        );

        final String[] commandArray = command.split(" ");

        // Get the parts of the command array
        final String commandName = commandArray[0];
        final String[] commandArguments = Arrays.copyOfRange(commandArray, 1, commandArray.length);

        // Get the concrete factory for the command name
        final CommandFactory factory = commandStrategy.getFactory(commandName);

        // Create the command
        return factory.create(commandArguments);
    }
}