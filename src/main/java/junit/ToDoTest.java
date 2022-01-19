package junit;
import duke.tasks.ToDo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void testGetStringCmd() {
        ToDo test = new ToDo("todoTest", false);
        assertEquals("[ ]&T&todoTest", test.getStringCmd(), "getStringCmd() works as intended");
    }

    @Test
    public void testToString() {
        ToDo test = new ToDo("toDoTest", false);
        assertEquals("[T][ ]toDoTest", test.toString(), "toString() works as intended");
    }
}
