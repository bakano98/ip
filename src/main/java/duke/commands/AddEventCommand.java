package duke.commands;

import java.io.IOException;

import duke.tasks.Event;
import duke.main.DukeException;
import duke.main.TaskList;
import duke.main.Parser;
import duke.main.Storage;

/**
 * AddEventCommand is a Command.
 * This Command is used to add Events to the TaskList.
 */
public class AddEventCommand extends Command<String> {
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
    public AddEventCommand(TaskList toDoList, String cmd, Storage storage) throws DukeException {
        this.storage = storage;
        this.runCommand(toDoList, cmd);
    }

    /**
     * Adds a new Event Task to the current TaskList
     *
     * @param toDoList the user's List of Tasks
     * @param cmd      the user input to Burp
     * @throws DukeException if no Task description is given
     */
    public void runCommand(TaskList toDoList, String cmd) throws DukeException {
        try {
            String[] eventDetails = cmd.split("event")[1].split("/at");
            String eventName = eventDetails[0];
            String eventDateTime = eventDetails[1];
            Event newEvent = new Event(eventName, false, eventDateTime);
            toDoList.add(newEvent);
            System.out.println(Parser.formatMsg("Got it. I've added this task:\n\t" + newEvent + "\n\tNow you have " + toDoList.size() + " tasks in the list."));
            storage.writeFileContent(toDoList);

        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Parser.formatMsg("☹ OOPS!!! The description of an event cannot be empty."));
        } catch (IOException e) {
            throw new DukeException(Parser.formatMsg("IOException caught") + e);
        }
    }

    ;
}
