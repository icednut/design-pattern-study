package space.icednut.dev.design.pattern.exercise1;

/**
 * @author will.109
 * @date 01/09/2019
 **/
public class Originator {

    private String state;

    public void setState(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void restoreFromMemento(Memento memento) {
        state = memento.getSavedMemento();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}
