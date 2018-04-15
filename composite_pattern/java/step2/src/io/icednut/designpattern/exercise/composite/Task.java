package io.icednut.designpattern.exercise.composite;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 3. 27.
 */
public class Task {
    private String title;
    private LocalDateTime date;
    private boolean isComplete;
    private List<Task> list;

    public Task(String title, LocalDateTime date) {
        this.title = Optional.ofNullable(title).orElseThrow(() -> new InvalidTitleException());
        this.date = date;
        this.isComplete = false;
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

    public TaskWrapper getList(String sortType, boolean stateGroup) {
        TaskSort taskSort = new TaskSort();
        Comparator<Task> sortMethod = taskSort.getSortMethod(sortType);

        List<Task> sub = !stateGroup ?
                list.stream().sorted(sortMethod).collect(Collectors.toList()) :
                new ArrayList<>() {{
                    addAll(list.stream().filter(v -> !v.isComplete()).sorted(sortMethod).collect(Collectors.toList()));
                    addAll(list.stream().filter(v -> v.isComplete()).sorted(sortMethod).collect(Collectors.toList()));
                }};
        return new TaskWrapper(this, sub);
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void toggle() {
        this.isComplete = !this.isComplete;
    }

    public int sortTitle(Task task) {
        return this.title.compareTo(task.title);
    }

    public int sortDate(Task task) {
        return this.date.compareTo(task.date);
    }

    public static class TaskWrapper {
        private final Task task;
        private final List<Task> sub;

        public TaskWrapper(Task task, List<Task> sub) {
            this.task = task;
            this.sub = sub;
        }

        public Task getTask() {
            return task;
        }

        public List<Task> getSub() {
            return sub;
        }
    }
}

class TaskSort {
    private Map<String, Comparator<Task>> sortMethods;

    public TaskSort() {
        this.sortMethods = new HashMap<>();
        sortMethods.put("title", (a, b) -> a.sortTitle(b));
        sortMethods.put("date", (a, b) -> a.sortDate(b));
    }

    public Comparator<Task> getSortMethod(String sortType) {
        return sortMethods.get(sortType);
    }
}