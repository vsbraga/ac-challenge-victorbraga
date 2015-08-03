package ac.java.challenge;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ac.java.challenge.dao.OrderDAO;
import ac.java.challenge.model.Orders;
 

@Controller
public class HomeController {
     
    @Autowired
    private OrderDAO orderDao;
     
    @RequestMapping(value="/")
    public ModelAndView home() {
        List<Orders> listOrders = orderDao.list();
        ModelAndView model = new ModelAndView("home");
        model.addObject("orderList", listOrders);
        return model;
    }
    
    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
	public ModelAndView newOrder() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("order", new Orders());
		return model;		
	}
    
    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Orders order = orderDao.get(id);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", order);
		return model;		
	}
    
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    
	public ModelAndView deleteUser(HttpServletRequest request) {
		int orderId = Integer.parseInt(request.getParameter("id"));
		orderDao.delete(orderId);
		return new ModelAndView("redirect:/");		
	}
    
    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Orders order) {
    	orderDao.saveOrUpdate(order);
		return new ModelAndView("redirect:/");
	}
     
}