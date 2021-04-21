package baseball;

import java.util.Arrays;

public class GameMain {

	public static void main(String[] args) {
	BaseballGame user = new BaseballGame();
//		int[] userResult = user.makeBall(3,1,9,true);
	//	System.out.println(Arrays.toString(userResult));
	
	Comball ch = new Comball();
//	int[] Array= {1,2,3};
//	int num =1;
	
	BaseballCompare compare = new BaseballCompare();
	int[] compBall = {1,2,3};
	int[] userBall = {1,2,3};
	compare.setComBall(compBall);
	compare.setUserBall(userBall);		
	
	System.out.println("스트라이크"+compare.strike());
	System.out.println("볼"+compare.ball());	
	}
}
