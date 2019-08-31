package space.icednut.dev.designpattern.mediator;

import space.icednut.dev.designpattern.mediator.colleage.ButtonBook;
import space.icednut.dev.designpattern.mediator.colleage.ButtonSearch;
import space.icednut.dev.designpattern.mediator.colleage.ButtonView;
import space.icednut.dev.designpattern.mediator.colleage.LabelDisplay;
import space.icednut.dev.designpattern.mediator.mediator.IMediator;
import space.icednut.dev.designpattern.mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author will.109
 * @date 31/08/2019
 **/
public class AppMain extends JFrame implements ActionListener {

    private IMediator med = new Mediator();

    public AppMain() {
        final JPanel p = new JPanel();
        p.add(new ButtonView(this, med));
        p.add(new ButtonBook(this, med));
        p.add(new ButtonSearch(this, med));

        final Container container = getContentPane();
        container.add(new LabelDisplay(med), "North");
        container.add(p, "South");
        setSize(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Command command = (Command) e.getSource();
        command.execute();
    }

    public static void main(String[] args) {
        new AppMain();
    }
}
