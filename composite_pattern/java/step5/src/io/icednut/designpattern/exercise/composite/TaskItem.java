package io.icednut.designpattern.exercise.composite;

import java.time.LocalDateTime;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 4. 13.
 */
public class TaskItem extends Task {

    protected LocalDateTime date;
    private boolean isComplete;

    public TaskItem(String title, LocalDateTime date) {
        super(title);
        this.date = date == null ? LocalDateTime.now() : date;
        this.isComplete = false;
    }

    @Override
    public boolean isComplete() {
        return this.isComplete;
    }

    public void toggle() {
        this.isComplete = !this.isComplete;
    }

    @Override
    public int sortTitle(Task task) {
        return this.title.compareTo(task.title);
    }

    @Override
    public int sortDate(Task task) {
        if (task instanceof TaskItem) {
            return this.date.compareTo(((TaskItem) task).date);
        }
        return 0;
    }
}
