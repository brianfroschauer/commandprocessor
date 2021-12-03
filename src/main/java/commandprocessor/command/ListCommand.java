package commandprocessor.command;

import commandprocessor.command.name.CommandName;
import commandprocessor.command.output.CommandOutput;
import commandprocessor.command.output.CommandOutputImpl;
import commandprocessor.file.File;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This command lists the contents (directories and files) of current directory.
 * It writes a single item per line. If there are no items, print nothing.
 * <p>
 * Parameters:
 * [-r] if provided, prints everything in the current directory and all subdirectories.
 */
public class ListCommand extends AbstractCommand {

    /**
     * If it is true, prints everything in the current directory and all subdirectories.
     */
    private final boolean recursive;

    public ListCommand(final boolean recursive) {
        super(CommandName.LS);
        this.recursive = recursive;
    }

    @Override
    public CommandOutput execute(final @NotNull File file) {
        final List<String> directories = new ArrayList<>();

        if (recursive) {
            listRecursive(directories, file);
        } else {
            list(directories, file);
        }

        // Convert the result list as a string array
        final String[] output = new String[directories.size()];
        directories.toArray(output);

        return new CommandOutputImpl(file, output);
    }

    /**
     * Adds to the directories list everything in the current directory and all subdirectories.
     *
     * @param directories the list of all directories and subdirectories.
     * @param file        the file to be traversed.
     */
    private void listRecursive(final @NotNull List<String> directories, final @NotNull File file) {
        directories.add(file.isDirectory() ? file.getAbsolutePath() : file.getName());
        file.getSubdirectories().forEach(subdirectory -> listRecursive(directories, subdirectory));
    }

    /**
     * Adds to the directories list the contents of current directory.
     *
     * @param directories the list of all subdirectories.
     * @param file        the file to be traversed.
     */
    private void list(final @NotNull List<String> directories, final @NotNull File file) {
        directories.add(file.getAbsolutePath());
        file.getSubdirectories().forEach(subdirectory -> directories.add(subdirectory.getPath()));
    }
}
