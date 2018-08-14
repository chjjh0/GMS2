package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class FileDemo {
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt";
		try {
			File file = new File(PATH);
			//true는 이어 쓰기, 없으면 덮어쓰기
			FileWriter fw = new FileWriter(PATH, true); 
			FileReader fr = new FileReader(PATH);
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("1.전송 2.읽기 0.종료");
				switch(s.next()) {
				case "0": return;
				case "1":
					System.out.println("메세지 입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();
					break;
				case "2":
					System.out.println("메세지 보기");
					String msg = reader.readLine();
					System.out.println(msg);
					/*String msg = "";
					while((msg=reader.readLine())!=null) {
						System.out.println(msg);
					}*/
					reader.close();
					break;
				default :
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
//inner Class는 public 생략 기준은 현재 클래스에서만 쓰는가 이며 다른 클래스에서 쓸 경우 public 포함
	class FileName{
		public String getPath() {
			return path;
		}
		public String getSep() {
			return sep;
		}
		public String getExt() {
			return ext;
		}
		public String getFilename() {
			return filename;
		}
		private String path, sep, ext, filename;
		public FileName(String path) {
			this.path = path;
			//File.separator 시스템별 자동 파일 구분자
			this.sep = File.separator; 			
			//확장자 추출: exe, java, xls 
			this.ext = this.path.substring(
					this.path.lastIndexOf(".")+1);
			this.filename = this.path.substring(
					this.path.lastIndexOf("\\")+1,
					this.path.lastIndexOf("."));
		}
		
		
		
	}
