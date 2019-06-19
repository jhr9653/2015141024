package com.jin.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jin.springboot.repositories.MyDataMongoRepository;

@Controller
public class HeloController {

	@Autowired
	MyDataMongoRepository repository;
	
	/**
	 *
	 * @fn 		public ModelAndView index(ModelAndView mav)
	 * 
	 * @brief 	메인 페이지 설정 
	 *
	 * @author 	지하람
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정		[2019-06-20; 지하람] \n
	 * 		   	FinaAll()를 이용해 list에 모든 데이터를 저장	[2019-06-20; 지하람] \n
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("title", "주소록");
		mav.addObject("msg", "연락처를 등록해주세요");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	지하람
	 * @date 	2019-06-20
	 *
	 * @param	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정[2019-06-20; 지하람] \n
	 *
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		mav.addObject("title", "입력 페이지");
		mav.addObject("msg", "데이터를 입력해주세요");

		return mav;
	}
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	강석진
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	폼에 입력된 값을 받아온 후 객체에 저장		[2019-06-20; 지하람] \n
	 *		   	save 메소드를 이용해 DB에 저장			[2019-06-20; 지하람] \n
	 *
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView form(
			@RequestParam("id") String id, 
			@RequestParam("name") String name,
			@RequestParam("phone") int phone, 
			@RequestParam("email") String email,
			@RequestParam("group") String group,
			@RequestParam("memo") String memo,
			ModelAndView mov) 
	{
		MyDataMongo mydata = new MyDataMongo(name, id, phone, email, group, memo);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}
	/**
	 *
	 * @fn 		public ModelAndView detail(ModelAndView mav)
	 * 
	 * @brief 	상세 조회 페이지
	 *
	 * @author 	지하람
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy 를 이용한 조건검색 후 출력	[2019-06-20; 지하람] \n
	 *
	 */
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("detail");
		mav.addObject("title", "Detail Page");
		mav.addObject("msg", "상세 조회 및 수정 삭제");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
	/**
	 *
	 * @fn 		public ModelAndView removecheck(ModelAndView mav)
	 * 
	 * @brief 	삭제 유무 확인페이지
	 *
	 * @author 	지하람
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy 를 이용한 조건검색 후 삭제 유무 확인페이지 출력	[2019-06-20; 지하람] \n
	 *
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView removecheck(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "Delete Page");
		mav.addObject("msg", "삭제 유무 확인");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
}