package junit;
import duke.tasks.Event;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void testStringCmd() {
        Event testItem = new Event("eventTest", false,"eventTestDate");
        assertEquals("[ ]&E&eventTest&eventTestDate", testItem.getStringCmd(), "getStringCmd() works as intended");
    }

    @Test
    public void testGetDateTime() {
        Event testItem = new Event("eventTest", false,"eventTestDate");
        assertEquals("(at:eventTestDate)", testItem.getDateTime(), "getDateTime() works as intended");
    }

    @Test
    public void testToString() {
        Event testItem = new Event("eventTest", false, "eventTestDate");
        assertEquals("[E][ ]eventTest(at:eventTestDate)", testItem.toString(), "toString() works as intended");
    }
}
