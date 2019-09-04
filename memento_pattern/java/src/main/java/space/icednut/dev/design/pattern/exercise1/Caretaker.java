package space.icednut.dev.design.pattern.exercise1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author will.109
 * @date 01/09/2019
 **/
public class Caretaker {
    public static void main(String[] args) {
        final LinkedList<Memento> savedStates = new LinkedList<>();
        final Originator originator = new Originator();

        originator.setState("State1");
        originator.setState("State2");
        savedStates.add(originator.saveToMemento());
        originator.setState("State3");
        savedStates.add(originator.saveToMemento());
        originator.setState("State4");
        originator.restoreFromMemento(savedStates.removeLast());
        originator.restoreFromMemento(savedStates.removeLast());
    }
}
