package commandprocessor.configuration;

import commandprocessor.command.factory.strategy.CommandFactoryStrategy;
import commandprocessor.command.processor.CommandProcessor;
import commandprocessor.file.File;

/**
 * Default configuration for the command processor.
 */
public interface CommandProcessorConfiguration {

    /**
     * @return the command factory strategy for the command processor.
     */
    CommandFactoryStrategy getCommandFactoryStrategy();

    /**
     * @return the command processor.
     */
    CommandProcessor getCommandProcessor();

    /**
     * @return the root file for the command processor.
     */
    File getFile();
}
