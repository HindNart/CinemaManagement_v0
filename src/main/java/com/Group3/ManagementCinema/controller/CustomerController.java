package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.service.CustomerService;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Hiển thị danh sách khách hàng
//    @GetMapping("/adCustomer.html")
//    public String showCustomerList(Model model) {
//        model.addAttribute("listCustomer", customerService.getAllCustomers());
//        return "admin/adCustomer"; // Trả về template adCustomer.html trong thư mục templates/admin/
//    }

    // Hiển thị form thêm khách hàng mới
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "cusNew"; // Trả về template cusNew.html trong thư mục templates/
    }

    // Tìm kiếm khách hàng theo ID
    @GetMapping("/searchCustomer")
    public String searchCustomer(@RequestParam("id") String id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "cusSearch"; // Trả về template cusSearch.html trong thư mục templates/
    }

    // Lưu thông tin khách hàng mới vào cơ sở dữ liệu
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/admin/adCustomer.html"; // Sau khi lưu, chuyển hướng lại danh sách khách hàng
    }

    // Hiển thị form cập nhật thông tin khách hàng
    @GetMapping("/showFormForUpdateCustomer/{id}")
    public String showFormForUpdateCustomer(@PathVariable(value = "id") String id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "cusUpdate"; // Trả về template cusUpdate.html trong thư mục templates/
    }

    // Xóa khách hàng
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") String id) {
        customerService.deleteCustomerById(id);
        return "redirect:/admin/adCustomer.html"; // Sau khi xóa, chuyển hướng lại danh sách khách hàng
    }
}
