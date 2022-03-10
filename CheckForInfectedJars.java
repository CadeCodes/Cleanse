import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
    {
        try (Stream<Path> walk = Files.walk(Paths.get(System.getenv("APPDATA")))) {

            List<String> result = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".jar")).collect(Collectors.toList());

          //  result.forEach(System.out::println);
            for (String jar : result)
            {
                File jarFile = new File(jar);
                JarFile a = new JarFile(jarFile);
                JarEntry entry = a.getJarEntry("OgreBeard.class");
                if (entry != null)
                    System.out.println(jar + " : " + entry.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
