package Lesson6_Testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainClassTest {

    private MainClass mainClass;

    @BeforeEach
    public void init() {
        mainClass = new MainClass();
    }

    @Test
    public void testRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            int[] arr = mainClass.getAfter4Array(new int[] { 1, 2, 3, 3, 5, 6});
        });
    }

    @ParameterizedTest
    @MethodSource("dataForAfter4Array")
    public void testAfter4Array(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, mainClass.getAfter4Array(array));
    }

    public static Stream<Arguments> dataForAfter4Array() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] {5, 6}));
        out.add(Arguments.arguments(new int[] { 2, 4, 2, 2 }, new int[] { 2, 2 }));
        out.add(Arguments.arguments(new int[] { 1, 1, 4, 2, 2, 4, 3, 3 }, new int[] { 3, 3 }));
        out.add(Arguments.arguments(new int[] { 1, 2, 3, 4 }, new int[0]));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataFor1and4Array")
    public void test1and4Array(int[] array, boolean result) {
        Assertions.assertEquals(result, mainClass.has1and4Array(array));
    }

    public static Stream<Arguments> dataFor1and4Array() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] { 1, 4, 1, 4 }, true));
        out.add(Arguments.arguments(new int[] { 4, 1, 4, 1 }, true));
        out.add(Arguments.arguments(new int[] { 1, 1, 4, 4 }, true));
        out.add(Arguments.arguments(new int[] { 4, 4, 1, 1 }, true));
        out.add(Arguments.arguments(new int[] { 1, 1, 1, 4 }, true));
        out.add(Arguments.arguments(new int[] { 1, 4, 4, 4 }, true));
        out.add(Arguments.arguments(new int[] { 1, 2, 1, 4 }, false));
        out.add(Arguments.arguments(new int[] { 1, 1, 1, 1 }, false));
        return out.stream();
    }

}
