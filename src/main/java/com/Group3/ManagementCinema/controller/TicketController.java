package com.Group3.ManagementCinema.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.service.TicketService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/tickets")
	public String viewTicket(Model model) {
		model.addAttribute("listTickets", ticketService.getAllTickets());
		return "";
	}
	
	@GetMapping("/showNewTicketForm")
    public String showNewTicketForm(Model model) {
        // create model attribute to bind form data
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "/ticket/ticket_new";
    } 
	
	@GetMapping("/qrTicket/{id}")
	public String qrTicket(@PathVariable(value = "id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "/ticket/qrCode";
	}
	
	@GetMapping("/searchTicketById/{id}")
	public String searchTicketById(@PathVariable(value = "id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "/ticket/ticket";
	}
	
	@PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		
		Ticket newTicket = ticketService.saveTicket( 
	        			ticket.getIdVe(),
	        			ticket.getLichChieu().getIdLichChieu(),
	        			ticket.getTaiKhoan().getEmail(),
	        			ticket.getGhe().getIdGhe(),
			            ticket.getThoigianMua());
		return "redirect:/qrTicket/" + newTicket.getIdVe();
    }
	
	@PostMapping("/updateTicket")
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		ticketService.saveTicket(ticket);
		return "";
	}		
	
	@GetMapping("/showFormForUpdateTicket/{id}")
	public String showFormForUpdateTicket(@PathVariable(value = "id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "";
	}
	
	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable(value = "id") Long id) {
		this.ticketService.deleteTicketById(id);
		return "";
	}
	
	@GetMapping("/qrcode/{id}")
    public void generateQRCode(@PathVariable(value = "id") String id, HttpServletResponse response) throws IOException {
        String url = "localhost:8080/searchTicketById/" + id;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix;
        try {
            bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 200, 200);
        } catch (WriterException e) {
            throw new IOException("Could not generate QR Code", e);
        }
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
    
	}
}
