package template;
import java.sql.PreparedStatement;
import java.util.*;
import enums.Vendor;
import factory.DataBaseFactory;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTemplate {
	int number;
	Object o;
	List<Object> list;
	Map<String,Object> map;
    PreparedStatement pstmt;
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    
    private void pStmtInit() {
    	//DB 연결
    	System.out.println("< QueryTemplate_pStmtInit >");
    	try {
			this.pstmt = DataBaseFactory.createDataBase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public final void play(Map<?, ?> param){
    	//field 초기화
    	//DB 연결 준비 (driver, userid, password)
    	System.out.println("< QueryTemplate >");
    	System.out.println("< play() Param  >");
    	this.number = 0;
    	this.o = null;
    	this.list = new ArrayList<>();
    	this.map = new HashMap<>();
	    this.map.put("vendor", Vendor.ORACLE);
	    this.map.put("username", DBConstant.USER_NAME);
	    this.map.put("password", DBConstant.PASSWORD);
	    Iterator<?> keys = param.keySet().iterator();
	    while(keys.hasNext()) {
	    	String key = (String) keys.next();
	    	this.map.put(key, param.get(key));
	    }
	    System.out.println(" < QueryTemplate_field setting 완료 > ");
        initialize();
        System.out.println(" < QueryTemplate_initialize() 실행 ");
        pStmtInit();
        System.out.println(" < QueryTemplate_pStmtInit() 실행 ");
        startPlay();
        System.out.println(" < QueryTemplate_startPlay() 실행 ");
        endPlay();
        System.out.println(" < QueryTemplate_endPlay() 실행 ");
   }
    
    public final void play() {
    	System.out.println("< QueryTemplate >");
    	System.out.println("< play() noParam  >");
		this.number = 0;
		this.map = new HashMap<>();
		this.map.put("vendor",Vendor.ORACLE);
		this.map.put("username", DBConstant.USER_NAME);
		this.map.put("password", DBConstant.PASSWORD);
		initialize();
		pStmtInit();
		startPlay();
		endPlay();
	}
}
