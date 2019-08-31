package space.icednut.dev.design.pattern.exercise1;

/**
 * @author will.109
 * @date 27/08/2019
 **/
public class Originator {

    private String state;
    private int more;

    public Object getMemento() {
        return new Memento();
    }

    public void restore(Object o) {
        Memento m = (Memento) o;

        state = m.state;
        more = m.more;
    }

    private class Memento {
        private String state = Originator.this.state;
        private int more = Originator.this.more;

        public String toString() {
            return state + ", " + more;
        }
    }
}

class Caretaker {

    Object memento;
    Originator originator;

    public void captureState() {
        memento = originator.getMemento();
    }

    public void restoreYourself() {
        originator.restore(memento);
    }
}
