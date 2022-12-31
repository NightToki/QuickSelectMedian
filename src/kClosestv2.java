import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class kClosestv2 {
	public static int partition(int []a,int start, int end) {
		int pivot = a[end];
		while(start < end ) {
			while(a[start]<pivot) {
				start++;
			}
			while(a[end]>pivot) {
				end--;
			}
			if(start<end) {
				int temp = a[end];
		        a[end] = a[start];
		        a[start] = temp;
			}
		}
        return start;
		
		
	}
	
	

	
	public static int quickSelect(int []a,int k,int start, int end ) {
		
		int partition = partition(a,start,end);
		  if (partition == k - 1) {
			  return a[partition];
	            }
		  
		  else if (partition < k - 1)
	            return quickSelect(a, k,partition + 1, end);
		  else
	            return quickSelect(a, k, start, partition - 1);		
	}
	
	public static void bubbleSort(int[]a) {
		int n = a.length;
		int temp = 0;
		  for(int i=0; i < n; i++){  
              for(int j=1; j < (n-i); j++){  
                       if(a[j-1] > a[j]){  
                              temp = a[j-1];  
                              a[j-1] = a[j];  
                              a[j] = temp;  
                      }       
              }  
      }  
		
	}
	public static int[] call(int n) {
		Random rand = new Random(); 
	
		int[] a = new int[n];
		for(int i = 0; i <n;i++) {
			a[i] = rand.nextInt(200)-100;
		}
		return a;
		
	}
	public static int partition2(int []a,int start, int end) {
		int pivot =(a[end]);
		while(start < end ) {
			while(a[start]<pivot) {
				start++;
			}
			while(a[end]>pivot) {
				end--;
			}
			if(start<end) {
				int temp = a[end];
		        a[end] = a[start];
		        a[start] = temp;
			}
		}
        return start;
		
		
	}
	

	
	public static int quickSelect2(int []a,int k,int start, int end ) {
		
		int partition = partition(a,start,end);
		  if (partition == k - 1) {
			  return a[partition];
	            }
		  
		  else if (partition < k - 1)
	            return quickSelect2(a, k,partition + 1, end);
		  else
	            return quickSelect2(a, k, start, partition - 1);		
	}
public static int quickSelect3(int []a,int k,int start, int end ) {
		
		int partition = partition2(a,start,end);
		  if (partition == k - 1) {
			  return a[partition];
	            }
		  
		  else if (partition < k - 1)
	            return quickSelect3(a, k,partition + 1, end);
		  else
	            return quickSelect3(a, k, start, partition - 1);		
	}

	public static int[] closeS2(int[] a, int k,int[]diff, int median) {
		int x = 0;
		int[] a2 = new int[k];
		int q = 0;
		
		q = quickSelect(diff,k+1 ,0,a.length-1);
	
		int j = 0;

		for(int i = 0;i<diff.length;i++) {

			if(diff[i]!=0) {
				if(diff[i]<=q) {
					if(a[i]==median) {
						if(k==1&&diff[i]==q) {
							a2[j]=a[i+1];
							j++;
							
						}
						else {

						a2[j]=a[i-1];
						j++;
						}
					}
					else {

					a2[j]=a[i];
					j++;
					}
				}
				else {

				}
			}
		}
		return a2;
	}
	public static int[] closeS3(int[] a, int k) {
		int len = a.length;
		int median = quickSelect(a, a.length/2, 0, a.length-1 );
		int[] diffAbs = new int[a.length];
		int[] diff = new int[a.length];
		for(int i = 0;i<diff.length;i++) {
			diff[i] =(median-a[i]);
		}
		for(int i = 0;i<diff.length;i++) {
			diffAbs[i] = Math.abs(median-a[i]);
		}
//		int[][] compare1 = {diffAbs,diff};
		int q = 0;
		
		/*
		 * compare the quick select values to the non abs array and check if the numbers match if negative or positive
		 */
		
		
	//	System.out.println(Arrays.deepToString(compare1));
		int[]q1 = new int[k];
		int j = 0;
		for(int i=1;i<k+1;i++) {
			q = quickSelect(diffAbs,i+1,0,a.length-1);
//			System.out.println(q);
			q1[j] = q;
			j++;
		}
//		System.out.println(Arrays.deepToString(compare1));
	//	System.out.println("this is q1: "+Arrays.toString(q1));
		int[]q2 = new int[k];
		for(int i = 0; i<q1.length;i++) {
		//	System.out.println("This is i: "+i);
			for(int z = 0;z<diff.length;z++) {
			//	System.out.println("This is i: "+j);
			//	System.out.println("This is q1[i]: "+q1[i]);
			//	System.out.println("This is diff[z]: "+diff[z]);
				if(q1[i]==diff[z]||q1[i]==-diff[z]) {
					q2[i]=diff[z];
				}
				
			}
			
		}
//		System.out.println("this is q2: "+Arrays.toString(q2));
		int[] a2 = new int[k];
		for(int i = 0;i<q1.length;i++) {
	//		System.out.println("this is the median: "+median);
	//		System.out.println("this is q2[i]: "+q2[i]);
			a2[i] =(median-q2[i]);
		}
		
		return a2;
		
	}
	
	public static int median(int[]a) {
		int len = a.length;
		int median = quickSelect(a, a.length/2, 0, a.length-1 );
		System.out.println(median);
		
		return median;
	}
	public static int[] difference(int[]a, int median) {
		int[] diff = new int[a.length];
		for(int i = 0;i<diff.length;i++) {
			diff[i] = Math.abs(median-a[i]);
		}
		
		return diff;
		
		
	}
	
	
	
	
	public static List<String> closeS(int[] a, int k,int[]diff,int median) { 
		/*
		 * To do list
		 * To find the closst number use the quick select to find the smallest integer in the diff array
		 * use these numbers and create array of length k store the value and then make a comparison for loop after also return it to the orig numbers
		 * repeat this k amount of times 
		 * After that return the diff array to what it was before the quick select and then add the median to return it to the original array
		 * print out a[k[i]]
		 */
		int x = 0;
		int[] a2 = new int[k+1];
		String[] a3 = new String[k+1];
		int count=0;
		int[]a4 = new int[k];
		for(int i = 0;i<k+1;i++) {
			x = quickSelect2(diff,i+1,0,a.length-1);
			a2[i]=x;

		}
		//System.out.println("This is a2: "+ Arrays.toString(a2));
		int count2=0;
		for(int i = 0;i<diff.length;i++) {
			for(int j =0;j<a2.length;j++) {
				if(a2[j]==diff[i]) {
					a3[count2++]=String.valueOf(a[i]);
					
				}
			}
			
		}
		List<String> list = new ArrayList<String>();
		 for(String num:a3) {
	         list.add(num);
	      }
		 list.remove(String.valueOf(median));
		
		return list;
		

    }
	
	
	public static void main(String[] args) {
		Scanner userInt = new Scanner(System.in);
		boolean loop = true;
		boolean loop2 = true;
		int n = 0;
		while(loop == true){
			System.out.println("Enter a valid positive integer: ");
			 n = userInt.nextInt();
			if(n<0) {
				System.out.println("Not valid positive integer");
				loop=true;
			}
			else {
				loop =false;
			}
		}
		int[]a = call(n);
		
		int[]store= a.clone();		
		System.out.println(Arrays.toString(a));
		int m = median(a);
		int[] diff = difference(a,m);
	//	System.out.println(Arrays.toString(a));

	//	System.out.println(Arrays.toString(diff));
		
		
		
		
		
		int k = 0;

		while(loop2 == true){
			System.out.println("Enter a valid positive integer between 0 to "+n+": ");
			 k = userInt.nextInt();
			if(k<0&&k>n-1) {
				System.out.println("Not valid positive integer");
				loop2=true;
			}
			else {
				loop2 =false;
			}
		}
	//	int[] close = closeS2(a,k,diff,m);
//		System.out.println(Arrays.toString(close));
		int [] close2 = closeS3(a,k);
		System.out.println(Arrays.toString(close2));

		System.out.println("#6 Q: the time complexity of my difference function which stored the difference was only O(n)");
		System.out.println("#8 Q: the time complexity of changing numbers back to the origianal would also like difference O(n)");
		System.out.println("T(n) =C+n+C+n+n+C+n = O(n) ");
		System.out.println("I grouped any single ines of code as C because they will be removed in the end. In all my functions that have a run time n,");
		System.out.println(" they either use a for loop that has a run time of n or use quick select once which also has a run time of n");
	
		
	}
	
	

}
