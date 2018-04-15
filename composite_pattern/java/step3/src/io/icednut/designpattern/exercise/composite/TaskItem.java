package io.icednut.designpattern.exercise.composite;

import java.time.LocalDateTime;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 4. 13.
 */
public class TaskItem extends Task {

    public TaskItem(String title, LocalDateTime date) {
        super(title, date == null ? LocalDateTime.now() : date);
        this.isComplete = false;
    }

    @Override
    protected Task getResultComposite(Task.SortAction sortAction, boolean stateGroup) {
        return this;
    }

    @Override
    public boolean isComplete() {
        return this.isComplete;
    }

    @Override
    public void toggle() {
        this.isComplete = !this.isComplete;
    }

    @Override
    public int sortTitle(Task task) {
        return this.title.compareTo(task.title);
    }

    @Override
    public int sortDate(Task task) {
        return this.date.compareTo(task.date);
    }
}
