package commandprocessor.command.output;

import commandprocessor.file.File;

import java.util.List;

/**
 * Represents the output of executing a command.
 */
public interface CommandOutput {

    /**
     * @return the command output result as a list of strings.
     */
    List<String> getOutput();

    /**
     * @return the result file of the command execution.
     */
    File getFile();
}
