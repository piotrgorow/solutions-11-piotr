package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrapezoidTest {

    @ParameterizedTest
    @MethodSource("parameters")
    public void shouldCalculateAreaOfTrapezoid(double sideA, double sideB, double h, double expected) {
        //given
        Trapezoid trapezoid = new Trapezoid(sideA, sideB, h);

        //when
        double result = trapezoid.calculateArea();

        //then
        assertEquals(expected, result);
        assertEquals("Trapezoid", trapezoid.toString());
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(5.0, 5.0, 5.0, 25.0),
                Arguments.of(0.0, 5.0, 5.0, 12.5),
                Arguments.of(5.0, 0.0, 5.0, 12.5),
                Arguments.of(5.0, 5.0, 0.0, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(double argument) {
        Trapezoid trapezoid = new Trapezoid();
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(argument, 0.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(0.0, argument, 0.0));
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(0.0, 0.0, argument));
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setSideA(argument));
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setSideB(argument));
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setH(argument));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
