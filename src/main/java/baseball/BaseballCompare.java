package baseball;

public class BaseballCompare {
	
	private int[] compBall;
	private int[] userBall;
	
	public void setComBall(int[] comBall) {
		this.compBall = comBall;
	}
	
	public void setUserBall(int[] userBall) {
		this.userBall = userBall;
	}
	
	public int strike(){
		int cnt = 0;
		for(int i = 0; i < compBall.length;i++){
		if(compBall[i] == userBall[i]) {
			cnt++;
		}
		}
		return cnt;
	}	
	public int ball() {
		int cnt = 0;
		for(int i = 0; i < compBall.length;i++) {
			for(int j = 0; j < compBall.length;j++) {
				if(i!=j && compBall[i] == compBall[j]);		
			}
		}		
		return cnt;
	}
	
}
