package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.ListCommand;
import commandprocessor.command.name.CommandName;

public class ListCommandFactory extends AbstractCommandFactory {

    private final static String ARGUMENT_RECURSIVE = "-r";

    public ListCommandFactory() {
        super(CommandName.LS);
    }

    @Override
    public Command create(String... arguments) {
        if (arguments.length == 0) {
            return new ListCommand(false);
        }

        if (arguments.length > 1 || !arguments[0].equals(ARGUMENT_RECURSIVE)) {
            return invalidCommand();
        }

        return new ListCommand(true);
    }
}
