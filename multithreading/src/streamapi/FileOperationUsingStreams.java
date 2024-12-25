package streamapi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperationUsingStreams {
    public static void main(String[] args) throws IOException {
        String path = new File("File").getAbsolutePath();
       Stream<String> namesStream= Files.lines(Paths.get(path));
       List<String> names=namesStream.collect(Collectors.toList());
       names.forEach(System.out::println);
       // C/My-Git-Journey/java-concepts/multithreading/src/streamapi/File

    }
}
