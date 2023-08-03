package stream.creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreationMain {

    public static void main(String[] args) throws IOException {

        /**
          Creating an empty stream
          It is to avoid returning null for streams with no element.
         */
        Stream<String> emptyStringStream = Stream.empty();

        /**
         * Creating stream from a collection
         * For this purpose, a stream() method is added in the Collection interface
         */
        List<String> himymList = Arrays.asList("Ted","Marshal","Barney");
        System.out.print("Stream of himym characters : ");
        himymList.stream().forEach(s -> System.out.print(s + " "));

        /**
         * Creating stream using Stream.builder().build()
         * When builder is used, the desired type should be additionally specified in the right part of the statement
         * otherwise the build() method will create an instance of Stream<Object>
         */
        Stream<String> onePieceStream = Stream.<String>builder().add("Luffy").add("Zoro").add("Sanji").build();
        System.out.print("\nStream of one piece characters : ");
        onePieceStream.forEach(s -> System.out.print(s + " "));

        /**
         * Creating an infinite stream
         * This can be done using various methods like - generate(), iterate(), etc.
         * They can create the infinite streams (until it reaches the memory limit)
         * To prevent it, we always specify the desired size using the limit() method
         */
        Stream<String> infiniteStream = Stream.generate(() -> "element").limit(10);
        System.out.print("\nInfinite stream (with limit 10) : ");
        infiniteStream.forEach(s -> System.out.print(s + " "));

        /**
         * Creating stream of chars from string
         */
        IntStream streamOfChars = "abcdefghijklmnopqrstuvwxyz".chars();
        System.out.print("\nStream of chars for abcdefghijklmnopqrstuvwxyz : ");
        streamOfChars.forEach(s -> System.out.print((char) s + " "));

        /**
         * Creating stream of sub-strings from a string based on regex
         */
        Stream<String> stringStream1 = Pattern.compile(", ").splitAsStream("a, b, c");
        System.out.print("\nStream of sub-string from string (\"a, b, c\") : ");
        stringStream1.forEach(s -> System.out.print( s + " "));

        /**
         * Creating stream from a file
         * It is done using Files.lines() method which returns each line of the file as an element of the stream
         */
        try {
            Path path = Paths.get("stream/creation/testFile.txt");
            Stream<String> streamFromFile = Files.lines(path);
            List<String> fileDataLines = new ArrayList<>();
            streamFromFile.forEach(fileDataLines::add);
            System.out.println("\nData from file : " + fileDataLines);
        } catch (Exception e) {
            System.out.println("Exception occurred while creating a stream from file : " + e.getMessage());
        }
    }

}
