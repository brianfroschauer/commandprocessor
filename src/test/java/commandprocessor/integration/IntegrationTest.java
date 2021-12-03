package commandprocessor.integration;

import org.junit.Test;

public class IntegrationTest extends BaseTest {

    @Test
    public void testCd() {
        String[] expectedResults = {
                "Directory not found"
        };
        runTest(expectedResults, "cd ..", "cd abc", "quit");
    }

    @Test
    public void testMkdirAndCd() {
        String[] expectedResults = {
                "Directory already exists",
                "/root/abc"
        };
        runTest(expectedResults, "mkdir abc", "mkdir abc", "cd abc", "pwd", "quit");
    }

    @Test
    public void testLsSimple() {
        String[] expectedResults = {
                "/root",
                "file1",
        };
        runTest(expectedResults, "touch file1", "ls", "quit");
    }

    @Test
    public void testLsMultiLevel() {
        String[] expectedResults = {
                "/root",
                "root-file",
                "/root/sub1",
                "sub1-file",
                "/root/sub1/sub2",
                "sub2-file1",
                "sub2-file2",
                "/root/sub1/sub2/sub3",
                "/root/sub1/sub2/sub3/sub4",
                "sub4-file1",
                "sub4-file2",
                "sub4-file3"
        };
        runTest(expectedResults, "touch root-file", "mkdir sub1", "cd sub1", "touch sub1-file",
                "mkdir sub2", "cd sub2", "touch sub2-file1", "touch sub2-file2", "touch sub2-file2", "mkdir sub3",
                "cd sub3", "mkdir sub4", "cd sub4", "touch sub4-file1", "touch sub4-file2", "touch sub4-file3",
                "cd ..", "cd ..", "cd ..", "cd ..",
                "ls -r", "quit");
    }

    @Test
    public void testCommandErrors() {
        String[] expectedResults = {
                "Unrecognized command",
                "Invalid command",
                "Invalid command",
                "Invalid command"
        };
        runTest(expectedResults, "vi abc", "ls efg", "cd", "quit dummy", "quit");
    }

    @Test
    public void testPathNameTooLong() {
        String[] expectedResults = {
                "Invalid file or folder name",
                "Invalid file or folder name"
        };
        String longName = makeLongName();
        runTest(expectedResults, "mkdir " + longName, "touch " + longName, "quit");
    }

    private String makeLongName() {
        StringBuilder sb = new StringBuilder("name");
        for (int i = 0; i < 100; i++) {
            sb.append("0");
        }

        return sb.toString();
    }
}
