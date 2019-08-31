package space.icednut.dev.design.pattern.exercise2;

import java.io.*;

/**
 * @author will.109
 * @date 27/08/2019
 **/
public class MementoApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        final ObjectOutputStream out = new ObjectOutputStream(bytes);

        Originator instance = new Originator();
        out.writeObject(instance);
        final byte[] memento = bytes.toByteArray();

        final ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(memento));
        instance = (Originator) in.readObject();
    }
}

class Originator implements Serializable {
    int x;
}
