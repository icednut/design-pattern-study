package io.icednut.designpattern.exercise;

import io.icednut.designpattern.exercise.composite.*;

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
        TaskItem sub2 = new TaskItem("코드정리2", null);
        item1.add(sub2);
        TaskItem sub3 = new TaskItem("코드정리3", null);
        item1.add(sub3);

        TaskItem subsub1 = new TaskItem("subsub1", null);
        sub1.add(subsub1);

        ConsoleRenderer todo = new ConsoleRenderer(list1);
        todo.render();
    }
}