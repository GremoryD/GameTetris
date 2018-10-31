import java.awt.Graphics;
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
		while(!isTouchGround()) {
			stepDown();
		}
		
	}

	void rotate() {
        rotateShape(GameTetris.RIGHT);
        if (!isWrongPosition()) {
            figure.clear();
            createFromShape();
        } else
            rotateShape(GameTetris.LEFT);
    }
	
	boolean isWrongPosition() {
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                if (shape[y][x] == 1) {
                    if (y + this.y < 0) return true;
                    if (x + this.x < 0 || x + this.x > GameTetris.FIELD_WIDTH - 1) return true;
                    if (GameTetris.mine[y + this.y][x + this.x] > 0) return true;
                }
        return false;
    }
	void createFromShape() {
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                if (shape[y][x] == 1) figure.add(new Block(x + this.x, y + this.y));
    }
	void rotateShape(int direction) {
        for (int i = 0; i < size/2; i++)
            for (int j = i; j < size-1-i; j++)
                if (direction == GameTetris.RIGHT) { // clockwise
                    int tmp = shape[size-1-j][i];
                    shape[size-1-j][i] = shape[size-1-i][size-1-j];
                    shape[size-1-i][size-1-j] = shape[j][size-1-i];
                    shape[j][size-1-i] = shape[i][j];
                    shape[i][j] = tmp;
                } else { // counterclockwise
                    int tmp = shape[i][j];
                    shape[i][j] = shape[j][size-1-i];
                    shape[j][size-1-i] = shape[size-1-i][size-1-j];
                    shape[size-1-i][size-1-j] = shape[size-1-j][i];
                    shape[size-1-j][i] = tmp;
            }
    }

	public void move(int direction) {
		if(!isTouchWall(direction)) {
			int dx = direction - 38;
			for(Block block:figure)block.setX(block.GetX()+dx);
			x+=dx;
		}
		
	}

	private boolean isTouchWall(int direction) {
		for (Block block : figure) {
            if (direction == GameTetris.LEFT && (block.GetX() == 0 || GameTetris.mine[block.GetY()][block.GetX() - 1] > 0)) return true;
            if (direction == GameTetris.RIGHT && (block.GetX() == GameTetris.FIELD_WIDTH - 1 || GameTetris.mine[block.GetY()][block.GetX() + 1] > 0)) return true;
        }
        return false;
	}

	public boolean isTouchGround() {
		for(Block block:figure)if(GameTetris.mine[block.GetY()+1][block.GetX()]>0)return true;
		return false;
	}

	public void leaveOnGround() {
		for(Block block:figure)GameTetris.mine[block.GetY()][block.GetX()]=color;
		
	}

	public boolean isCrossGround() {
		// TODO Auto-generated method stub
		return false;
	}

	public void stepDown() {
		for(Block block:figure)block.setY(block.GetY()+1);
		y++;
		
	}
	
	void paint(Graphics g) {
		for(Block block:figure)block.paint(g, color);
	}
 

}
