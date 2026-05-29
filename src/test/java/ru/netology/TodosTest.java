package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchShouldFindSimpleTaskByTitle() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        Todos todos = new Todos();
        todos.add(task);

        Task[] result = todos.search("молоко");
        Task[] expected = {task};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void searchShouldFindEpicBySubtask() {
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Todos todos = new Todos();
        todos.add(epic);

        Task[] result = todos.search("хлеб");
        Task[] expected = {epic};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void searchShouldFindMeetingByTopic() {
        Meeting meeting = new Meeting(3, "Планёрка", "Нетология", "10:00");
        Todos todos = new Todos();
        todos.add(meeting);

        Task[] result = todos.search("Планёрка");
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void searchShouldFindMeetingByProject() {
        Meeting meeting = new Meeting(4, "Обсуждение", "Нетология", "11:00");
        Todos todos = new Todos();
        todos.add(meeting);

        Task[] result = todos.search("Нетология");
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void searchShouldReturnEmptyIfNoMatch() {
        SimpleTask task = new SimpleTask(5, "Уборка");
        Todos todos = new Todos();
        todos.add(task);

        Task[] result = todos.search("несуществующий");
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }
}