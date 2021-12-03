package commandprocessor.command.name;

import org.jetbrains.annotations.NotNull;

/**
 * Contains all command names for this command processor.
 */
public enum CommandName {

    QUIT("quit"),
    PWD("pwd"),
    LS("ls"),
    MKDIR("mkdir"),
    CD("cd"),
    TOUCH("touch"),
    UNRECOGNIZED("unrecognized");

    private final String name;

    CommandName(final @NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
