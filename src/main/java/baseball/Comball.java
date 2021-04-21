package baseball;

import java.lang.reflect.Array;

public class Comball {
	
	private int randomNum() {
		return (int)(Math.random()*9)+1;
}
	
	public int[] compBall(int a) {
		int[] ball = new int[a];
		int idx = 0;
		while(true) {
			int r = randomNum();
			if(!check(ball,r)){
				ball[idx++] = r;
			}
			if(idx == 3) {
				break;
			}
		}
		return ball;
	}
	
	
	private boolean check(int[] arr, int num) {
		boolean isc = false;
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] == num)
				isc = true;
		}
		return isc;
	}
}
