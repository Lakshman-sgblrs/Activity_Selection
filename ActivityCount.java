public class ActivityCount {
//Sort the array on the basis of finish timing, using insertion sort
	public static void sortOnBasis(int arr1[], int arr2[]) {
		int n = arr2.length;
		for (int i = 1; i < n; ++i) {
			int key1 = arr2[i];
			int key2 = arr1[i];
			int j = i - 1;

			
			while (j >= 0 && arr2[j] > key1) {
				arr2[j + 1] = arr2[j];
				arr1[j + 1] = arr1[j];
				j = j - 1;
			}
			arr2[j + 1] = key1;
			arr1[j + 1] = key2;

		}
		printMaxActivities(arr1, arr2);
	}
//Count the activity selection by both the person.
	private static void printMaxActivities(int[] s, int[] f) {
		
		int i, j;
		int n = s.length;
		int[] visited = new int[n];
		int alice = 0,bob = 0, count = 0;
		
		//System.out.println("Following activities are selected : ");
		for (int m = 0; m < n; m++) {
			if (visited[m] == 0) {
				count++;
				i = m;
				// System.out.print(i + " ");
				//System.out.println("(" + s[i] + "," + f[i] + ")");

				visited[i] = 1;
				if (count % 2 == 0)
					bob = bob + 1;
				else
					alice = alice + 1;

				for (j = 1; j < n; j++) {
					if (visited[j] == 0) {
						if (s[j] >= f[i]) {
							// System.out.print(j + " ");
							//System.out.println("(" + s[j] + "," + f[j] + ")");
							if (count % 2 == 0)
								bob = bob + 1;
							else
								alice = alice + 1;
							i = j;
							visited[j] = 1;
						}
					}
				}
				/*for (int k = 0; k < n; k++) {
					System.out.print(visited[k] + "\t");
				}*/

				//System.out.println(alice + " " + bob);
			}
		}
		
		if(alice>bob)
			System.out.println("Alice win");
		else if(bob>alice)
			System.out.println("Bob win");
		else
			System.out.println("tie");
		/*
		 * for (int k = 0; k < n; k++) { System.out.print(visited[k] + "\t"); }
		 */
	}

	public static void main(String[] args) {
  //Given two array on basis of starting and finishing time
		int start[] = { 5, 1, 3, 0, 5, 8 };
		int finish[] = { 9, 2, 4, 6, 7, 9 };

		sortOnBasis(arr1, arr2);

	}
}
