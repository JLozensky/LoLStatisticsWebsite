package lol.tools;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PathReader {
  public List<File> pathReader(final String pathToFolder) throws IOException {
    return Files.walk(Paths.get(pathToFolder))
            .filter(Files::isRegularFile)
            .map(Path::toFile)
            .collect(Collectors.toList());
  }
}
