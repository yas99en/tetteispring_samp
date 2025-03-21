package mrs.domain.service.reservation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.RoleName;
import mrs.domain.model.User;
import mrs.domain.repository.reservation.ReservationRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	// 14.2.7.2. サービスクラスの作成 ReservationService.java
	public List<Reservation> findReservations(ReservableRoomId reservableRoomId) {
		return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
	}

	// 14.2.7.2. サービスクラスの作成 ReservationService.java
	// 14.2.7.5. 悲観的ロック処理の実装 ReservationService.java
	public Reservation reserve(Reservation reservation) {
//		// 14.2.7.2. サービスクラスの作成 ReservationService.java
//		ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();
//		// 対象の部屋が予約可能かどうかチェック
//		ReservableRoom reservable = reservableRoomRepository.findById(reservableRoomId).orElse(null);
//		if (reservable == null) {
//			throw new UnavailableReservationException("入力の日付・部屋の組み合わせは予約できません。");
//		}
//		// 重複チェック
//		boolean overlap = reservationRepository
//							.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)
//							.stream()
//							.anyMatch(x -> x.overlap(reservation));
//		if (overlap) {
//			throw new AlreadyReservedException("入力の時間帯はすでに予約済みです。");
//		}
//		// 予約情報の登録
//		reservationRepository.save(reservation);
//		return reservation;
        
		// 14.2.7.5. 悲観的ロック処理の実装 ReservationService.java
		ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();
		// 悲観ロック
		ReservableRoom reservable = reservableRoomRepository.findOneForUpdateByReservableRoomId(reservableRoomId);
		if (reservable == null) {
			throw new UnavailableReservationException("入力の日付・部屋の組み合わせは予約できません。");
		}
		// 重複チェック
		boolean overlap = reservationRepository
							.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)
							.stream()
							.anyMatch(x -> x.overlap(reservation));
		if (overlap) {
			throw new AlreadyReservedException("入力の時間帯はすでに予約済みです。");
		}
		// 予約情報の登録
		reservationRepository.save(reservation);
		return reservation;
	}
	
	// 14.2.7.2. サービスクラスの作成 ReservationService.java
	// 14.2.8.6. 予約処理の修正 ReservationService.java
	public void cancel(Integer reservationId, User requestUser) {
//		// 14.2.7.2. サービスクラスの作成 ReservationService.java
//		Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
//		if (reservation == null) {
//			// 対象のreservationが存在しない場合の処理
//			// 本来は例外処理を実装するが、本書では省略
//			System.out.println("=== reservation not found ===");
//		}
//		if (RoleName.ADMIN != requestUser.getRoleName() &&
//				!Objects.equals(reservation.getUser().getUserId(), requestUser.getUserId())) {
//			throw new IllegalStateException("要求されたキャンセルは許可できません。");
//		}
//		reservationRepository.delete(reservation);
		
		// 14.2.8.6. 予約処理の修正 ReservationService.java
		Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
		if (reservation == null) {
			// 対象のreservationが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== reservation not found ===");
		}
		if (RoleName.ADMIN != requestUser.getRoleName() &&
				!Objects.equals(reservation.getUser().getUserId(), requestUser.getUserId())) {
			throw new AccessDeniedException("要求されたキャンセルは許可できません。");
		}
		reservationRepository.delete(reservation);
	}

	// 14.2.8.7. @PreAuthorizeによる認可制御 ReservationService.java
	@PreAuthorize("hasRole('ADMIN') or #reservation.user.userId == principal.user.userId")
	public void cancel(@P("reservation") Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	// 14.2.8.7. @PreAuthorizeによる認可制御 ReservationService.java
	public Reservation findOne(Integer reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
		if (reservation == null) {
			// 対象のreservationが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== reservation not found ===");
		}
		return reservation;
	}
	
}