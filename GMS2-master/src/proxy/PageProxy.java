package proxy;
import javax.servlet.http.HttpServletRequest;
import lombok.Data;
@Data
public class PageProxy implements Proxy{
	//SearchCommand에서 getPagination으로 객체 호출
	//carryOut 에서 객체화 및 수행 후 pagination 에 담아줌
	private Pagination pagination;
	//request는 쓸일이 없는데 있네? searchcommand 에서 request 전달 안해서 밑에서 null
	private HttpServletRequest request;
	
	@Override
	public void carryOut(Object o) {
		System.out.println("< PageProxy_carryOut >");
		System.out.println("object: "+o);
		/*System.out.println("pageNum: "+request.getParameter("pageNum"));
		System.out.println("domain: "+request.getParameter("domain"));
		System.out.println("page: "+request.getParameter("page"));*/
		this.pagination = new Pagination();
		pagination.carryOut(o);
		System.out.println("< pagination.carryOut 처리 후 >");
		System.out.println("pagination.carryOut: "+this.pagination);
	}
}
