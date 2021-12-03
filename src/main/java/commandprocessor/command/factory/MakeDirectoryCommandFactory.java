package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.MakeDirectoryCommand;
import commandprocessor.command.name.CommandName;

import java.util.Objects;

public class MakeDirectoryCommandFactory extends AbstractCommandFactory {

    /**
     * The maximum length of the first parameter (fileName).
     */
    private static final Integer ARGUMENTS_MAX_LENGTH = 100;

    public MakeDirectoryCommandFactory() {
        super(CommandName.MKDIR);
    }

    @Override
    public Command create(String... arguments) {
        return create(1, arguments.length, () -> {
            final String directoryName = arguments[0];

            if (Objects.isNull(directoryName) || directoryName.length() > ARGUMENTS_MAX_LENGTH) {
                return invalidFile();
            }

            return new MakeDirectoryCommand(directoryName);
        });
    }
}
