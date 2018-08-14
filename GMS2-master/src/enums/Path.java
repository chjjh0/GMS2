package enums;

public enum Path {
	VIEW_PATH,MAIN_PAGE,UPLOAD_PATH;
	@Override
	public String toString() {
		String res = "";
		switch (this) {
		case VIEW_PATH:res = "/WEB-INF/view/";break;
		case MAIN_PAGE:res = "/main.jsp";break;
		case UPLOAD_PATH:res = 
				"C:\\Users\\1027\\JavaWorkspace\\workspace\\GMS2-master\\WebContent\\resources\\img\\upload\\";
			break;
		default:break;}
		return res;
	}
}