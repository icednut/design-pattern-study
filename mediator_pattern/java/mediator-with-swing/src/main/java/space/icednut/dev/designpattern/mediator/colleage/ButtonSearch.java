package space.icednut.dev.designpattern.mediator.colleage;

import space.icednut.dev.designpattern.mediator.Command;
import space.icednut.dev.designpattern.mediator.mediator.IMediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author will.109
 * @date 31/08/2019
 **/
public class ButtonSearch extends JButton implements Command {

    private IMediator med;

    public ButtonSearch(ActionListener actionListener, IMediator med) {
        super("Search");
        addActionListener(actionListener);
        this.med = med;
        med.registerSearch(this);
    }

    @Override
    public void execute() {
        med.search();
    }
}
