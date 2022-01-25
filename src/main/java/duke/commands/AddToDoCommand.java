package duke.commands;

import java.io.IOException;

import duke.main.DukeException;
import duke.main.Parser;
import duke.main.Storage;
import duke.main.TaskList;
import duke.tasks.ToDo;


/**
 * AddToDoCommand is a Command.
 * This Command is used to add ToDos to the TaskList.
 */
public class AddToDoCommand extends Command<String> {
    private final Storage storage;

    /**
     * Constructor for AddEventCommand.
     * When this class is instantiated, it automatically runs runCommand().
     *
     * @param toDoList the user's List of Tasks
     * @param cmd      the user input to Burp
     * @param storage  the textfile used to store history of TaskList
     * @throws DukeException if no Task description is given
     */
    public AddToDoCommand(TaskList toDoList, String cmd, Storage storage) throws DukeException {
        this.storage = storage;
        this.runCommand(toDoList, cmd);
    }

    /**
     * Adds a new ToDo Task to the current TaskList
     *
     * @param toDoList the user's List of Tasks
     * @param cmd      the user input to Burp
     * @throws DukeException if no Task description is given
     */
    public void runCommand(TaskList toDoList, String cmd) throws DukeException {
        try {
            // Create a new ToDo and add to TaskList
            ToDo newToDo = new ToDo(cmd.split("todo")[1], false);
            toDoList.add(newToDo);

            // Print out the formatted message after adding to TaskList
            System.out.println(Parser.formatMsg("Got it. I've added this task:\n\t" + newToDo
                    + "\n\tNow you have " + toDoList.size() + " tasks in the list."));

            // Write the contents of the TaskList to our storage
            storage.writeFileContent(toDoList);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Parser.formatMsg("☹ OOPS!!! The description of a todo cannot be empty."));
        } catch (IOException e) {
            throw new DukeException(Parser.formatMsg("IOException caught") + e);
        }
    }
}
