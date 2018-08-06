"use strict";
var router = ( ()=>{
           return {move : x => {
                location.href =
                     x.context+"/"
                     +x.domain
                     +".do?action="+x.action
                     +"&page="+x.page;
                }};
})();  
var service = (()=>{
	return {
		nullChecker : x=>{
			var json = {
					checker : true,
					text : '필수 입력값이 없습니다.'}; 
			for(var key in x){ 
				if(x[key] === ""){
					json.checker = false;
				}
			}
			return json;
		}};
})();
/*var admin = (()=>{
	return{
		check : x=>{
		var isAdmin = confirm('관리자입니까?');
			if(isAdmin){
				var password = prompt('관리자 비밀번호를 입력 바랍니다');
				if(password == 1){
					route.move({
						context : x,
						domain : 'admin',
						action : 'list',
						page : 'main'});
				}
				} else {
					alert('관리자만 접근 가능합니다');
				}
			}
};})();*/
//memberId,teamId,name,ssn,roll,pass,age,gender;
var member = (()=> {
	var _memId,_ssn,_password,_name,_age,_teamId,_gender,_roll;		
	var setMemId = (memId)=> {
		if(memId.length>=2){
			this._memId = memId;
		}else{
			alert('아이디는 2자 이상입력 하세요.');
		}
	}
	var setSsn = (ssn)=> {
		var flag = false;
		if(ssn.substring(7,8)==7 || ssn.substring(7,8)==8){

		}else if(parseInt(ssn.substring(2,4))<=0 
				|| parseInt(ssn.substring(2,4))>=13){
			
		}else if(parseInt(ssn.substring(4,6))<=0 
				|| parseInt(ssn.substring(4,6))>=32){
			
		}else if(ssn.substring(6,7)==="-"){
			flag = true;
		}
		if(flag){
			this._ssn = ssn;
		}else{
			alert('잘못된 주민번호');
		}
	}
	var setName = (name)=> {this._name = name;}
	var setPassword = (password)=> {this._password = password;}
	var setAge = x=> {
		this._age = (new Date().getFullYear())-parseInt('19'+x.substring(0,2));
		}
	var setTeamId = (teamId)=> {this._teamId = teamId;}
	var setRoll = (roll)=> {this._roll = roll;}
	var setGender = x=> {
		var gender;
		this.gender = (parseInt(x.substring(7,8)) % 2 == 1) ? '남자' : '여자';
		/*if(parseInt(x.substring(7,8)) % 2 == 1){
			gender = '남';
		}else{
			gender = '여';
		}*/
		this._gender = gender;
		}
	var getMemId = ()=> {return this._memId;}
	var getSsn =  ()=> {return this._ssn;}
	var getPassword =  ()=> {return this._password;}
	var getName =  ()=> {return this._name;}
	var getTeamId =  ()=> {return this._teamId;}
	var getSsn =  ()=> {return this._ssn;}
	var getRoll =  ()=> {return this._roll;}
	var getAge =  ()=> {return this._age;}
	var getGender =  ()=> {return this._gender;}
	return {
		setMemId : setMemId,
		setSsn : setSsn,
		setPassword : setPassword,
		setAge : setAge,
		setTeamId : setTeamId,
		setName : setName,
		setGender : setGender,
		setRoll : setRoll,
		getMemId : getMemId,
		getSsn : getSsn,
		getPassword : getPassword,
		getAge : getAge,
		getTeamId : getTeamId,
		getName : getName,
		getGender : getGender,
		getRoll : getRoll,
		join : x=>{
			member.setMemId(x.memId);
			member.setPassword(x.password);
			member.setName(x.name);
			member.setSsn(x.ssn);
			member.setAge(x.ssn);
			member.setGender(x.ssn);
		}
	}
})();