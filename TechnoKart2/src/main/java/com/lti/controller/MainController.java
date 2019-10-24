package com.lti.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lti.entity.CustomerEntity;
import com.lti.entity.ProductEntity;
import com.lti.entity.RetailerEntity;
import com.lti.service.AdminService;
import com.lti.service.CartService;
import com.lti.service.CustomerService;
import com.lti.service.RetailerService;
import com.lti.service.WishlistService;

@Controller
public class MainController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
    private RetailerService retailerService;
	
	@Autowired
    private AdminService adminService;
	
	@Autowired
    private CartService cartService;
	
	@Autowired
    private WishlistService wishlistService;
	
	
	@RequestMapping(path="/login.lti" , method=RequestMethod.POST)
	public String customerGet(@RequestParam("u_email") String u_email, @RequestParam("u_pass") String u_pass, HttpServletRequest request, HttpSession session, Map model)
	{
		 System.out.println("now im here");
		/*List c1 = customerService.get(u_email);
		Iterator i = c1.iterator();*/
		 CustomerEntity customerEntity= (CustomerEntity)customerService.get(u_email);
		 System.out.println("abcd");
		String s = customerEntity.getU_pass();
		String s1= customerEntity.getU_name();
		if(s.equals(u_pass)) {
			//session.setAttribute("u_email", u_email);
			System.out.println(s1);
			
			session=request.getSession();
			session.setAttribute("u_name", s1 );
			session.setAttribute("u_id", customerEntity.getU_id());
			System.out.println("session created" + session.getAttribute("u_id"));
			return "homePage.jsp";
		}
		else {
			return "firstLogin.jsp";
		}
	  }
	
	@RequestMapping(path = "/signup.lti",method=RequestMethod.POST)
	public String customerRegister(CustomerEntity customerEntity , Map model ) {
		System.out.println("hii1");
		customerService.register(customerEntity);
		System.out.println("hiiiiiiiii1");
		return "homePage.jsp";
		}

   @RequestMapping(path="/addProduct.lti" ,method=RequestMethod.POST)
    public String productRegister(ProductEntity productEntity , Map model, @RequestParam CommonsMultipartFile[] p_img ) {
	    System.out.println("hello1");
	    retailerService.register(productEntity);
	    //productEntity.setP_img(getBinaryStream(p_img));
	    System.out.println("hellooo1");
	    return "homePage.jsp";
	  }
   
   @RequestMapping(path="/addRetailer.lti",method=RequestMethod.POST)
	public String register(RetailerEntity retailerEntity , Map model ) {
		System.out.println("hello1");
		adminService.register(retailerEntity);
		System.out.println("hellooo1");
		return "homePage.jsp";
		}
   
   @RequestMapping(path = "/adminLogin.lti" ,method=RequestMethod.POST)
	public String adminGet(@RequestParam("a_email") String a_email, @RequestParam("a_pass") String a_pass)
	{
		 System.out.println("now im here");
		List c1 = adminService.get(a_email);
		Iterator i = c1.iterator();
		
		String s = (String) i.next();
		if(a_pass.equals(s)) {
			return "homePage.jsp";
		}
		else {
			return "firstLogin.jsp";
		}
	}

   @RequestMapping(path = "/retLogin.lti" ,method=RequestMethod.POST)
    public String retailerGet(@RequestParam("r_email") String r_email, @RequestParam("r_pass") String r_pass)
       {
	   System.out.println("now im here");
	    List c1 = retailerService.get(r_email);
	   Iterator i = c1.iterator();
	   String s = (String) i.next();
	   if(r_pass.equals(s)) {
		return "homePage.jsp";
	   }
	   else {
		return "firstLogin.jsp";
	   }
      }
   
   @RequestMapping(path="/uReset.lti" , method=RequestMethod.POST)
	public String userReset(@RequestParam("old_pass") String oldPass, @RequestParam("new_pass") String newPass)
	{
	   String s1=customerService.reset(oldPass,newPass);
	   System.out.println(s1);
	   if(s1.equalsIgnoreCase("success"))
	   return "homePage.jsp";
	   else
		   return "uPassReset.jsp";
	}
   
   @RequestMapping(path="/rReset.lti" , method=RequestMethod.POST)
	public String retailerReset(@RequestParam("old_pass") String oldPass, @RequestParam("new_pass") String newPass)
	{
	   String s1=retailerService.reset(oldPass,newPass);
	   System.out.println(s1);
	   if(s1.equalsIgnoreCase("success"))
		   return "homePage.jsp";
		   else
			   return "rPassReset.jsp";
	}
   
   @RequestMapping(path="/aReset.lti" , method=RequestMethod.POST)
	public String adminReset(@RequestParam("old_pass") String oldPass, @RequestParam("new_pass") String newPass)
	{
	   String s1=adminService.reset(oldPass,newPass);
	   System.out.println(s1);
	   if(s1.equalsIgnoreCase("success"))
		   return "homePage.jsp";
		   else
			   return "aPassReset.jsp";
	}
   
   @RequestMapping(path="/prodToCart.lti" , method=RequestMethod.POST)
	public String addProd(HttpSession session, HttpServletRequest request)
	{
	   int u_id=(int) session.getAttribute("u_id");
	   session.setAttribute("p_id", request.getAttribute("p_id"));
	   int p_id=(int) session.getAttribute("p_id");
	   String s1=cartService.addProd(p_id,u_id);
	   System.out.println(s1);
			   return "homePage.jsp";
	}
   
   @RequestMapping(path="/prodToWish.lti" , method=RequestMethod.POST)
  	public String addWish(HttpSession session, HttpServletRequest request)
  	{
  	   int u_id=(int) session.getAttribute("u_id");
  	   session.setAttribute("p_id", request.getAttribute("p_id"));
  	   int p_id=(int) session.getAttribute("p_id");
  	   String s1=wishlistService.addProd(p_id,u_id);
  	   System.out.println(s1);
  			   return "homePage.jsp";
  	}
   
   
	}   
