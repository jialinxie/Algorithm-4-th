import java.util.Arrays;

//1.1.29 Equal keys. Add to BinarySearch a static method rank() that takes a key and a sorted array of int values
//(some of which may be equal) as arguments and returns the number of elements that are smaller
//than the key and a similar method count() that returns the number of elements equal to the key.
//Note : If i and j are the values returned by rank(key, a) and count(key, a) respectively,
//then a[i..i+j-1] are the values in the array that are equal to key
public class BinarySearch
{
	public static int rank(int key, int[] a)
	{
		int lowerNum = 0;

		for(int i = 0; i < a.length; i++)
			if(a[i] < key)
				lowerNum ++;

		return lowerNum;
	}

	public static int count(int key, int[] a){
		int equalNum = 0;

		for(int i = 0; i < a.length; i++)
			if(a[i] == key)
				equalNum++;

		return equalNum;
	}

	public static void main(String[] args)
	{
		// read the integers from a file
		In in = new In(args[0]);
		int j = 0, i = 0;
		int[] whitelist = in.readAllInts();

		// sort the array
		Arrays.sort(whitelist);

		int lowerN = rank(2, whitelist);
		System.out.println("lowerN " + lowerN);

		int equalN = count(2, whitelist);
		System.out.println("equalN " + equalN);

		for(i = lowerN; i < lowerN + equalN; i++)
			System.out.println(whitelist[i]);
	}
}
