package space.icednut.dev.designpattern.mediator.mediator;

import space.icednut.dev.designpattern.mediator.colleage.ButtonBook;
import space.icednut.dev.designpattern.mediator.colleage.ButtonSearch;
import space.icednut.dev.designpattern.mediator.colleage.ButtonView;
import space.icednut.dev.designpattern.mediator.colleage.LabelDisplay;

/**
 * @author will.109
 * @date 31/08/2019
 **/
public interface IMediator {

    void book();

    void view();

    void search();

    void registerView(ButtonView v);

    void registerSearch(ButtonSearch s);

    void registerBook(ButtonBook b);

    void registerDisplay(LabelDisplay d);
}
