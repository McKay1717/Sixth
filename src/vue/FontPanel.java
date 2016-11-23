package vue;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class FontPanel extends JPanel{
    //image
    protected Image imagefond;

    public FontPanel(Image imagefond) throws IOException{
        this.imagefond = imagefond;
    }

    public void paintComponent(Graphics g){
        g.drawImage(imagefond, 0, 0, 400, 400, null);
    }
}
