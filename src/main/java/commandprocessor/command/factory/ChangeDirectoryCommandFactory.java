package commandprocessor.command.factory;

import commandprocessor.command.ChangeDirectoryCommand;
import commandprocessor.command.Command;
import commandprocessor.command.name.CommandName;

public class ChangeDirectoryCommandFactory extends AbstractCommandFactory {

    public ChangeDirectoryCommandFactory() {
        super(CommandName.CD);
    }

    @Override
    public Command create(final String... arguments) {
        return create(1, arguments.length, (() -> {
            final String directoryName = arguments[0];
            return new ChangeDirectoryCommand(directoryName);
        }));
    }
}
