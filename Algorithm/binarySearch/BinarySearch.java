import java.util.Arrays;

public class BinarySearch
{
	public static int rank(int key, int[] a)
	{	//array must be sorted
		int lo = 0;
		int hi = a.length - 1;
		while( lo <= hi)
		{	//key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else
				if(key > a[mid])
					lo = mid + 1;
					else
						return mid; 

		}
		return -1;
	}

	public static void main(String[] args)
	{
		//int[] whitelist = In.readInts(args[0]);
		int[] whitelist = {9,8,7,6,5,4,3,2,1};

		StdOut.println("Hello World!");
		Arrays.sort(whitelist);
		//while (!StdIn.isEmpty())
		//{	//read key, print if not in whitelist.
			//int key = StdIn.readInt();
			int key = 10;
			if(rank(key, whitelist) < 0)
				StdOut.println(key);
		//}

	}
}