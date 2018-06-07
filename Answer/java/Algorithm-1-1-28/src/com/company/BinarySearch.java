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
		int j = 0, i = 0;
		int[] whitelist = in.readAllInts();
		Boolean back = false;

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
		for(i = 0; i < whitelist.length - 1; i++) {

			if(back == true) {
				back = false;
				--i;
			}
			if (whitelist[i] == whitelist[i + 1]) {
				//suggest to use list to remove duplicate data
				for (j = i; j < whitelist.length - 1; j++) {
					whitelist[j] = whitelist[j + 1];
				}
				back = true;
				whitelist[j] = '\0';
				//whitelist[]
			}

		}

		for(i = 0; whitelist[i] != '\0'; i++)
			System.out.println(whitelist[i]);
	}
}
