import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // Given
        String input = hamletParser.getHamletData();

        // When
        String actual = hamletParser.changeHamletToLeon(input);

        // Then
        Assert.assertFalse(actual.contains("Hamlet"));
        Assert.assertFalse(actual.contains("HAMLET"));
        Assert.assertFalse(actual.contains("hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        String input = hamletParser.getHamletData();

        // When
        String actual = hamletParser.changeHoratrioToTariq(input);

        // Then
        Assert.assertFalse(actual.contains("Horatio"));
        Assert.assertFalse(actual.contains("HORATIO"));
        Assert.assertFalse(actual.contains("horatio"));
    }

    @Test
    public void testFindHoratio() {
        // Given

        // When
        int actual = hamletParser.findHoratio();

        // Then
        Assert.assertEquals(158, actual);
    }

    @Test
    public void testFindHamlet() {
        // Given

        // When
        int actual = hamletParser.findHamlet();

        // Then
        Assert.assertEquals(472, actual);

    }
}