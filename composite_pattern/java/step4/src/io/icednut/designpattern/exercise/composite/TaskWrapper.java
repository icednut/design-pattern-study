package io.icednut.designpattern.exercise.composite;

import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @created 19/04/2018
 */
public class TaskWrapper {
    private TaskWrapper item;
    private List<TaskWrapper> children;

    public TaskWrapper() {
    }

    public TaskWrapper(Task task, List<TaskWrapper> children) {
        this.item = task;
        this.children = children;
    }

    public TaskWrapper getItem() {
        return item;
    }

    public List<TaskWrapper> getChildren() {
        return children;
    }
}
