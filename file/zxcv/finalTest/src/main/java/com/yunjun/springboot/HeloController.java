 package com.yunjun.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yunjun.springboot.MyDataMongo;
import com.yunjun.springboot.repositories.MyDataMongoRepository;

@Controller
public class HeloController {
	@Autowired
	MyDataMongoRepository repository;
	
	/**
	 *
	 * @fn 		public ModelAndView index(ModelAndView mav)
	 * 
	 * @brief 	���� ������ ���� 
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	�� �������� �ҷ����� ���� �ʱ������� ����		[2019-06-20; ���϶�] \n
	 * 		   	FinaAll()�� �̿��� list�� ��� �����͸� ����	[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	�Է� ������ ���� 
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param	mav ModelAndView
	 *
	 * @remark 	�� �������� �ҷ����� ���� �ʱ������� ����[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");

		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	�Է� ������ ���� 
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	���� �Էµ� ���� �޾ƿ� �� ��ü�� ����		[2019-06-20; ���϶�] \n
	 *		   	save �޼ҵ带 �̿��� DB�� ����			[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView form(
			@RequestParam("name") String name, 
			@RequestParam("phone1") String phone1,
			@RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3,
			@RequestParam("email") String email,
			@RequestParam("memo") String memo,      
			ModelAndView mov) {
		MyDataMongo mydata = new MyDataMongo(name, email, memo, phone1, phone2, phone3);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}

	/**
	 *
	 * @fn 		public ModelAndView detail(ModelAndView mav)
	 * 
	 * @brief 	�� ��ȸ ������
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy �� �̿��� ���ǰ˻� �� ���	[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("detail");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView removecheck(ModelAndView mav)
	 * 
	 * @brief 	���� ���� Ȯ��������
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy �� �̿��� ���ǰ˻� �� ���� ���� Ȯ�������� ���	[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("edit");
		
		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView remove(ModelAndView mav)
	 * 
	 * @brief 	������ ����
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	deleteBy �� �̿��� ������ ���ǻ���	[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editpost(
			@RequestParam("id") String id, 
			@RequestParam("name") String name, 
			@RequestParam("phone1") String phone1,
			@RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3,
			@RequestParam("email") String email,
			@RequestParam("memo") String memo,      
			ModelAndView mov) {
		MyDataMongo mydata = new MyDataMongo(name, email, memo, phone1, phone2, phone3);
		repository.save(mydata);
		repository.deleteById(id);
		
		return new ModelAndView("redirect:/");
	}

	/**
	 *
	 * @fn 		public ModelAndView edit(ModelAndView mav)
	 * 
	 * @brief 	����������
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy�� �̿��� ���ǿ� �����Ǵ� �����͸� List�� ���� �� ȭ�鿡 ǥ��	[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView removecheck(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("delete");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView editpost(ModelAndView mav)
	 * 
	 * @brief 	������ ����
	 *
	 * @author 	���϶�
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	���� �Էµ� ���� �޾ƿ� �� ��ü�� ����	[2019-06-20; ���϶�] \n
	 *		   	save �޼ҵ带 �̿��� DB�� ����		[2019-06-20; ���϶�] \n
	 *			deleteBy�� �̿��� ���������� ����	[2019-06-20; ���϶�] \n
	 *
	 */
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView remove(@RequestParam("id") String id, ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}