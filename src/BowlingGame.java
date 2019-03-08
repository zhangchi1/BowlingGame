import java.util.ArrayList;

public class BowlingGame {
	private ArrayList<Frame> frames;
	private int score;
	int maxRound = 10;
	int currentRound= 0;
	int currentBall = 0;
	
	// initialize 10 empty frames
	public BowlingGame() {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		for(int i=0; i < this.maxRound;i++) {
			frames.add(new Frame());
		}
		this.frames = frames;
		this.score = 0;
	}
	
	public ArrayList<Frame> getFrames(){
		return this.frames;
	}
	
	//TODO: update for time efficiency
	// add the score for update status
	public int getScore() {
		int total = 0;
		// for the first 9 rounds
		for(int i=0; i<this.maxRound-1;i++) {
			int currentRound = this.frames.get(i).sumFirstTwoBalls();
			if(this.frames.get(i).isSpare() ||this.frames.get(i).isStrike()) {
				currentRound += this.frames.get(i+1).getBall(0);
			}
			total +=currentRound;
		}
		// add the score for 10th round
		total += this.frames.get(this.maxRound-1).sumAll();
		
		this.score = total;
		return this.score;
	}
	
	//roll a ball
	public void roll(int pins) {
		Frame frame = this.frames.get(currentRound);
		//first 9 rounds
		if(this.currentRound < 9) {
			frame.setBall(this.currentBall, pins);
			this.currentBall = (this.currentBall + 1) % 2; // currentBall can be either 0 or 1
			if(this.currentBall==0) {
				this.currentRound +=1; //if currentBall jump back to 0, set to new round
			}
			// last round
		} else if(this.currentRound == 9 && (this.currentBall ==0 || this.currentBall ==1)) {
			frame.setBall(this.currentBall, pins);
			this.currentBall = (this.currentBall + 1) % 3; // currentBall can be either 0 or 1, or 2
			if(this.currentBall==0) {
				this.currentRound +=1; //if currentBall jump back to 0, set to new round
			}
			// last round
		} else if(this.currentRound == 9 && this.currentBall ==2) {
			if(frame.isStrike() || frame.isSpare()) {
				frame.setBall(this.currentBall, pins);
				this.currentBall = (this.currentBall + 1) % 3; // currentBall can be either 0 or 1, or 2
				if(this.currentBall==0) {
					this.currentRound +=1; //if currentBall jump back to 0, set to new round
				}
			} else {
				throw new IllegalArgumentException("game ends");
			}
		}
		else {
			throw new IllegalArgumentException("game ends");
		}	
	} //end roll method

}
