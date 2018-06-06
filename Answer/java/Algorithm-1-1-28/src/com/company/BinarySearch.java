import java.util.Arrays;

//Remove duplicates. Modify the test client in BinarySearch to
//remove any du- plicate keys in the whitelist after the sort.

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
		// read the integers from a file
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();

		// sort the array
		Arrays.sort(whitelist);
//
//		while (!StdIn.isEmpty())
//		{	//read key, print if not in whitelist.
//			int key = StdIn.readInt();
//			if(rank(key, whitelist) < 0)
//				StdOut.println(key);
//		}

		//need to use list, need avoid continus same data,like 12 12 12
		for(int i = 0; i < whitelist.length - 2; i++) {
			if (whitelist[i] == whitelist[i + 1]) {
				//use list-table to remove duplicate data
				for (int j = i; j < whitelist.length - 2; j++)
					whitelist[j + 1] = whitelist[j + 2];
				//whitelist[]
			}
			System.out.println(whitelist[i]);
		}

	}
}
