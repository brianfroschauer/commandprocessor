package commandprocessor.command.output;

import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class CommandOutputImpl implements CommandOutput {

    private final File file;
    private final List<String> output;

    public CommandOutputImpl(final @NotNull File file,
                             final String... output) {
        this.file = file;
        this.output = Arrays.asList(output);
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public List<String> getOutput() {
        return output;
    }
}
