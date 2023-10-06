package mvc.controller;

import mvc.entity.OrdersEntity;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrdersRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/")
public class OrderController {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    ProductRepository productRepository;
    @RequestMapping(method = RequestMethod.GET)
    public String showOrder(Model model){
        List<OrdersEntity> ordersList = (List<OrdersEntity>) ordersRepository.findAll();
        model.addAttribute("ordersList", ordersList);
        return "salemanagement/home";
    }
    @RequestMapping(value = "/viewdetail",method = RequestMethod.GET)
    public String viewDetail(@RequestParam("orderId") int orderId, Model model) {
        OrdersEntity ordersList = ordersRepository.findOrderById(orderId);
        if (ordersList == null) {
            return "error";
        }
        model.addAttribute("ordersList", ordersList);
        return "salemanagement/home";
    }
//    @RequestMapping(method = RequestMethod.GET)
//    public String showOrderDetails(Model model){
//        List<OrdersDetailsEntity> ordersDetailsList =(List<OrdersDetailsEntity>) orderDetailsRepository.findAll();
//        model.addAttribute("ordersDetails", ordersDetailsList);
//        return "orders/home";
//    }
}