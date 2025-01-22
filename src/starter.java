import java.util.Scanner;

import javax.swing.JFrame;

public class starter {

	public static void main(String[] args) {
		recursive myAddition = new recursive();
		System.out.println(myAddition.addition(7));
		recursive myPower = new recursive();
		System.out.println(myPower.power(4, 4));
		int mySegmentNumber = 5;

		if(args.length > 0) {
			for(int i =0;i<1;i++) {
				mySegmentNumber = Integer.parseInt(args[i]);
			}
		}
		
		JFrame frame = new JFrame("Tree");
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        treeFrame myPanel = new treeFrame();
        myPanel.getSegments(mySegmentNumber);
        frame.getContentPane().add(myPanel);
        frame.pack();
		

	}

}
