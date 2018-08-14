package controller;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.*;
import enums.Action;
import enums.Path;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD :
			Carrier.redirect(request, response,
					"/member.do?action=move&page=login");
			break;
		case SEARCH :
			Carrier.forward(request, response);
			break;
		case RETRIEVE :
			Carrier.forward(request, response);
			break;
		case COUNT :
			Carrier.redirect(request, response, "");
			break;
		case MODIFY :
			Carrier.forward(request, response);
			break;
		case REMOVE :
			Carrier.redirect(request, response,"");
			break;
		case MOVE : 
			Carrier.forward(request, response);
			break;
		case LOGIN :
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response, 
						"/member.do?action=move&page=login");
			}
			break;
		case FILEUPLOAD : 
			System.out.println("1. 멤버컨트롤러 파일업로드 케이스 진입");
			if(!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("업로드파일이 업습니다.");
				return;
			}
			System.out.println("2. 업로드 파일 존재함");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 40);  //40MB
			upload.setSizeMax(1024 * 1024 * 50); //50MB
			List<FileItem> items = null;
			try {
				System.out.println("3. try 내부로 진입");
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request));
				System.out.println("4. items 생성");
				Iterator<FileItem>iter = items.iterator();
				while(iter.hasNext()) {
					System.out.println("5. while 진입");
					FileItem item = (FileItem) iter.next();
					if(!item.isFormField()) {
						System.out.println("6. if 진입");
						String fieldName = item.getFieldName();
						String fileName = item.getName();
						boolean isINMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						file = new File(Path.UPLOAD_PATH+fileName);
						item.write(file);
						System.out.println("7. 파일 업로드 성공");
						System.out.println("file: "+file.toString());
						System.out.println(fieldName);
						System.out.println(fileName.substring(fileName.lastIndexOf(".")+1));
						System.out.println(fileName.substring(0,fileName.lastIndexOf(".")));
						System.out.println(isINMemory);
						System.out.println(sizeInBytes);
					}else {
						System.out.println("8. 파일 업로드 실패");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("9. 캐리어 떠나기 전");
			Carrier.redirect(request, response, "/member.do?action=retrieve&page=main");
			break;
		default:break;
		}
	}

}
