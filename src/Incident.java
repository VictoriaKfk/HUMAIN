import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Random;

public class Incident {
	public static byte[] aWinfred = {97, 98, 99, 100, 101, 102, 103, 104,
		105, 49, 45, 50, 51};

    public static long mBaculum(String path) {

		path = "C:\\Users\\asima\\Desktop\\java2\\bytes.txt";
		long sum = 0;
		Random r = new Random();
		byte[] a = new byte[841];
		for (int i = 0; i < 841; i++) {
			int rnd = r.nextInt(aWinfred.length);
			a[i] = aWinfred[rnd];
		}
		try {

	    	FileOutputStream stream = new FileOutputStream(path);
	    	stream.write(a);
    	} catch (IOException e) {

			e.printStackTrace();
		}

		try (BufferedInputStream in =
			new BufferedInputStream(new FileInputStream(path))) {

			for (int i = 0; i < 617; i++) {
                System.out.println(i);
		        sum += in.read();
                System.out.println(sum);

			}

		} catch (FileNotFoundException e) {

		    System.exit(1);
		} catch (IOException e) {

			System.exit(1);
		}
		return sum;

	}

	public static int[] mEntrapper(String path) {

		path = "C:\\Users\\asima\\Desktop\\java2\\bytes.txt";
	    int[] a = new int[14];
		File file = new File(path);
		int s = (int) file.length();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		int count10 = 0;
		int count11 = 0;
		int count12 = 0;
		int count13 = 0;
		int b;
		try (BufferedInputStream in =
			new BufferedInputStream(new FileInputStream(path))) {

			while ((b = in.read()) != -1) {

				if (b == 97) {
					count1++;
				}
				if (b == 98) {
					count2++;
				}
			    if (b == 99) {
					count3++;
				}
				if (b == 100) {
					count4++;
				}
				if (b == 101) {
					count5++;
				}
				if (b == 102) {
					count6++;
				}
				if (b == 103) {
					count7++;
				}
				if (b == 104) {
					count8++;
				}
				if (b == 105) {
					count9++;
				}
				if (b == 49) {
					count10++;
				}
				if (b == 45) {
					count11++;
				}
				if (b == 50) {
					count12++;
				}
				if (b == 51) {
					count13++;
				}
			}

		} catch (FileNotFoundException e) {

		    System.exit(1);
		} catch (IOException e) {

		    System.exit(1);
	    }

	    a[0] = s;
	    a[1] = count1;
	    a[2] = count2;
	    a[3] = count3;
	    a[4] = count4;
	    a[5] = count5;
	    a[6] = count6;
	    a[7] = count7;
	    a[8] = count8;
	    a[9] = count9;
	    a[10] = count10;
	    a[11] = count11;
	    a[12] = count12;
	    a[13] = count13;
	    System.out.print(a[2]);
	    return a;
	}
}




