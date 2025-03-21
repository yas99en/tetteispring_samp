package mrs.app.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.RoleName;
import mrs.domain.model.User;
import mrs.domain.service.reservation.AlreadyReservedException;
import mrs.domain.service.reservation.ReservationService;
import mrs.domain.service.reservation.UnavailableReservationException;
import mrs.domain.service.room.RoomService;
import mrs.domain.service.user.ReservationUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("reservations/{date}/{roomId}")
public class ReservationsController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	ReservationService reservationService;

	// 14.2.7.3. コントローラクラスおよびHTMLの作成 ReservationsController.java
	@ModelAttribute
	ReservationForm setUpForm() {
		ReservationForm form = new ReservationForm();
		// デフォルト値
		form.setStartTime(LocalTime.of(9, 0));
		form.setEndTime(LocalTime.of(10, 0));
		return form;
	}

	// 14.2.7.3. コントローラクラスおよびHTMLの作成 ReservationsController.java
	// 14.2.8.6. 予約処理の修正 ReservationsController.java
	@RequestMapping(method = RequestMethod.GET)
	String reserveForm(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
					   @PathVariable("roomId") Integer roomId, Model model) {
//		// 14.2.7.3. コントローラクラスおよびHTMLの作成 ReservationsController.java
//		MeetingRoom meetingRoom = roomService.findMeetingRoom(roomId);
//		ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);
//		List<Reservation> reservations = reservationService.findReservations(reservableRoomId);
//		List<LocalTime> timeList = Stream.iterate(LocalTime.of(0, 0), t -> t.plusMinutes(30))
//										.limit(24L * 2)
//										.collect(Collectors.toList());
//		model.addAttribute("room", meetingRoom);
//		model.addAttribute("reservations", reservations);
//		model.addAttribute("timeList", timeList);
//		model.addAttribute("user", dummyUser());
//		return "reservation/reserveForm";
		
		// 14.2.8.6. 予約処理の修正 ReservationsController.java
		MeetingRoom meetingRoom = roomService.findMeetingRoom(roomId);
		ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);
		List<Reservation> reservations = reservationService.findReservations(reservableRoomId);
		List<LocalTime> timeList = Stream.iterate(LocalTime.of(0, 0), t -> t.plusMinutes(30))
										.limit(24L * 2)
										.collect(Collectors.toList());
		model.addAttribute("room", meetingRoom);
		model.addAttribute("reservations", reservations);
		model.addAttribute("timeList", timeList);
		return "reservation/reserveForm";
	}
	
//	// 14.2.7.3. コントローラクラスおよびHTMLの作成 ReservationsController.java
//	private User dummyUser() {
//		User user = new User();
//		user.setUserId("taro-yamada");
//		user.setFirstName("太郎");
//		user.setLastName("山田");
//		user.setRoleName(RoleName.USER);
//		return user;
//	}

//	// 14.2.7.3. コントローラクラスおよびHTMLの作成 ReservationsController.java
//	@RequestMapping(method = RequestMethod.POST)
//	String reserve(@Validated ReservationForm form, BindingResult bindingResult,
//				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
//				@PathVariable("roomId") Integer roomId, Model model) {
//		if (bindingResult.hasErrors()) {
//			return reserveForm(date, roomId, model);
//		}
//		ReservableRoom reservableRoom = new ReservableRoom(new ReservableRoomId(roomId, date));
//		Reservation reservation = new Reservation();
//		reservation.setStartTime(form.getStartTime());
//		reservation.setEndTime(form.getEndTime());
//		reservation.setReservableRoom(reservableRoom);
//		reservation.setUser(dummyUser());		
//		try {
//			reservationService.reserve(reservation);
//		} catch (UnavailableReservationException | AlreadyReservedException e) {
//			model.addAttribute("error", e.getMessage());
//			return reserveForm(date, roomId, model);
//		}
//		return "redirect:/reservations/{date}/{roomId}";
//	}
	
	// 14.2.8.6. 予約処理の修正 ReservationsController.java
	@RequestMapping(method = RequestMethod.POST)
	String reserve(@Validated ReservationForm form, BindingResult bindingResult,
				@AuthenticationPrincipal ReservationUserDetails userDetails,
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
				@PathVariable("roomId") Integer roomId, Model model) {
		if (bindingResult.hasErrors()) {
			return reserveForm(date, roomId, model);
		}
		ReservableRoom reservableRoom = new ReservableRoom(new ReservableRoomId(roomId, date));
		Reservation reservation = new Reservation();
		reservation.setStartTime(form.getStartTime());
		reservation.setEndTime(form.getEndTime());
		reservation.setReservableRoom(reservableRoom);
		reservation.setUser(userDetails.getUser());	
		try {
			reservationService.reserve(reservation);
		} catch (UnavailableReservationException | AlreadyReservedException e) {
			model.addAttribute("error", e.getMessage());
			return reserveForm(date, roomId, model);
		}
		return "redirect:/reservations/{date}/{roomId}";
	}
	
//	// 14.2.7.3. コントローラクラスおよびHTMLの作成 ReservationsController.java
//	@RequestMapping(method = RequestMethod.POST, params = "cancel")
//	String cancel(@RequestParam("reservationId") Integer reservationId, @PathVariable("roomId") Integer roomId,
//			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
//		User user = dummyUser();
//		try {
//			reservationService.cancel(reservationId, user);
//		} catch (IllegalStateException e) {
//			model.addAttribute("error", e.getMessage());
//			return reserveForm(date, roomId, model);
//		}
//		return "redirect:/reservations/{date}/{roomId}";
//	}
	
//	// 14.2.8.6. 予約処理の修正 ReservationsController.java
//	@RequestMapping(method = RequestMethod.POST, params = "cancel")
//	String cancel(@AuthenticationPrincipal ReservationUserDetails userDetails,
//			@RequestParam("reservationId") Integer reservationId, @PathVariable("roomId") Integer roomId,
//			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
//		User user = userDetails.getUser();
//		try {
//			reservationService.cancel(reservationId, user);
//		} catch (AccessDeniedException e) {
//			model.addAttribute("error", e.getMessage());
//			return reserveForm(date, roomId, model);
//		}
//		return "redirect:/reservations/{date}/{roomId}";
//	}

	// 14.2.8.7. @PreAuthorizeによる認可制御 ReservationsController.java
	@RequestMapping(method = RequestMethod.POST, params = "cancel")
	String cancel(@RequestParam("reservationId") Integer reservationId, @PathVariable("roomId") Integer roomId,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
		try {
			Reservation reservation = reservationService.findOne(reservationId);
			reservationService.cancel(reservation);
		} catch (AccessDeniedException e) {
			model.addAttribute("error", e.getMessage());
			return reserveForm(date, roomId, model);
		}
		return "redirect:/reservations/{date}/{roomId}";
	}
	
}
