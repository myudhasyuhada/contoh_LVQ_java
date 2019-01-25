import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x1 = new int[6];
		int[] x2 = new int[6];
		int[] t = new int[6];
		
		x1[0] = 1;
		x1[1] = 3;
		x1[2] = 6;
		x1[3] = 8;
		x1[4] = 9;
		x1[5] = 1;
		
		x2[0] = 3;
		x2[1] = 4;
		x2[2] = 1;
		x2[3] = 3;
		x2[4] = 1;
		x2[5] = 6;
		
		t[0] = 1;
		t[1] = 1;
		t[2] = -1;
		t[3] = -1;
		t[4] = -1;
		t[5] = 1;
		
		Lvq lvq = new Lvq();
		lvq.train(x1,x2,t);
		
		System.out.println(Arrays.toString(lvq.w1));
		System.out.println(Arrays.toString(lvq.w2));

	}

}
