# Command Processor

Interactive command processor developed for the Salesforce technical challenge.

## Getting Started

> These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

1. [JDK 8 Installation](https://docs.oracle.com/javase/8/docs/technotes/guides/install)

2. [Maven installation](https://maven.apache.org/install.html)

### Usage

1. Clone the Command Processor repository.

```
git clone https://github.com/brianfroschauer/commandprocessor.git
```

2. Change directory to commandprocessor package.

```bash
cd commandprocessor
```

3. Compile the application.

```
mvn compile
```

4. Execute the application.

```
mvn exec:java -Dexec.mainClass=commandprocessor.Main
```

5. Try executing some command like `ls` in the command line.

### Developed commands

##### 1. Change directory

This command changes the current path to a sub-directory (by name).

```
cd <directoryName>
```

##### 2. Create file

This command creates a "file" in the current directory.

```
touch <fileName>
```

##### 3. Current directory

This command print the full path of the current directory.

```
pwd
```

##### 4. List

This command lists the contents (directories and files) of current directory. If recursive parameter is provided, prints
everything in the current directory and all subdirectories.

```
ls
```

List recursive:

```
ls -r
```

##### 5. Make directory

This command creates a directory entry in the cache.

```
mkdir <directoryName>
```

##### 6. Quit

This command interrupt the program.

```
quit
```

## Tests

Run all the unit test classes using maven.

```
mvn test
```

## Design

The main components are described below.

### The command interface

Used as interface for all specific commands. It receives the file as argument in which the command will be executed, and
returns a command output object that contains the result file of the execution and the output logs as a list of strings.

```java

@FunctionalInterface
public interface Command {

    CommandOutput execute(final @NotNull File file);
}
```

### The command processor interface

The command processor knows how to execute all provided commands in the specific provided file.

```java
public interface CommandProcessor {

    List<CommandOutput> execute(final @NotNull File file, final @NotNull List<Command> commands);

    CommandOutput execute(final @NotNull File file, @NotNull final Command command);
}
```

### The command factory interface

The command factory knows how to create a command given the command arguments as an array of strings. It also has a
method that returns the command used as the factory strategy name.

```java
public interface CommandFactory {

    CommandName getCommandName();

    Command create(final String... arguments);
}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* **Brian Froschauer**
