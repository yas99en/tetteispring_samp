package mrs.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;

import mrs.domain.model.MeetingRoom;

// 14.2.7.1. リポジトリクラスの作成 MeetingRoomRepository.java
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {
}