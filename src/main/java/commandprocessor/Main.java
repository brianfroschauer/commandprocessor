package commandprocessor;

import commandprocessor.command.Command;
import commandprocessor.command.exception.QuitProgramException;
import commandprocessor.command.factory.*;
import commandprocessor.command.factory.strategy.CommandFactoryStrategy;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.command.processor.CommandProcessor;
import commandprocessor.command.configuration.CommandProcessorConfiguration;
import commandprocessor.command.configuration.DefaultCommandProcessorConfiguration;
import commandprocessor.file.File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Default command processor configuration
        final CommandProcessorConfiguration configuration = new DefaultCommandProcessorConfiguration();
        final CommandFactoryStrategy commandFactoryStrategy = configuration.getCommandFactoryStrategy();
        final CommandProcessor commandProcessor = configuration.getCommandProcessor();
        File current = configuration.getFile();

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        try {
            while ((line = br.readLine()) != null) {
                final String[] commandArray = line.split(" ");

                // Get the parts of the command array
                final String commandName = commandArray[0];
                final String[] commandArguments = Arrays.copyOfRange(commandArray, 1, commandArray.length);

                // Get the concrete factory for the command name
                final CommandFactory factory = commandFactoryStrategy.getFactory(commandName);

                // Create the command
                final Command command = factory.create(commandArguments);

                try {
                    // Execute the command and print the command output
                    final CommandOutput output = commandProcessor.execute(current, command);
                    output.getOutput().forEach(System.out::println);

                    // Change the current file to the output file
                    current = output.getFile();
                } catch (QuitProgramException ignored) {
                    System.exit(0);
                }
            }
        } catch (IOException ignore) {
            System.out.println("Error reading stdin");
        }
    }
}
