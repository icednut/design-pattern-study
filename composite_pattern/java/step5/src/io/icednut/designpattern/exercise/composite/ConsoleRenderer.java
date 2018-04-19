package io.icednut.designpattern.exercise.composite;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @created 19/04/2018
 */
public class ConsoleRenderer {
    private TaskList list;
    private Task.SortAction sort;

    public ConsoleRenderer(TaskList taskList) {
        this.list = taskList;
        this.sort = Task.SortAction.TITLE;
    }

    public void render() {
        this.renderComposite(list.getResult(sort, false), 0);
    }

    protected void renderComposite(TaskWrapper result, int depth) {
        List<String> temp = new ArrayList<>();

        TaskWrapper item = result.getItem();

        if (item instanceof TaskList) {
            TaskList taskList = (TaskList) item;
            temp.add(taskList.title);
        } else if (item instanceof TaskItem) {
            TaskItem taskItem = (TaskItem) item;
            String completeStar = taskItem.isComplete() ? "*" : " ";
            temp.add(taskItem.title + " (" + completeStar + ")" + " - " + taskItem.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

        temp.forEach(v -> {
            for (int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            System.out.println(v);
        });

        result.getChildren().forEach(taskWrapper -> {
            this.renderComposite(taskWrapper, depth + 1);
        });
    }
}
