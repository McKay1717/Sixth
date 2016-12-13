package vue;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FontButton extends JButton {
    //image
    protected Image imagefond;

    protected int width;
    protected int height;

    public FontButton(String str, Image imagefond, int width, int height) throws IOException {
        super(str);
        this.width = width;
        this.height = height;
        this.imagefond = imagefond;
    }

    public void paintComponent(Graphics g){
        g.drawImage(imagefond, 0, 0, width, height, null);
    }
}
