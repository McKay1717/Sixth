package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;


public class FontPanel extends JPanel implements ComponentListener {
    //image
    protected Image imagefond;

    public int centerBox = 200;

    protected int width;
    protected int height;

    private Dimension size = new Dimension(width, height);

    public FontPanel(Image imagefond, int width, int height) throws IOException{
        super();
        this.imagefond = imagefond;
        this.width = width;
        this.height = height;

    }

    public void paintComponent(Graphics g){
        g.drawImage(imagefond, 0, 0, width, height-50, null);
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        width = componentEvent.getComponent().getWidth();
        height = componentEvent.getComponent().getHeight();
        centerBox = componentEvent.getComponent().getHeight()/5;
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


    public void setCenterBox(int centerBox) {
        this.centerBox = centerBox;
    }

    public int getCenterBox() {

        return centerBox;
    }
}
