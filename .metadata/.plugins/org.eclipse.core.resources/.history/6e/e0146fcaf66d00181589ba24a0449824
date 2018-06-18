package ui;

import java.util.Arrays;

import javax.swing.JOptionPane;

import domain.BMI;
import domain.Grade;
import domain.Salary;
import domain.Lotto;
enum Butt {
	EXIT,
	INPUT_BMI,
	OUTPUT_BMI,
	INPUT_GRADE,
	OUTPUT_GRADE,
	INPUT_Salary,
	OUTPUT_Salary,
	OUTPUT_Dept,
	INPUT_LOTTO,
	OUTPUT_LOTTO,
}	
public class Main {
	public static void main(String[] args) {
		Butt[] buttons = {
				Butt.EXIT,
				Butt.INPUT_BMI,
				Butt.OUTPUT_BMI,
				Butt.INPUT_GRADE,
				Butt.OUTPUT_GRADE,
				Butt.INPUT_Salary,
				Butt.OUTPUT_Salary,
				Butt.OUTPUT_Dept,
				Butt.INPUT_LOTTO,
				Butt.OUTPUT_LOTTO,
		};
		BMI[] arr = new BMI[2];
		BMI bmi = null;
		Grade[] gradeArr = new Grade[2];
		Grade grade = null;
		int count = 0, gradeCount = 0, salaryCount = 0;
		Salary[] salaryArr = new Salary[2];
		Salary salary = null;
		Lotto lotto = null;
		while (true) {
			switch((Butt)JOptionPane.showInputDialog(
					null,	//frame
					"MATRIX PAGE", //frame title
					"SELECT MATRIX MENU", //ORDER
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //array of choices
					null //default
					)) {
			case EXIT: return;
			case INPUT_BMI:
				bmi = new BMI();
				bmi.setName(JOptionPane.showInputDialog("이름을 입력하세요")); 
				bmi.setHeight(Double.parseDouble(JOptionPane.showInputDialog("키를 입력하세요"))); 
				bmi.setWeight(Double.parseDouble(JOptionPane.showInputDialog("몸무게를 입력하세요")));
				bmi.setResult();
					//ver1
					/*String res = String.format("%s, %.1f mm, %.1f kg, %s",
					bmi.getName(),
					bmi.getHeight(),
					bmi.getWeight(),
					bmi.getResult());*/
					//ver2
					arr[count] = bmi;
					count++;
				break;
			case OUTPUT_BMI: 
				String output = "";
				for(count=0; count<arr.length;count++) {
					output += arr[count] + "\n";
				}
				JOptionPane.showMessageDialog(null, output);
				break;
			case INPUT_GRADE :
				grade = new Grade();
				grade.setName(JOptionPane.showInputDialog("이름을 입력하세요"));
				grade.setTotal(JOptionPane.showInputDialog("국어/영어/수학 점수를 입력하세요"));
				grade.setResult();
				gradeArr[gradeCount] = grade;
				gradeCount++;
				break;
			case OUTPUT_GRADE :
				String gradeOut = "";
				for(gradeCount=0; gradeCount<arr.length;gradeCount++) {
					gradeOut += gradeArr[gradeCount] + "\n";
				}
				JOptionPane.showMessageDialog(null, gradeOut);
				break;
			case INPUT_Salary :
				salary = new Salary();
				salary.setDept(JOptionPane.showInputDialog("부서"));
				salary.setName(JOptionPane.showInputDialog("이름"));
				salary.setSal(Integer.parseInt(JOptionPane.showInputDialog("봉급")));
				salary.setBonus(Integer.parseInt(JOptionPane.showInputDialog("상여금")));
				salaryArr[salaryCount] = salary;
				salaryCount++;
				break;
			case OUTPUT_Salary :
				String salaryOut = "";
				for(salaryCount=0; salaryCount<arr.length;salaryCount++) {
					salaryOut += salaryArr[salaryCount] + "\n";
				}
				JOptionPane.showMessageDialog(null, salaryOut);
				break;
 			case OUTPUT_Dept :
 				String splitTemp = "", splitDept[] = null; 
 				for(int i=0;i<salaryArr.length;i++) {
 					splitTemp += salaryArr[i] + "";
 					splitDept = splitTemp.split("\\|");
 				}
 				System.out.println(Arrays.toString(splitDept));
 				break;
 			case INPUT_LOTTO :
 				lotto = new Lotto();
 				lotto.setGameMoney(Integer.parseInt(JOptionPane.showInputDialog("게임비를 입금하세요 1000원 단위")));
 				for(int i = 0;i<lotto.getCount();i++) {
 					lotto.setBallNumber();
 					lotto.setLottoList();
 				}
 				break;
 			case OUTPUT_LOTTO :
 				JOptionPane.showMessageDialog(null, lotto.getLottoList());
 				break; 				
			default: break;
			}
		}
	}
}

