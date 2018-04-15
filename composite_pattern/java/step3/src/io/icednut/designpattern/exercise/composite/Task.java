package io.icednut.designpattern.exercise.composite;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 3. 27.
 */
public abstract class Task {
    protected String title;
    protected LocalDateTime date;
    protected boolean isComplete;
    protected List<Task> list;

    public Task(String title, LocalDateTime date) {
        this.title = Optional.ofNullable(title).orElseThrow(() -> new InvalidTitleException());
        this.date = date;
        this.isComplete = false;
        this.list = new ArrayList<>();
    }

    public void add(Task task) {
        this.list.add(task);
    }

    public void remove(Task task) {
        if (list.contains(task)) {
            list.remove(task);
        }
    }

    public TaskWrapper getResult(Task.SortAction sortAction, boolean stateGroup) {
        Comparator<Task> sortMethod = sortAction::invoke;

        List<Task> sub = !stateGroup ?
                list.stream().sorted(sortMethod).collect(Collectors.toList()) :
                new ArrayList<>() {{
                    addAll(list.stream().filter(v -> !v.isComplete()).sorted(sortMethod).collect(Collectors.toList()));
                    addAll(list.stream().filter(v -> v.isComplete()).sorted(sortMethod).collect(Collectors.toList()));
                }};
        return new TaskWrapper(this.getResultComposite(sortAction, stateGroup), sub);
    }

    protected abstract Task getResultComposite(Task.SortAction sortAction, boolean stateGroup);

    public abstract boolean isComplete();

    public abstract void toggle();

    public abstract int sortTitle(Task task);

    public abstract int sortDate(Task task);

    public static enum SortAction {
        TITLE {
            public int invoke(Task a, Task b) {
                return a.sortTitle(b);
            }
        }, DATE {
            public int invoke(Task a, Task b) {
                return a.sortDate(b);
            }
        };

        public abstract int invoke(Task a, Task b);
    }

    public static class TaskWrapper {
        private final Task task;
        private final List<Task> children;

        public TaskWrapper(Task task, List<Task> children) {
            this.task = task;
            this.children = children;
        }

        public Task getTask() {
            return task;
        }

        public List<Task> getChildren() {
            return children;
        }
    }
}

//class TaskSort {
//    private Map<String, Comparator<Task>> sortMethods;
//
//    public TaskSort() {
//        this.sortMethods = new HashMap<>();
//        sortMethods.put("title", (a, b) -> a.sortTitle(b));
//        sortMethods.put("date", (a, b) -> a.sortDate(b));
//    }
//
//    public Comparator<Task> getSortMethod(String sortType) {
//        return sortMethods.get(sortType);
//    }
//}