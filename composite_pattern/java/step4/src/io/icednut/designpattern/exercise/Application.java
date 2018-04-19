package io.icednut.designpattern.exercise;

import io.icednut.designpattern.exercise.composite.Task;
import io.icednut.designpattern.exercise.composite.TaskItem;
import io.icednut.designpattern.exercise.composite.TaskList;
import io.icednut.designpattern.exercise.composite.TaskWrapper;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 3. 27.
 */
public class Application {
    public static void main(String[] args) {
        TaskList list1 = new TaskList("s75");
        TaskItem item1 = new TaskItem("3강교안작성", null);
        list1.add(item1);

        TaskItem sub1 = new TaskItem("코드정리", null);
        item1.add(sub1);

        TaskItem subsub1 = new TaskItem("subsub1", null);
        sub1.add(subsub1);

        TaskWrapper result = list1.getResult(Task.SortAction.TITLE, true);
        System.out.println(result);
    }
}