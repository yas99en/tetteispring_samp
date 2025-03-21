package com.example.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Room;
import com.example.domain.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	private RoomRepository roomRepository;

	@Autowired
	public RoomServiceImpl(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	// 10.4.3. 例外の変換 SQLを強制的に実行して例外ハンドリングを行なう実装例
	@Transactional
	public Room updateRoomWithOptimisticLock(Integer id, String roomName) {
		Room room = new Room();
		Optional<Room> roomOpt = roomRepository.findById(id);
		// 対象のroomが取得できた場合のみルーム名のみ更新する
		roomOpt.ifPresent(x -> {
			try {
				// 5秒待機
				Thread.sleep(5000);
				try {
					// 更新処理
					x.setRoomId(x.getRoomId());
					x.setRoomName(roomName);
					x.setCapacity(x.getCapacity());
					roomRepository.saveAndFlush(x);
					// 画面出力用に値を設定
					room.setRoomName(roomName);
				} catch (OptimisticLockingFailureException e) {
					// エラー処理を実装する
					System.out.println("exception ok");
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		});
		return room;
	}

	// 10.4.3. 例外の変換 動作確認用 OptimisticLockingFailureExceptionを発生させるメソッド
	@Transactional
	public Room checkUpdateRoomOptimisticLock(Integer id, String roomName) {
		Room room = new Room();
		Optional<Room> roomOpt = roomRepository.findById(id);
		// 対象のroomが取得できた場合のみルーム名のみ更新する
		roomOpt.ifPresent(x -> {
			// 更新処理
			x.setRoomId(x.getRoomId());
			x.setRoomName(roomName);
			x.setCapacity(x.getCapacity());
			roomRepository.saveAndFlush(x);
			// 画面出力用に値を設定
			room.setRoomName(roomName);
		});
		if (!roomOpt.isPresent()) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
		    System.out.println("=== room not found ===");
		}
		return room;
	}
}
