package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.message.CommandMessage;
import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutputImpl;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public abstract class AbstractCommandFactory implements CommandFactory {

    private final CommandName commandName;

    public AbstractCommandFactory(final @NotNull CommandName commandName) {
        this.commandName = commandName;
    }

    @Override
    public CommandName getCommandName() {
        return commandName;
    }

    /**
     * Create a command validating if the number of arguments provided is as expected or not.
     *
     * @param expectedArguments expected arguments amount.
     * @param actualArguments   actual arguments amount.
     * @param commandSupplier   the concrete command supplier.
     * @return an invalid command if the actual and expected arguments amount does not match.
     */
    protected Command create(int expectedArguments, int actualArguments, @NotNull Supplier<Command> commandSupplier) {
        if (expectedArguments != actualArguments) {
            return invalidCommand();
        }

        return commandSupplier.get();
    }

    /**
     * @return a command that returns the invalid command message as output.
     */
    protected Command invalidCommand() {
        return file -> new CommandOutputImpl(file, CommandMessage.INVAlID_COMMAND.getMessage());
    }

    /**
     * @return a command that returns the invalid file message as output.
     */
    protected Command invalidFile() {
        return file -> new CommandOutputImpl(file, CommandMessage.INVALID_FILE.getMessage());
    }
}
