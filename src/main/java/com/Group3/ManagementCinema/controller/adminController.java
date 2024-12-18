package com.Group3.ManagementCinema.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.entity.Rate;
import com.Group3.ManagementCinema.entity.TicketCountByMonthDTO;
import com.Group3.ManagementCinema.impl.RateServiceImpl;
import com.Group3.ManagementCinema.impl.TicketServiceImpl;
import com.Group3.ManagementCinema.service.AccountService;
import com.Group3.ManagementCinema.service.CinemaRoomService;
import com.Group3.ManagementCinema.service.CustomerService;
import com.Group3.ManagementCinema.service.EmployeeService;
import com.Group3.ManagementCinema.service.MovieScheduleService;
import com.Group3.ManagementCinema.service.MovieService;
import com.Group3.ManagementCinema.service.RateService;
import com.Group3.ManagementCinema.service.TicketService;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class adminController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CinemaRoomService cinemaroomService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private MovieScheduleService moviescheduleService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private RateServiceImpl rateService;
	@Autowired
	private TicketService ticketService;

	@GetMapping("/")
	public String countCustomers(Model model, HttpSession session) {
		// Lấy thông tin account từ session
		Account account = (Account) session.getAttribute("account");
		if (account != null) {
			model.addAttribute("account", account); // Thêm account vào model để sử dụng trong view
		} else {
			// Nếu không có account trong session, bạn có thể xử lý hoặc hiển thị một thông
			// báo
			model.addAttribute("errorMessage", "Please log in to view the dashboard.");
		}

		// Lấy các thông tin thống kê từ các service
		long customerCount = customerService.countCustomers();
		model.addAttribute("customerCount", customerCount);

		long cinemaRoomCount = cinemaroomService.countCinemaRoom();
		model.addAttribute("cinemaRoomCount", cinemaRoomCount);

		long employeeCount = employeeService.countEmployee();
		model.addAttribute("employeeCount", employeeCount);

		long movieCount = movieService.countMovie();
		model.addAttribute("movieCount", movieCount);

		long movieScheduleCount = moviescheduleService.countMovieSchedule();
		model.addAttribute("movieScheduleCount", movieScheduleCount);

		long accountCount = accountService.countAccount();
		model.addAttribute("accountCount", accountCount);

		long ticketCount = ticketService.countTicket();
		model.addAttribute("ticketCount", ticketCount);

		BigDecimal totalRevenue = ticketService.totalRevenue();
		model.addAttribute("totalRevenue", totalRevenue);

		// Lấy thống kê số vé theo tháng
		List<Object[]> amountTickets = ticketService.countTicketByMonth();
		List<TicketCountByMonthDTO> amount = amountTickets.stream().map(obj -> {
			int month = (int) obj[0]; // Phần tử đầu tiên là tháng
			long ticketCountMonth = (long) obj[1]; // Phần tử thứ hai là số lượng vé
			return new TicketCountByMonthDTO(month, ticketCountMonth);
		}).collect(Collectors.toList());
		System.out.println("Stats: " + amount); // Debug log
		model.addAttribute("amountTicketsByMonth", amount);

		// Trả về view index
		return "index.html";
	}

	@GetMapping("/login")
	public String openLogin(Model model) {
		return "/login/login";
	}

	@GetMapping("/regis")
	public String openRegis(Model model) {
		model.addAttribute("account", new Account());
		return "/register/register";
	}

	@PostMapping("/checkLogin")
	public String checkLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam(required = false) boolean rememberMe, HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		Account account = accountService.checkLogin(email, password);
		if (account != null) {
			session.setAttribute("account", account); // Lưu đối tượng Account vào session
			List<Movie> movies = movieService.getAllMovies();
			List<Movie> nowshowing = new ArrayList<>();
			List<Movie> comingsoon = new ArrayList<>();
			for (int i = 0; i < movies.size(); i++) {
				List<MovieSchedule> listSche = movies.get(i).getMovieSchedules();
				if (listSche != null && !listSche.isEmpty()) {
					nowshowing.add(movies.get(i));
				} else {
					comingsoon.add(movies.get(i));
				}
			}

			model.addAttribute("nowshowing", nowshowing);
			model.addAttribute("comingsoon", comingsoon);
			Map<Long, Double> averageRatings = rateService.getAverageRatings();
			model.addAttribute("averageRatings", averageRatings);
			model.addAttribute("account", account); // Đảm bảo truyền account vào model

			if (rememberMe) {
				// Tạo cookie
				Cookie cookie = new Cookie("user", email);
				cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
				cookie.setHttpOnly(true);
				response.addCookie(cookie);
			}

			account.setStatus(true); // Đảm bảo trạng thái online
			accountService.saveAccount(account); // Lưu tài khoản

			if (account.getRole().equals("admin")) {
				session.setAttribute("role", "admin");
				return "redirect:/"; // Điều hướng đến trang admin
			} else if (account.getRole().equals("employee")) {
				session.setAttribute("role", "employee");
				return "employeeAdmin"; // Điều hướng đến trang nhân viên
			} else {
				Customer customer = customerService.getCustomerById(account.getCustomer().getIdKhach());
				model.addAttribute("customer", customer);
				return "cusIndex"; // Điều hướng đến trang người dùng
			}
		} else {
			model.addAttribute("errorMss", true);
			model.addAttribute("movies", movieService.getAllMovies());
			return "login/login"; // Điều hướng lại trang đăng nhập với thông báo lỗi
		}
	}

	@GetMapping("/userSite")
	public String openUserSite(HttpServletRequest request, Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("account");
		Customer customer = customerService.getCustomerById(account.getCustomer().getIdKhach());
		model.addAttribute("account", account);
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("customer", customer);
		List<Movie> nowshowing = new ArrayList<>();
		List<Movie> comingsoon = new ArrayList<>();
		for (int i = 0; i < movies.size(); i++) {
			List<MovieSchedule> listSche = movies.get(i).getMovieSchedules();
			if (listSche != null && !listSche.isEmpty()) {
				nowshowing.add(movies.get(i));
			} else {
				comingsoon.add(movies.get(i));
			}
		}
//        for (int i = 0; i < movies.size(); i++) {
//        	if(movies.get(i).isTrangthai() == true) {
//        		nowshowing.add(movies.get(i));
//        	}else {
//        		comingsoon.add(movies.get(i));
//        	}
//        }
		model.addAttribute("account", account);
		model.addAttribute("nowshowing", nowshowing);
		model.addAttribute("comingsoon", comingsoon);
		Map<Long, Double> averageRatings = rateService.getAverageRatings();
		model.addAttribute("averageRatings", averageRatings);
		return "cusIndex";
	}

	@GetMapping("/showMovieGenre")
	public String showMovieGenre(Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("account");
		model.addAttribute("account", account);
		model.addAttribute("movies", movieService.getAllMovies());
		return "moviegenre"; // Trả về tên của file HTML trong thư mục templates
	}

	@PostMapping("/getMovieGenreOrNation")
	public String MovieGenreOrNation(@RequestParam("genre") String genre, @RequestParam("nation") String nation,
			Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("account");
		model.addAttribute("account", account);
		if (genre != "" && nation != "") {
			model.addAttribute("movies", movieService.getMovieByTheLoaiAndQuocGia(genre, nation));
		} else if (genre != "") {
			model.addAttribute("movies", movieService.getMovieByTheLoaiOrQuocGia(genre));
		} else if (nation != "") {
			model.addAttribute("movies", movieService.getMovieByTheLoaiOrQuocGia(nation));
		} else if (genre == "" && nation == "") {
			model.addAttribute("movies", movieService.getAllMovies());
		}
		return "moviegenre"; // Trả về tên của file HTML trong thư mục templates
	}

	@GetMapping("/buyticket")
	public String buyTicket() {
		return "buyticket"; // Trả về tên của file HTML trong thư mục templates
	}

	@GetMapping("/film/{id}")
	public String openFilm(@PathVariable(value = "id") Long idPhong, HttpServletRequest request, Model model) {
		Movie movie = movieService.getMovieById(idPhong);
		List<MovieSchedule> movieSchedule = moviescheduleService.findByIdphim(movie);
		List<Rate> rates = rateService.getAllRates();
		// Filter out duplicate ngayChieu
		List<Date> uniqueDates = movieSchedule.stream().map(MovieSchedule::getNgayChieu).distinct()
				.collect(Collectors.toList());
		Rate newRate = new Rate();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Customer customer = customerService.getCustomerById(account.getCustomer().getIdKhach());
		Map<Long, Double> averageRatings = rateService.getAverageRatings();
		model.addAttribute("averageRatings", averageRatings);

		newRate.setTaiKhoan(account);
		newRate.setPhim(movie);
		model.addAttribute("newRate", newRate);
		model.addAttribute("account", account);
		model.addAttribute("customer", customer);
		model.addAttribute("rates", rates);
		model.addAttribute("movie", movie);
		model.addAttribute("uniqueDates", uniqueDates);
		model.addAttribute("movieSchedule", movieSchedule);
		return "film";
	}

	@GetMapping("/statis")
	public String openStatis(Model model) {
		return "/admin/statis";
	}

	@GetMapping("/logout/{id}")
	public String logout(HttpServletResponse response, @PathVariable(value = "id") String email) {
		Account account = accountService.getAccountById(email);
		account.setStatus(false);
		accountService.saveAccount(account);
		Cookie cookie = new Cookie("user", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);

		return "login/login";
	}

	@GetMapping("/userInfo")
	public String openInfo(Model model) {
		return "info";
	}
}
