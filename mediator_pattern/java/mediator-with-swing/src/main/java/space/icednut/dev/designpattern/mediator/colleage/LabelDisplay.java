package space.icednut.dev.designpattern.mediator.colleage;

import space.icednut.dev.designpattern.mediator.mediator.IMediator;

import javax.swing.*;
import java.awt.*;

/**
 * @author will.109
 * @date 31/08/2019
 **/
public class LabelDisplay extends JLabel {

    private IMediator med;

    public LabelDisplay(IMediator med) {
        super("Just start...");
        this.med = med;
        med.registerDisplay(this);
        setFont(new Font("Arial", Font.BOLD, 24));
    }
}
