package io.icednut.designpattern.exercise.composite;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 3. 27.
 */
public class TaskList {
    private String title;
    private List<Task> list;

    public TaskList(String title) {
        this.title = title;
        this.list = new ArrayList<>();
    }

    public void add(String title, LocalDateTime date) {
        this.list.add(new Task(title, date));
    }

    public void add(String title) {
        add(title, LocalDateTime.now());
    }

    public void remove(Task task) {
        if (list.contains(task)) {
            list.remove(task);
        }
    }

    public List<Task.TaskWrapper> byTitle(boolean stateGroup) {
        return this.getList("title", stateGroup);
    }

    public List<Task.TaskWrapper> byDate(boolean stateGroup) {
        return this.getList("date", stateGroup);
    }

    private List<Task.TaskWrapper> getList(String sort, boolean stateGroup) {
        TaskSort taskSort = new TaskSort();
        Comparator<Task> sortMethod = taskSort.getSortMethod(sort);

        List<Task> tasks = new ArrayList<>();
        tasks.addAll(list.stream().filter(v -> !v.isComplete()).sorted(sortMethod).collect(Collectors.toList()));
        tasks.addAll(list.stream().filter(v -> v.isComplete()).sorted(sortMethod).collect(Collectors.toList()));

        return !stateGroup ?
                list.stream().sorted(sortMethod).map((Task v) -> v.getList(sort, stateGroup)).collect(Collectors.toList()) :
                tasks.stream().map((Task v1) -> v1.getList(sort, stateGroup)).collect(Collectors.toList());
    }
}
