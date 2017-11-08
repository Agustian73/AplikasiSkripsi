/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peramalan.view;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author 6P52
 */
public class ClGambarDesktop extends JDesktopPane
{
        @Override
	protected void paintComponent(Graphics graph)
	{
		Graphics2D g2D = (Graphics2D) graph.create();
		
		Image img = new ImageIcon(getClass().getResource("/peramalan/icon/pintu.jpg")).getImage();
		
		g2D.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g2D.dispose();
	}
}