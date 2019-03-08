
public class Frame {
	private int ball1 = 0;
	private int ball2 = 0;
	private int ball3 = 0;

	
	
	public void setBall(int pos, int pins) {
		if(pos ==0 && pins >=0 && pins<=10) {
			this.ball1 = pins;
		} else if(pos == 1&& pins >=0 && (pins)<=10 && this.isStrike()) {
			this.ball2 = pins;
		}else if(pos == 1&& pins >=0 && (this.ball1+pins)<=10 ) {
			this.ball2 = pins;
		}
		else if(pos == 2&& pins >=0 && pins<=10){
			this.ball3 = pins;
		}
		else {
			throw new IllegalArgumentException("not valid position, and pins");
		}
	}
	
	public int getBall(int pos) {
		if(pos==0) {
			return this.ball1;
		} 
		else if(pos==1) {
			return this.ball2;
		} 
		else if(pos==2) {
			return this.ball3;
		} 
		else {
			throw new IllegalArgumentException("not valid position");
		}
	}
	
	public int sumFirstTwoBalls() {
		return this.ball1+this.ball2;
	}
	
	public int sumAll() {
		return this.sumFirstTwoBalls() +this.ball3;
	}
	public boolean isSpare() {
		if(!this.isStrike()) {
			return this.ball1 + this.ball2 == 10;
		}
		return false;
	}
	
	public boolean isStrike() {
		return this.ball1 ==10;
	}
}
