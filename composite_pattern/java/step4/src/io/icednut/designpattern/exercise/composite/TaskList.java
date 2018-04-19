package io.icednut.designpattern.exercise.composite;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 3. 27.
 */
public class TaskList extends Task {

    public TaskList(String title) {
        super(title, null);
    }

    @Override
    protected Task getResultComposite(Task.SortAction sortAction, boolean stateGroup) {
        return new TaskItem(this.title, this.date);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public void toggle() {

    }

    @Override
    public int sortTitle(Task task) {
        return 0;
    }

    @Override
    public int sortDate(Task task) {
        return 0;
    }

    public TaskWrapper byTitle(boolean stateGroup) {
        return this.getResult(SortAction.TITLE, stateGroup);
    }

    public TaskWrapper byDate(boolean stateGroup) {
        return this.getResult(SortAction.DATE, stateGroup);
    }
}
