package mrs.domain.service.reservation;

// 14.2.7.2. サービスクラスの作成 AlreadyReservedException.java
public class AlreadyReservedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AlreadyReservedException(String message) {
		super(message);
	}
	
}