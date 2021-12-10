package commandprocessor.command.configuration;

import commandprocessor.command.factory.*;
import commandprocessor.command.factory.strategy.CommandFactoryStrategy;
import commandprocessor.command.factory.strategy.CommandFactoryStrategyImpl;
import commandprocessor.command.processor.CommandProcessor;
import commandprocessor.command.processor.CommandProcessorImpl;
import commandprocessor.file.File;
import commandprocessor.file.FileImpl;

public class DefaultCommandProcessorConfiguration implements CommandProcessorConfiguration {

    @Override
    public CommandFactoryStrategy getCommandFactoryStrategy() {
        return new CommandFactoryStrategyImpl(
                new ChangeDirectoryCommandFactory(),
                new CreateFileCommandFactory(),
                new CurrentDirectoryCommandFactory(),
                new ListCommandFactory(),
                new MakeDirectoryCommandFactory(),
                new QuitCommandFactory()
        );
    }

    @Override
    public CommandProcessor getCommandProcessor() {
        return new CommandProcessorImpl();
    }

    @Override
    public File getFile() {
        return new FileImpl("root", true);
    }
}
