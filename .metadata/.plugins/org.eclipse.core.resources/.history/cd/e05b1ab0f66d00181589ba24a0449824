package domain;
import java.util.Random;

public class Lotto {
	int count;
	int lottoNum[];
	String lottoList;
	Random random = new Random();
	public Lotto() {
		lottoList = "";
		count = 0;
	}
	public void setGameMoney(int gameMoney) {
		this.count = gameMoney/1000;
	}
	public void setBallNumber() {
		lottoNum = new int[7];
		int i=0, j=0;
		for(i=0;i<7;i++) {
			lottoNum[i] = random.nextInt(45)+1;
			for(j=0;j<i;j++) {
				if(lottoNum[i] == lottoNum[j]) {
					i--;
					break;
				} 
			}
		}
	}
	public void setLottoList() {
		for(int i=0;i<7;i++) {
			lottoList = (i==6) ? 
					lottoList + lottoNum[i] + "\n" :
						lottoList + lottoNum[i] + " "; 
		}
	}
	public int getCount() {
		return this.count; 
	}
	public String getLottoList() {
		return this.lottoList;
	}
		}
	
	
