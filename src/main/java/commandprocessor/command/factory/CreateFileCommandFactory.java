package commandprocessor.command.factory;

import commandprocessor.command.Command;
import commandprocessor.command.CreateFileCommand;
import commandprocessor.command.name.CommandName;

import java.util.Objects;

public class CreateFileCommandFactory extends AbstractCommandFactory {

    /**
     * The maximum length of the first parameter (fileName).
     */
    private static final Integer ARGUMENTS_MAX_LENGTH = 100;

    public CreateFileCommandFactory() {
        super(CommandName.TOUCH);
    }

    @Override
    public Command create(String... arguments) {
        return create(1, arguments.length, (() -> {
            final String fileName = arguments[0];

            if (Objects.isNull(fileName) || fileName.length() > ARGUMENTS_MAX_LENGTH) {
                return invalidFile();
            }

            return new CreateFileCommand(fileName);
        }));
    }
}
