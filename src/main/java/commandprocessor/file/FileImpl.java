package commandprocessor.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class FileImpl implements File {

    private final String name;
    private File parent;
    private final List<File> subdirectories;
    private final boolean isDirectory;

    public FileImpl(String name, boolean isDirectory) {
        this.parent = null;
        this.name = name;
        this.subdirectories = new ArrayList<>();
        this.isDirectory = isDirectory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return isDirectory ? String.format("/%s", name) : name;
    }

    @Override
    public String getAbsolutePath() {
        final Stack<String> fileNames = new Stack<>();

        File current = this;

        while (!Objects.isNull(current)) {
            fileNames.push(current.getPath());
            current = current.getParent();
        }

        String output = "";

        while (!fileNames.isEmpty()) {
            output = output.concat(fileNames.pop());
        }

        return output;
    }

    @Override
    public File getParent() {
        return parent;
    }

    @Override
    public void setParent(final File file) {
        this.parent = file;
    }

    @Override
    public boolean isDirectory() {
        return isDirectory;
    }

    @Override
    public List<File> getSubdirectories() {
        return subdirectories;
    }

    @Override
    public void addSubdirectory(final File file) {
        subdirectories.add(file);
        file.setParent(this);
    }
}
