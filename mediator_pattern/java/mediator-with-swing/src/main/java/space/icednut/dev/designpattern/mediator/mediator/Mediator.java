package space.icednut.dev.designpattern.mediator.mediator;

import space.icednut.dev.designpattern.mediator.colleage.ButtonBook;
import space.icednut.dev.designpattern.mediator.colleage.ButtonSearch;
import space.icednut.dev.designpattern.mediator.colleage.ButtonView;
import space.icednut.dev.designpattern.mediator.colleage.LabelDisplay;

/**
 * @author will.109
 * @date 31/08/2019
 **/
public class Mediator implements IMediator {

    private ButtonView buttonView;
    private ButtonSearch buttonSearch;
    private ButtonBook buttonBook;
    private LabelDisplay show;

    @Override
    public void registerView(ButtonView v) {
        this.buttonView = v;
    }

    @Override
    public void registerSearch(ButtonSearch s) {
        this.buttonSearch = s;
    }

    @Override
    public void registerBook(ButtonBook b) {
        this.buttonBook = b;
    }

    @Override
    public void registerDisplay(LabelDisplay d) {
        this.show = d;
    }

    @Override
    public void book() {
        buttonBook.setEnabled(false);
        buttonView.setEnabled(true);
        buttonSearch.setEnabled(true);
        show.setText("booking...");
    }

    @Override
    public void view() {
        buttonBook.setEnabled(true);
        buttonView.setEnabled(false);
        buttonSearch.setEnabled(true);
        show.setText("viewing...");
    }

    @Override
    public void search() {
        buttonBook.setEnabled(true);
        buttonView.setEnabled(true);
        buttonSearch.setEnabled(false);
        show.setText("searching...");
    }
}
