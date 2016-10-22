package awesome;

/**
 * @author jtduan
 * @date 2016/10/20
 *
 * UnionFind约定：
 * 1 数组名称使用UF,
 * 2 find过程中进行优化
 * 3 union不进行优化，简化编程,一般将index大的root挂到index小的root节点上
 *
 * 带有权值的UnionFind（nyoj207）:
 * 1 priority[]存储当前节点与该节点的父节点的关系
 * 2 find优化过程中同步更新priority值即可
 * 3 注意union过程中根节点相连时对应priority的值
 *
 * 多段UnionFind
 * 同类型的每一段均做处理
 * 不用类型的跨段做union
 *
 * 借助于其他数据结构（HashMap），并查集可以“向后看”(Leetcode128,每一个数据指向比它大1的父节点，节点最多的树即为结果)
 */
public class UnionFind
{
	public static int aMethod(int i)throws Exception
	{
		try{
			return 10/i;
		}
		catch (Exception ex)
		{
			throw new Exception("exception in a Method");
		} finally{
			System.out.printf("finally");
		}
	}

	public static void main(String [] args)
	{
		try
		{
			aMethod(0);
		}
		catch (Exception ex)
		{
			System.out.printf("exception in main");
		}
		System.out.printf("finished");
	}


}