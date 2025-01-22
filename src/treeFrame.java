import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.*;
public class treeFrame extends JPanel{
	
		protected int segments = 5;
	
		public void getSegments(int seg) {
			segments = seg;
		}
	
		public treeFrame() {
			super();
	        setBackground(Color.white);
	        setPreferredSize(new Dimension(500,500));
		}
		
		public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        
	        
	        
	        Graphics2D myGraphics = (Graphics2D) g;
	        BasicStroke stroke = new BasicStroke(3);
	        myGraphics.setStroke(stroke);
	        
	        tree myTree = new tree(-30,segments);
	        myTree.drawOn(myGraphics, 210,450,-90);
		}
}
