package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.QuitCommand;
import commandprocessor.command.name.CommandName;

public class QuitCommandFactory extends AbstractCommandFactory {

    public QuitCommandFactory() {
        super(CommandName.QUIT);
    }

    @Override
    public Command create(String... arguments) {
        return create(0, arguments.length, QuitCommand::new);
    }
}
