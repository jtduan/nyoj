package awesome;

/**
 * 结论：
 * 1 静态变量与 成员变量名称不能相同
 * 2 私有属性和方法不会被继承(公告方法继承 是引用的方式（第三点）私有属性和方法直接没有引用)
 * 3 继承 父类 并不会将父类的属性拷贝一份到之类，而是引用的形式，修改子类的值会导致父类的值改变
 * 4 覆盖 父类 会拷贝一份属性到子类，之类的值修改时 父类的值不受影响
 * 5 第三条和第四条 不区分静态属性还是成员属性，但是 静态属性不会受多态的影响，普通属性会受到多态的影响
 *
 *
 * -----简言之----
 * 继承 没有拷贝任何属性，
 * 覆盖 拷贝了属性和方法，覆盖方法时若操作自身类中的属性，需要有引用或实际的内存空间
 */
public class Child extends Parent{

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Child.y = y;
	}

	public static void main(String[] args) {
		Child child = new Child();
		child.setX(10);
		System.out.println(child.getX());
	}
}
