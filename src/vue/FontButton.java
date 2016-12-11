package vue;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FontButton extends JButton {
    //image
    protected Image imagefond;

    protected int width;
    protected int length;

    public FontButton(String str, Image imagefond, int width, int length) throws IOException {
        super(str);
        this.width = width;
        this.length = length;
        this.imagefond = imagefond;
    }

    public void paintComponent(Graphics g){
        g.drawImage(imagefond, 0, 0, width, length, null);
    }
}
