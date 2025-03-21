package mrs.domain.service.reservation;

// 14.2.7.2. サービスクラスの作成 UnavailableReservationException.java
public class UnavailableReservationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UnavailableReservationException(String message) {
		super(message);
	}
	
}