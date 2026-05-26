package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void simpleTaskMatchesIfTitleContainsQuery() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        Assertions.assertTrue(task.matches("молоко"));
        Assertions.assertFalse(task.matches("хлеб"));
    }

    @Test
    public void epicMatchesIfAnySubtaskContainsQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void meetingMatchesIfTopicContainsQuery() {
        Meeting meeting = new Meeting(3, "Планёрка", "Нетология", "10:00");
        Assertions.assertTrue(meeting.matches("Планёрка"));
        Assertions.assertFalse(meeting.matches("Совещание"));
    }

    @Test
    public void meetingMatchesIfProjectContainsQuery() {
        Meeting meeting = new Meeting(4, "Обсуждение", "Нетология", "11:00");
        Assertions.assertTrue(meeting.matches("Нетология"));
    }
}