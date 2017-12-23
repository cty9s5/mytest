package cn.itcast.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.service.NoticeService;

@Controller
public class NoticeController {
	//注入业务层
	@Autowired
	private NoticeService noticeService;

	/** 查询全部公告 */
	@GetMapping("/findAll")
	@ResponseBody
	public List<Notice> findAll(){
		System.err.println("222222222222222222222");
		
		return noticeService.findAll();
	}
	
	//跳转到分页查询页面
	@GetMapping("/show")
	public String show(){
		return "/html/notice.html";
	}
	
	//分页查询
	@PostMapping("/findByPage")
	@ResponseBody  //返回json格式
	public Map<String, Object> findByPage(@RequestParam(value="page",defaultValue="1")Integer page,
												@RequestParam(value="rows",defaultValue="15")Integer rows){
		Map<String, Object> map = noticeService.findByPage((page-1)*rows, rows);			
		return map;
	}

}
