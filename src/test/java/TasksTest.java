import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("родителям");

        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("другу");

        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Яйца");

        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Сыр");

        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Приложение");

        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("обеда");

        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
