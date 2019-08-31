package space.icednut.dev.designpattern.mediator.colleage;

import space.icednut.dev.designpattern.mediator.Command;
import space.icednut.dev.designpattern.mediator.mediator.IMediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author will.109
 * @date 31/08/2019
 **/
public class ButtonBook extends JButton implements Command {

    private IMediator med;

    public ButtonBook(ActionListener actionListener, IMediator med) {
        super("Book");
        addActionListener(actionListener);
        this.med = med;
        med.registerBook(this);
    }

    @Override
    public void execute() {
        med.book();
    }
}
