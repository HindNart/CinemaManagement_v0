package com.Group3.ManagementCinema.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.service.ChairService;
import com.Group3.ManagementCinema.service.CinemaRoomService;

@Controller
public class CinemaRoomController {
	@Autowired
	private CinemaRoomService cinemaRoomService;
	@Autowired
	private ChairService chairService;
	@GetMapping("/showCinemaRoom")
	public String viewHomePage(Model model) {
		model.addAttribute("listCinemaRooms", cinemaRoomService.getAllCinemaRooms());
		return "/cinemaRoom/cinemaRoom";
	}
	
	@GetMapping("/showNewCinemaRoomForm")
	public String showNewMovieForm(Model model) {
		// create model attribute to bind form data
		CinemaRoom cinemaRoom = new CinemaRoom();
		model.addAttribute("cinemaRoom",  cinemaRoom);
		return "/cinemaRoom/cinemaRoom_new";
	}
	
	@GetMapping("/searchCinemaRoomById")
	public String searchCinemaRoomById(@RequestParam("id") String id, Model model) {
		model.addAttribute("cinemaRoom", cinemaRoomService.getCinemaRoomById(id));
		return "cinemaRoom_search";
	}
	
	@GetMapping("/searchCinemaRoom")
	public String searchCinemaRoom(@RequestParam("id") String id, Model model) {
		model.addAttribute("cinemaRoom", cinemaRoomService.findCinemaRoom(id));
		return "/cinemaRoom/cinemaRoom_search";
	}
	
	@PostMapping("/saveCinemaRoom")
    public String saveCinemaRoom(@ModelAttribute("cinemaRoom") CinemaRoom cinemaRoom, RedirectAttributes redirectAttributes,@RequestParam("numRows") int numRows,
    		@RequestParam Map<String, String> allParams) {
		CinemaRoom existCineRoom = cinemaRoomService.getCinemaRoomById(cinemaRoom.getIdPhong());
        if (existCineRoom == null) {
        	cinemaRoomService.saveCinemaRoom(cinemaRoom);
        	for(int i = 1; i<=numRows;i++ ) {
        		// Lấy ký tự dãy (A, B, ...)
        	    String rowLetter = String.valueOf((char) (64 + i)); //Hàng ghế
        	    int numberOfSeats = Integer.parseInt(allParams.getOrDefault("day" + i, "0")); // Số lượng ghế
                String seatType = allParams.getOrDefault("seatType" + i, "normal"); // Loại ghế
                for(int j = 1; j<=numberOfSeats; j++) {
                	Chair chair = new Chair();
                	chair.setGheSo(j);
                	chair.setHangGhe(rowLetter);
                	chair.setLoaiGhe(seatType);
                	chair.setTrangThai(1);
                	chair.setIdPhong(cinemaRoom);
                	if(seatType.equals("normal")) {
                		chair.setGiaGhe(60000);
                	}else {
                		chair.setGiaGhe(120000);
                	}
                	chairService.saveChair(chair);
                }
                
        	}
            redirectAttributes.addFlashAttribute("message", "Thêm phòng chiếu thành công!");
        } else {
        	redirectAttributes.addFlashAttribute("message", "Thêm phòng chiếu thất bại. Phòng chiếu đã tồn tại. Vui lòng thử lại!");
        }
        return "redirect:/showNewCinemaRoomForm";
    }
	
	@PostMapping("/updateCinemaRoom")
	public String updateCinemaRoom(@ModelAttribute("cinemaRoom") CinemaRoom cinemaRoom) {
		cinemaRoomService.saveCinemaRoom(cinemaRoom);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdateCinemaRoom/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
		CinemaRoom cinemaRoom = cinemaRoomService.getCinemaRoomById(id);
		model.addAttribute("cinemaRoom", cinemaRoom);
		return "/cinemaRoom/cinemaRoom_update";
	}
	
	@GetMapping("/deleteCinemaRoom/{id}")
	public String deleteCinemaRoom(@PathVariable(value = "id") String id) {
		this.cinemaRoomService.deleteCinemaRoomById(id);
		return "redirect:/";
	}
}
