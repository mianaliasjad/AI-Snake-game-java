import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnakeNode implements Comparable<SnakeNode>  {

	int x;
	int y;
	int g,h=0;
	private SnakeNode parent=null;
	
	
	public SnakeNode(int x, int y) {
		this.x=x;
		this.y=y;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	
	
	public int getG() {
		return g;
	}


	public void setG(int g) {
		this.g = g;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}

	public int getF() {
		return g+h;
	}
	
	

	public SnakeNode getParent() {
		return parent;
	}


	public void setParent(SnakeNode parent) {
		this.parent = parent;
	}

	public List<SnakeNode> myNeighbors(){
//		System.out.println("Me= ("+getX()+","+getY()+")");

		SnakeNode up = new SnakeNode(getX()-GameContants.MY_SNAKE_WIDTH_HEIGHT,getY());
		SnakeNode down = new SnakeNode(getX()+GameContants.MY_SNAKE_WIDTH_HEIGHT, getY());
		SnakeNode left = new SnakeNode(getX(), getY()-GameContants.MY_SNAKE_WIDTH_HEIGHT);
		SnakeNode right = new SnakeNode(getX(), getY()+GameContants.MY_SNAKE_WIDTH_HEIGHT);
		
//		System.out.println("Up= ("+up.getX()+","+up.getY()+")");
//		System.out.println("Down= ("+down.getX()+","+down.getY()+")");
//		System.out.println("Left= ("+left.getX()+","+left.getY()+")");
//		System.out.println("Right= ("+right.getX()+","+right.getY()+")");

		
//		MySnakeNode northEast = new MySnakeNode(getX()+MyContants.MY_SNAKE_WIDTH_HEIGHT, getY()-MyContants.MY_SNAKE_WIDTH_HEIGHT);
//		MySnakeNode northWest = new MySnakeNode(getX()-MyContants.MY_SNAKE_WIDTH_HEIGHT, getY()-MyContants.MY_SNAKE_WIDTH_HEIGHT);
//		MySnakeNode southEast = new MySnakeNode(getX()+MyContants.MY_SNAKE_WIDTH_HEIGHT, getY()+MyContants.MY_SNAKE_WIDTH_HEIGHT);
//		MySnakeNode southWest = new MySnakeNode(getX()-MyContants.MY_SNAKE_WIDTH_HEIGHT, getY()+MyContants.MY_SNAKE_WIDTH_HEIGHT);

		
//		System.out.println("northEast= ("+northEast.getX()+","+northEast.getY()+")");
//		System.out.println("northWest= ("+northWest.getX()+","+northWest.getY()+")");
//		System.out.println("southEast= ("+southEast.getX()+","+southEast.getY()+")");
//		System.out.println("southWest= ("+southWest.getX()+","+southWest.getY()+")");

		
		List<SnakeNode> lis=new ArrayList<>();
		lis.add(up);
		lis.add(down);
		lis.add(left);
		lis.add(right);
		
//		lis.add(northWest);
//		lis.add(northEast);
//		lis.add(southEast);
//		lis.add(southWest);

		return lis;

	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj instanceof SnakeNode){
			SnakeNode secondNode = (SnakeNode) obj;
			if(this.x == secondNode.x && this.y == secondNode.y){
				return true;
			}
		}
		return false;
	}


	/**
	 * Used for sorting the queue
	 * We add the node at start of queue which has lowest F
	 * Because we will poll the node which has lowest F first
	 */
	@Override
	public int compareTo(SnakeNode o) {
		int thisVal = this.getF();
		int otherVal = o.getF();
		
		int value = thisVal - otherVal;
		
		return (value>0)?1:(value<0)? -1: 0;
	}
	
}
