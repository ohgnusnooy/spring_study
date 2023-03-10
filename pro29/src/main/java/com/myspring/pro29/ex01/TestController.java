package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/test/*")
public class TestController {
  static Logger logger = LoggerFactory.getLogger(TestController.class);
	
  @RequestMapping("/hello")
  public String hello() {
	return "Hello REST!!";
  } 
  
  @RequestMapping("/member")
  public MemberVO member() {
    MemberVO vo = new MemberVO();
    vo.setId("hong");
    vo.setPwd("1234");
    vo.setName("ȫ?浿");
    vo.setEmail("hong@test.com");
    return vo;
  } 	
  
  
  @RequestMapping("/membersList")//MemberVO ??ü?? ?????? ArrayList??ü?? ????
  public List<MemberVO> listMembers () {//MemberVO ??ü?? 10?? ?????? ArrayList?? ????
    List<MemberVO> list = new ArrayList<MemberVO>();
	for (int i = 0; i < 10; i++) {
	  MemberVO vo = new MemberVO();
	  vo.setId("hong"+i);
	  vo.setPwd("123"+i);
	  vo.setName("ȫ?浿"+i);
	  vo.setEmail("hong"+i+"@test.com");
	  list.add(vo);
	}
	
    return list; //ArrayList?? JSON???? ?????????? ????
  }	
  
  @RequestMapping("/membersMap")
  public Map<Integer, MemberVO> membersMap() {
    Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();//MemberVO ??ü?? ?????? HashMap ??ü?? ????
    for (int i = 0; i < 10; i++) {//MemberVO ??ü?? HashMap?? ????
      MemberVO vo = new MemberVO();
      vo.setId("hong" + i);
      vo.setPwd("123"+i);
      vo.setName("ȫ?浿" + i);
      vo.setEmail("hong"+i+"@test.com");
      map.put(i, vo); 
    }
    
    return map; //HashMap ??ü?? ?????????? ????
  } 	
  
  @RequestMapping(value= "/notice/{num}" , method = RequestMethod.GET)//?????????? ??û ?? {num} ?κ??? ???? @PathVariable?? ??????
  public int notice(@PathVariable("num") int num ) throws Exception {//??û URL???? ?????? ???? num?? ?ڵ????? ?Ҵ???
	  return num;
  }	

  @RequestMapping(value= "/info", method = RequestMethod.POST)
  public void modify(@RequestBody MemberVO vo ){//Json???? ???۵? ?????͸? MemberVO ??ü?? ?Ӽ??? ?ڵ????? ????
    logger.info(vo.toString());
  }
  
  @RequestMapping("/membersList2")
  public  ResponseEntity<List<MemberVO>> listMembers2() //ResponseEntity?? ????
  {
	List<MemberVO> list = new ArrayList<MemberVO>();
	for (int i = 0; i < 10; i++) {
	  MemberVO vo = new MemberVO();
	  vo.setId("lee" + i);
	  vo.setPwd("123"+i);
	  vo.setName("?̼???" + i);
      vo.setEmail("lee"+i+"@test.com");
	  list.add(vo);
	}
    return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);//?????ڵ? 500???? ????
  }	
  
  
	@RequestMapping(value = "/res3")
	public ResponseEntity res3() {
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "text/html; charset=utf-8");//?????? ???????? ?????? ???ڵ??? ????
	    
	    //?????? ?ڹٽ?ũ??Ʈ ?ڵ带 ???ڿ??? ?ۼ?
	    String message = "<script>";
		message += " alert('?? ȸ???? ?????մϴ?.');";
		message += " location.href='/pro29/test/membersList2'; ";
		message += " </script>";
		
		return  new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);//ResponseEntity?? ?̿??? HTML ???????? ????
	}
	
}
