import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class tree {
	protected double splitAngle;
	protected int maxSegments;
	protected int nx = 0;
	protected int ny = 0;
	protected double a1 = 0;
	protected double a2 = 0;
	protected int angleNoise = 0;
	protected Color veryLightGreen = new Color(102,255,102);
	protected Color lightGreen = new Color(0,255,51);
	protected Color green = new Color(0,204,0);
	protected Color darkGreen = new Color(0,153,0);
	protected Color veryDarkGreen = new Color(0,102,0);
	protected int colorNoise = 0;
	protected int lengthNoise = 0;
	
	
		public tree(double sA, int mS) {
			splitAngle = sA;
			maxSegments = mS;
		}
		
		public void setSplitAngle(double myAngle) {
			myAngle = splitAngle;
		}
		public void setMaxSegments(int mySeg) {
			maxSegments = mySeg;
		}
		public double getSplitAngle() {
			return splitAngle;
		}
		public int getMaxSegments() {
			return maxSegments;
		}
		
		public void drawOn(Graphics2D g, int x, int y, double angle) {
			drawTree(g, x,y,angle,maxSegments);
			
		}
		
		private void drawTree(Graphics2D g, int sx, int sy, double sAngle, int segsRemaining) {
			if(segsRemaining != 1) {
				nx = (int)(sx+branchLength(segsRemaining)*Math.cos(Math.toRadians(sAngle)));
				ny = (int)(sy+branchLength(segsRemaining)*Math.sin(Math.toRadians(sAngle)));
				
				g.drawLine(sx,sy,nx, ny);
				angleNoise = (int)(Math.random() * (7) -3);
				int tempx = nx;
				int tempy = ny;
				a1 = sAngle + splitAngle + angleNoise;
				nx = (int)(tempx+branchLength(segsRemaining)*Math.cos(Math.toRadians(a1)));
				ny = (int)(tempy+branchLength(segsRemaining)*Math.sin(Math.toRadians(a1)));
				if(segsRemaining == 2) {
					drawLeaf(g,nx,ny,sAngle);
				}
				g.drawLine(tempx,tempy,nx,ny);
				drawTree(g,nx,ny,a1,segsRemaining-1);
				a2 = sAngle - splitAngle + angleNoise;
				nx = (int)(tempx+branchLength(segsRemaining)*Math.cos(Math.toRadians(a2)));
				ny = (int)(tempy+branchLength(segsRemaining)*Math.sin(Math.toRadians(a2)));
				g.drawLine(tempx, tempy, nx, ny);
				if(segsRemaining == 2) {
					drawLeaf(g,nx,ny,sAngle);
				}
				drawTree(g,nx,ny,a2,segsRemaining-1);
				
			}
			
			
			
			
			
		}
		
		
		private void drawLeaf(Graphics2D g,int x, int y, double theta) {
			AffineTransform xf = g.getTransform();
			g.translate(x, y);
			g.rotate(theta);
			colorNoise = (int)(Math.random()*5) + 1;
			if(colorNoise == 1) {
				g.setColor(veryLightGreen);
			}
			else if(colorNoise == 2) {
				g.setColor(lightGreen);
			}
			else if(colorNoise == 3) {
				g.setColor(green);
			}
			else if(colorNoise == 4) {
				g.setColor(darkGreen);
			}
			else if(colorNoise == 5) {
				g.setColor(veryDarkGreen);
			}
			
			g.fillOval(0,0,15,10);
			g.fillOval(-15, 0, 15, 10);
			g.setColor(Color.red);
			g.fillOval(-5, -5, 10, 10);
			g.setTransform(xf);
			g.setColor(Color.black);
		}
		
		public int branchLength(int segRemain) {
			lengthNoise = (int)(Math.random() * (7) -3);
			return 10*segRemain + lengthNoise;
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
