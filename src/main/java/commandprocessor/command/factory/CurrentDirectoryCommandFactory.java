package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.CurrentDirectoryCommand;
import commandprocessor.command.name.CommandName;

public class CurrentDirectoryCommandFactory extends AbstractCommandFactory {

    public CurrentDirectoryCommandFactory() {
        super(CommandName.PWD);
    }

    @Override
    public Command create(String... arguments) {
        return create(0, arguments.length, CurrentDirectoryCommand::new);
    }
}
