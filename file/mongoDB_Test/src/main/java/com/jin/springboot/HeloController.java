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
		mav.addObject("title", "�ּҷ�");
		mav.addObject("msg", "����ó�� ������ּ���");

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
		mav.addObject("title", "�Է� ������");
		mav.addObject("msg", "�����͸� �Է����ּ���");

		return mav;
	}
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	�Է� ������ ���� 
	 *
	 * @author 	������
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
			@RequestParam("id") String id, 
			@RequestParam("name") String name,
			@RequestParam("phone") int phone, 
			@RequestParam("email") String email,
			@RequestParam("memo") String memo,
			ModelAndView mov) 
	{
		MyDataMongo mydata = new MyDataMongo(name, id, phone, email, group, memo);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}
}