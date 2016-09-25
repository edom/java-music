package com.spacetimecat.music.notation.editor;

import org.audiveris.proxymusic.mxl.Mxl;
import org.audiveris.proxymusic.util.Marshalling;

import javax.swing.*;
import java.awt.*;

public enum Main
{
    ;
    public static void main (String... args) throws java.io.FileNotFoundException, java.io.IOException, Mxl.MxlException, javax.xml.bind.JAXBException, Marshalling.UnmarshallingException, Marshalling.MarshallingException
    {
        SwingUtilities.invokeLater
            (
                () ->
                {
                    final JFrame main = new JFrame("title");
                    main.setMinimumSize(new Dimension(64, 64));
                    main.setPreferredSize(new Dimension(640, 480));
                    main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    main.setLayout(null);
                    final JComponent canvas = new MyCanvas();
                    main.add(canvas);
                    canvas.setBounds(0, 0, 640, 480);
                    main.pack();
                    main.setVisible(true);
                }
            );
    }
}
