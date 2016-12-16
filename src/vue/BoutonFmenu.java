package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created by ctx on 13/12/16.
 */
public class BoutonFmenu extends JButton implements ComponentListener {

    protected int width;
    protected int height;

    public BoutonFmenu(String str, int width, int height) {
        super(str);
        this.width=width;
        this.height=height;

        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        width = (componentEvent.getComponent().getWidth())/10;
        height = (componentEvent.getComponent().getHeight())/10;
    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {

    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {

    }

    @Override
    public void componentHidden(ComponentEvent componentEvent) {

    }
}
