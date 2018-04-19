package io.icednut.designpattern.exercise;

import io.icednut.designpattern.exercise.composite.TaskList;

/**
 * @author wangeun.lee@sk.com
 * @created 2018. 3. 27.
 */
public class Application {
    public static void main(String[] args) {
        TaskList list1 = new TaskList("비사이드");
        list1.add("지라설치");
        list1.add("지라클라우드 접속");

        TaskList list2 = new TaskList("s75");
        list2.add("2강 답안 작성");
        list2.add("3강 교안 작성");

        System.out.println(list1.byTitle(false));
        System.out.println(list2.byDate(false));
    }
}