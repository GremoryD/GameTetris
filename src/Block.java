import java.awt.Color;
import java.awt.Graphics;

public class Block {
		private int x,y;
		
		public Block(int x, int y){
			setX(x);
			setY(y);
		}

		public  void setY(int y2) {this.y=y2; }
		public  void setX(int x2) {this.x=x2; }
		public int GetX() {return this.x;}
		public int GetY() {return this.y;}
		
		void paint(Graphics g,int color) {
			g.setColor(new Color(color));
			g.drawRoundRect(x* GameTetris.BLOCK_SIZE+1, y*GameTetris.BLOCK_SIZE+1, GameTetris.BLOCK_SIZE-2, GameTetris.BLOCK_SIZE-2,GameTetris.ARC_RADIUS,GameTetris.ARC_RADIUS);
		}
}
