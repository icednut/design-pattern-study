package space.icednut.dev.design.pattern.exercise1;

/**
 * @author will.109
 * @date 01/09/2019
 **/
public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getSavedMemento() {
        return state;
    }
}
