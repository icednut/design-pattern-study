package space.icednut.dev.design.pattern;

import java.util.LinkedList;

/**
 * @author will.109
 * @date 27/08/2019
 **/
public class TextEditor {

    private Cursor current = new Cursor() {
        @Override
        public Object clone() {
            return null;
        }

        @Override
        public char characterAt() {
            return 0;
        }

        @Override
        public void deleteCharacterAt() {
        }

        @Override
        public void insertCharacterAt(char newCharacter) {
        }

        @Override
        public void moveTo(Cursor newPosition) {
        }

        @Override
        public void moveRight() {
        }
    };
    private LinkedList<Action> undoStack = new LinkedList<>();
    private LinkedList<Action> redoStack = new LinkedList<>();

    public void insertCharacter(char c) {
        process(new InsertAction(c));
    }

    public void deleteCharacter() {
        process(new DeleteAction());
    }

    public void undo() {
        Action action = (Action) undoStack.removeFirst();
        action.undoIt();
        redoStack.addFirst(action);
    }

    public void redo() {
        Action action = (Action) redoStack.removeFirst();
        action.doIt();
        undoStack.addFirst(action);
    }

    private void process(Action command) {
        command.doIt();
        undoStack.addFirst(command);
    }

    private interface Action {
        void doIt();

        void undoIt();
    }

    private class InsertAction implements Action {
        Cursor where = (Cursor) current.clone();
        char inserted;

        public InsertAction(char newCharacter) {
            inserted = newCharacter;
        }

        public void doIt() {
            current.moveTo(where);
            current.insertCharacterAt(inserted);
            current.moveRight();
        }

        public void undoIt() {
            current.moveTo(where);
            current.deleteCharacterAt();
        }
    }

    private class DeleteAction implements Action {
        Cursor where = (Cursor) current.clone();
        char deleted;

        public void doIt() {
            current.moveTo(where);
            deleted = current.characterAt();
            current.deleteCharacterAt();
        }

        public void undoIt() {
            current.moveTo(where);
            current.insertCharacterAt(deleted);
            current.moveRight();
        }
    }
}
