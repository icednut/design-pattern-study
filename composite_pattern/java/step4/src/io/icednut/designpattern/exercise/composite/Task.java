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
public abstract class Task extends TaskWrapper {
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
        List<TaskWrapper> sub;

        if (!stateGroup) {
            sub = list.stream()
                    .sorted(sortMethod)
                    .map(each -> each.getResult(sortAction, stateGroup))
                    .collect(Collectors.toList());
        } else {
            sub = new ArrayList<>();
            sub.addAll(list.stream()
                    .filter(v -> !v.isComplete())
                    .sorted(sortMethod)
                    .map(each -> each.getResult(sortAction, stateGroup))
                    .collect(Collectors.toList()));
            sub.addAll(list.stream()
                    .filter(v -> v.isComplete())
                    .sorted(sortMethod)
                    .map(each -> each.getResult(sortAction, stateGroup))
                    .collect(Collectors.toList()));
        }
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
}
