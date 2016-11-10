package jtduan.classloader;

import java.io.*;

/**
 * Created by djt on 10/29/16.
 */
public class MyClassLoader extends ClassLoader {

	//类加载器名称
	private String name;
	//加载类的路径
	private String path = "/Users/djt/javaclassloader/";
	private final String fileType = ".class";
	public MyClassLoader(String name){
		//让系统类加载器成为该 类加载器的父加载器
		super();
		this.name = name;
	}

	public MyClassLoader(ClassLoader parent, String name){
		//显示指定该类加载器的父加载器
		super(parent);
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * 获取.class文件的字节数组
	 * @param name
	 * @return
	 */
	private byte[] loaderClassData(String name){
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		this.name = this.name.replace(".", "/");
		try {
			is = new FileInputStream(new File(path + name + fileType));
			int c = 0;
			while(-1 != (c = is.read())){
				baos.write(c);
			}
			data = baos.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				is.close();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	/**
	 * 获取Class对象
	 */
	@Override
	public Class<?> findClass(String name){
		byte[] data = loaderClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//loader1的父加载器为系统类加载器
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("/Users/djt/javaclassloader/lib1/");
		//loader2的父加载器为loader1
		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
		loader2.setPath("/Users/djt/javaclassloader/lib2/");
		//loader3的父加载器为根类加载器
		MyClassLoader loader3 = new MyClassLoader(null, "loader3");
		loader3.setPath("/Users/djt/javaclassloader/lib3/");

//		Class clazz = loader2.loadClass("jtduan.classloader.Sample");
//		Object object = clazz.newInstance();
//
//		Sample s = (Sample)object;
//		s.setNum(10);
//		System.out.println(s.getNum());


		Class clazz2 = loader3.loadClass("jtduan.classloader.Sample");
		Object object2 = clazz2.newInstance();

		jtduan.classloader.Sample s2 = (jtduan.classloader.Sample)object2;
		s2.setNum(40);
		System.out.println(s2.getNum());
	}
}