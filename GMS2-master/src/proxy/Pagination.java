package proxy;
import lombok.Data;
import service.MemberServiceImpl;
@Data
public class Pagination implements Proxy{
	int pageNum,count,pageSize,blockSize,
	beginPage,endPage,
	beginRow,endRow,
	prevBlock,nextBlock;
	boolean existPrev,exisNext; 
	
	@Override
	public void carryOut(Object o) {
		System.out.println("< pagination >");
		//기본 set
		this.pageNum = (int) o; 
		this.pageSize = 5; 
		this.blockSize = 5;
		this.count = MemberServiceImpl.getInstance().count();
		//시작, 끝 page set
		//this.beginPage = Math.floorDiv(pageNum-1, pageSize)*pageSize+1;
		this.beginPage = ((pageNum-1)/pageSize)*pageSize+1;
		this.endPage = (count>(beginPage+(blockSize-1))*pageSize)?
				beginPage+(blockSize-1):(int)(Math.ceil(count/(double)pageSize));
		//시작, 끝 Row set
		this.beginRow = (pageNum-1)*pageSize+1;
		this.endRow = (count>pageNum*pageSize)?pageNum*pageSize:count;
		//이전, 다음 Block set
		this.prevBlock = beginPage -1;
		this.nextBlock = endPage +1;
		//
		this.existPrev = (beginPage>1);
		this.exisNext = (count>endPage*5);
		System.out.println(toString());
	}
}
