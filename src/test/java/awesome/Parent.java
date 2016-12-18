package awesome;

/**
 * Created by djt on 11/13/16.
 */
public class Parent {
	public int x;
	public static int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Parent.y = y;
	}
}
