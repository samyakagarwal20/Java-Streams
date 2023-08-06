package stream.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OperationsMain {
    public static void main(String[] args) {

        /**
         * A Stream pipeline consists of a data source, followed by intermediate operations and further ended by a terminal operation
         * -
         * An intermediate operation is the one which returns a new Stream
         * -
         * A terminal operation is the one which consumes all the elements of the stream, thereby, marking the closing of a stream
         * -
         * Once all the elements of the stream are processed by a terminal operation, we can't reuse that stream
         */

        /**
         * The following are some of the terminal operations : anyMath(), allMatch(), noneMatch(), min(), max(), reduce(),
         * foreach(), findFirst(), findAny(), count(), collect(), toArray()
         */

        List<String> fruits = Arrays.asList("mango fruit","apple fruit ","banana fruit","melon fruit","guava fruit","orange fruit");

        /**
         * anyMatch()
         * returns true if Predicate is true for any of the stream element else false
         */
        boolean anyMatch = fruits.stream().anyMatch(val -> {
            return val.contains("guava");
        });
        System.out.println("result of anyMatch() operation : " + anyMatch);

        /**
         * allMatch()
         * returns true if Predicate is true for all the stream element else false
         */
        boolean allMatch = fruits.stream().allMatch(val -> {
            return val.contains("fruit");
        });
        System.out.println("result of allMatch() operation : " + allMatch);

        /**
         * noneMatch()
         * return true if Predicate if false for all the stream elements else false
         */
        boolean noneMatch = fruits.stream().noneMatch(val -> {
            return val.contains("spinach");
        });
        System.out.println("result of noneMatch() operation : " + noneMatch);

        /**
         * count()
         * returns a long datatype representing the count of elements in the stream
         * its execution depends on the type of intermediate operation may or may not be used in the pipeline
         */
        long streamSize = fruits.stream().count();
        System.out.println("result of count() without intermediate operations : " + streamSize);

        streamSize = fruits.stream().map(val -> val.toUpperCase()).count();
        System.out.println("result of count() with map() intermediate operations : " + streamSize);


        streamSize = fruits.stream().filter(val -> val.startsWith("m")).count();
        System.out.println("result of count() with map() intermediate operations : " + streamSize);

    }
}
