package domain;

import lombok.Data;

@Data
public class ExamBean {
	private String examSeq, recordSeq, subSeq, memId, month, score;
	
	
	public String toString() {
		return "정보 [examSeq = " + examSeq + 
				" recordSeq = " + recordSeq + 
				" subSeq = " + subSeq + 
				" memId = " + memId	+
				" month = " + month + 
				" score = " + score + "]";
	}
}
