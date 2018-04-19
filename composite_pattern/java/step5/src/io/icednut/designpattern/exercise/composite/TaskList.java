package io.icednut.designpattern.exercise.composite;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 3. 27.
 */
public class TaskList extends Task {

    public TaskList(String title) {
        super(title);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public int sortTitle(Task task) {
        return 0;
    }

    @Override
    public int sortDate(Task task) {
        return 0;
    }
}
