package space.icednut.dev.design.pattern;

/**
 * @author will.109
 * @date 27/08/2019
 **/
public abstract class Cursor implements Cloneable {

    public abstract Object clone();

    public abstract char characterAt();

    public abstract void deleteCharacterAt();

    public abstract void insertCharacterAt(char newCharacter);

    public abstract void moveTo(Cursor newPosition);

    public abstract void moveRight();
}
