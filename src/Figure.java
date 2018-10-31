import java.util.ArrayList;
import java.util.Random;

public class Figure {
	private ArrayList<Block> figure = new ArrayList<Block>();
	private int[][] shape = new int[4][4];
	private int type,size,color;
	private int x=3,y=0;

	public Figure(){
		Random random = new Random();
		type = random.nextInt(GameTetris.SHAPES.length);
		size = GameTetris.SHAPES[type][4][0];
		color = GameTetris.SHAPES[type][4][1];
		if(size==4)this.y=-1;
		for(int i=0;i<size ;i++) {
			System.arraycopy(GameTetris.SHAPES[type][i], 0, shape[i], 0,GameTetris.SHAPES[type][i].length);
			
		}
		createFromeShape();
	}
	
	private void createFromeShape() {
		for(int x=0;x<size;x++) {
			for(int y=0;y<size;y++) {
				if(shape[y][x]==1) {
					figure.add(new Block(x+this.x,y+this.y));
				}
			}
		}
		
	}

	public void drope() {
		// TODO Auto-generated method stub
		
	}

	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	public void move(int direction) {
		// TODO Auto-generated method stub
		
	}

	public boolean isTouchGround() {
		 
		return false;
	}

	public void leaveOnGround() {
		// TODO Auto-generated method stub
		
	}

	public boolean isCrossGround() {
		// TODO Auto-generated method stub
		return false;
	}

	public void stepDown() {
		// TODO Auto-generated method stub
		
	}
 

}
