package commandprocessor.file;

import java.util.List;

public interface File {

    /**
     * @return the name of the file or directory or the empty string if this name is empty.
     */
    String getName();

    /**
     * @return the path of the file or directory. The resulting string uses the default name-separator character to
     * separate the names in the name sequence.
     */
    String getPath();

    /**
     * @return the absolute path of the file or directory.
     */
    String getAbsolutePath();

    /**
     * @return the parent file, or null if the file does not have a parent.
     */
    File getParent();

    /**
     * Set the provided {@param file} as a parent file.
     */
    void setParent(File file);

    /**
     * @return a boolean indicating if the file is a directory or not.
     */
    boolean isDirectory();

    /**
     * @return the subdirectories of the file.
     */
    List<File> getSubdirectories();

    /**
     * Add a subdirectory file to the current file.
     *
     * @param file the file to be added as subdirectory.
     */
    void addSubdirectory(File file);
}
