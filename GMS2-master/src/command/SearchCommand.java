package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
		this.request = request;
		this.domain = request.getServletPath().substring(1,  
				request.getServletPath().indexOf("."));
		this.action = request.getParameter("action");
		this.page = request.getParameter("page");
		execute();
		/*setRequest(request);
		setDomain(request.getServletPath().substring(1,  
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();*/ 
		System.out.println("< SearchCommand 생성자 >");
		System.out.println("Domain: "+getDomain());
	}
	
	@Override
	public void execute() {
		List<?> members = null;
		Map<String,Object>paramMap = new HashMap<>();
		List<MemberBean> members2 = null; 
		String pageNum = null;
		PageProxy pxy = new PageProxy();
		//Map.put을 할 때 원래 Object, Object 방식이라 String, Object 로 제네릭 해줌
		
		if(!(request.getParameter("option")==null)) {
			//검색리스트 코딩영역
		/*	members = MemberServiceImpl.getInstance().findSome(
					request.getParameter("table")+"/"+
					request.getParameter("option")+"/"+
					request.getParameter("word")); */
		}else {//전체 리스트 코딩 영역
			System.out.println("< SearchCommand >");
			System.out.println("pageNum: "+request.getParameter("pageNum"));
			//pageNum이 Int 로 많이 활동한다면 처음 왔을 때 Integer로 바꿔서 활동하게 하자 
			pageNum = request.getParameter("pageNum");
			//pageNum 초기화를 1로 해주면 안될까? 아래와 같이 말고 
			//carryOut 실행이 밑에 있으므로 위 방식대로 하려면 분리 필요
			pxy.carryOut((pageNum==null)?
					1:
					Integer.parseInt(pageNum));
			//포장_1 (Map)
			 
			Pagination page = pxy.getPagination();
			//arr1의 역할: paramMap의 keyName에 사용할 이름 set
			String[] arr1 = {"domain","beginRow","endRow"};
			//arr2의 역할: MEMBER, page에 set 된 beginRow, endRow를 담는다
			String[] arr2 = {
					Domain.MEMBER.toString(),
					String.valueOf(page.getBeginRow()),
					String.valueOf(page.getEndRow())
					};
			//arr1, arr2 를 합쳐 Map setting
			for(int i =0;i<arr1.length;i++) {
				paramMap.put(arr1[i], arr2[i]);
			}
			//포장_2
			//setAttribute에 page에 있는 모든 정보
			request.setAttribute("page", page);
			//members에 DB에 다녀온 결과
			//members 는 왜 인스턴스화 시키지 않은결까? 그럼에도 null error가 나지 않는다
			//members 는 generic ? 타입이고 잘 보면 List임에도 추가시 members.add가 아닌 할당으로 줌
			//즉 현재로썬 List<?>의 활용도는 좋지 못하여 
			//List<MemberBean> members를 MeberBean으로 바꿔도 무방
			//그러나 searchCommand 안에서의 확장성 면에서 List<?> 가 활용도 떨어지는건사실
			//command 에서 모든 command가 사용하게 다른 곳에 놓으면 활용도 높아질 듯
			members2 = MemberServiceImpl.getInstance().search(paramMap);
		}
		//공통 코딩 영역
		request.setAttribute("list", members2);
		super.execute();
	}
}
