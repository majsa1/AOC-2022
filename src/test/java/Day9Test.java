import org.example.day9.Day9;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.absExact;

public class Day9Test {
    private static final String EXAMPLE_INPUT_SMALL =
            """
                R 4
                U 4
                L 3
                D 1
                R 4
                D 1
                L 5
                R 2
                    """;
    private static final String EXAMPLE_INPUT_LARGE =
            """
                R 5
                U 8
                L 8
                D 3
                R 17
                D 10
                L 25
                U 20
                """;

    private static final String EXAMPLE_INPUT_RANDOM =
            """
                R 17
                R 9
                L 16
                L 1
                U 4
                L 23
                D 9
                U 1
                R 7
                """;

    @Test
    public void testNumberOfVisitedWithTwoKnotsAndSmallInput() {
        Day9 day9 = new Day9(EXAMPLE_INPUT_SMALL, 2);
        Assert.assertEquals(13, day9.getNumberOfVisitedPositions());
    }

    @Test
    public void testNumberOfVisitedWithTwoKnotsAndLargeInput() {
        Day9 day9 = new Day9(EXAMPLE_INPUT_LARGE, 2);
        Assert.assertEquals(88, day9.getNumberOfVisitedPositions());
    }

    @Test
    public void testNumberOfVisitedWithTenKnotsAndSmallInput() {
        Day9 day9 = new Day9(EXAMPLE_INPUT_SMALL, 10);
        Assert.assertEquals(1, day9.getNumberOfVisitedPositions());
    }

    @Test
    public void testNumberOfVisitedWithTenKnotsAndLargeInput() {
        Day9 day9 = new Day9(EXAMPLE_INPUT_LARGE, 10);
        Assert.assertEquals(36, day9.getNumberOfVisitedPositions());
    }

    @Test
    public void testIsAdjacentWithTenKnotsAndLargeInput() {
        Day9 day9 = new Day9(EXAMPLE_INPUT_SMALL, 10);

        int amountOfNotAdjacent = 0;
        for (int i = 1; i < day9.getVisited().size(); i++) {
            if (day9.getVisited().get(i).getX() - day9.getVisited().get(i - 1).getX() > absExact(1)
                    || day9.getVisited().get(i).getY() - day9.getVisited().get(i -1).getY() > absExact(1)) {
                amountOfNotAdjacent++;
            }
        }

        Assert.assertEquals(0, amountOfNotAdjacent);
    }

    @Test
    public void testIsAdjacentWithTenKnotsAndRandomInput() {
        Day9 day9 = new Day9(EXAMPLE_INPUT_RANDOM, 10);

        int amountOfNotAdjacent = 0;
        for (int i = 1; i < day9.getVisited().size(); i++) {
            if (day9.getVisited().get(i).getX() - day9.getVisited().get(i - 1).getX() > absExact(1)
                    || day9.getVisited().get(i).getY() - day9.getVisited().get(i -1).getY() > absExact(1)) {
                amountOfNotAdjacent++;
            }
        }
        Assert.assertEquals(0, amountOfNotAdjacent);
    }

    @Test
    public void testIsAdjacentWithDay9InputTwoKnots() {
        Day9 day9 = new Day9(2);

        int amountOfNotAdjacent = 0;
        for (int i = 1; i < day9.getVisited().size(); i++) {
            if (day9.getVisited().get(i).getX() - day9.getVisited().get(i - 1).getX() > absExact(1)
                    || day9.getVisited().get(i).getY() - day9.getVisited().get(i -1).getY() > absExact(1)) {
                amountOfNotAdjacent++;
            }
        }
        Assert.assertEquals(0, amountOfNotAdjacent);
    }

    @Test
    public void testIsAdjacentWithDay9InputTenKnots() {
        Day9 day9 = new Day9(10);

        int amountOfNotAdjacent = 0;
        for (int i = 1; i < day9.getVisited().size(); i++) {
            if (day9.getVisited().get(i).getX() - day9.getVisited().get(i - 1).getX() > absExact(1)
                    || day9.getVisited().get(i).getY() - day9.getVisited().get(i -1).getY() > absExact(1)) {
                amountOfNotAdjacent++;
            }
        }
        Assert.assertEquals(0, amountOfNotAdjacent);
    }

    @Test
    public void testNumberOfVisitedWithDay9InputTwoKnots() {
        Day9 day9 = new Day9(2);
        Assert.assertEquals(6037, day9.getNumberOfVisitedPositions());
    }

    @Test
    public void testNumberOfVisitedWithDay9Input() {
        Day9 day9 = new Day9(10);
        Assert.assertEquals(2485, day9.getNumberOfVisitedPositions());
    }
}
