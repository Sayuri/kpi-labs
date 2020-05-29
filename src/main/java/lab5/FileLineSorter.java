package lab5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLineSorter {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get(FileLineSorter.class.getResource("../sorterTestData.txt").getFile());
        Path outputFile = Paths.get(inputFile.getParent().toAbsolutePath().toString(), "sorterTestOutput.txt");
        System.out.println(outputFile);
        try (Stream<String> stream = Files.lines(inputFile)) {
            List<String> result = stream.sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
            Files.write(outputFile, result);
        }
    }
}
