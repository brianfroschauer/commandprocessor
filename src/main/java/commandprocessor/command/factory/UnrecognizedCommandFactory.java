package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.UnrecognizedCommand;
import commandprocessor.command.name.CommandName;

public class UnrecognizedCommandFactory extends AbstractCommandFactory {

    public UnrecognizedCommandFactory() {
        super(CommandName.UNRECOGNIZED);
    }

    @Override
    public Command create(String... arguments) {
        return new UnrecognizedCommand();
    }
}
