package space.icednut.dev.designpattern.mediator.colleage;

import space.icednut.dev.designpattern.mediator.Command;
import space.icednut.dev.designpattern.mediator.mediator.IMediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author will.109
 * @date 31/08/2019
 **/
public class ButtonView extends JButton implements Command {

    private IMediator med;

    public ButtonView(ActionListener actionListener, IMediator med) {
        super("View");
        addActionListener(actionListener);
        this.med = med;
        med.registerView(this);
    }

    @Override
    public void execute() {
        med.view();
    }
}
