package org.example;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());

	private static Room a001 = new Room("A001", "幹部用会議室", 10);
	private static Room c001001 = new Room("C001001", "セミナールーム", 30);

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 3.2.2. JdbcTemplateクラスを利用したCRUD操作
		testJdbcTemplate(context);

		// 3.2.2.3. Java標準データ型による1項目の取得
		testPrimitiveType(context);

		// 3.2.2.4. バインド変数を利用したSQL
		JdbcRoomDao dao = context.getBean("jdbcRoomDao", JdbcRoomDao.class);
		testBindVariable(dao);

		// 3.2.2.5. 名前付きバインド変数を利用したSQL
		JdbcRoomNamedDao namedDao = context.getBean("jdbcRoomNamedDao", JdbcRoomNamedDao.class);
		testNamedBindVariable(namedDao);

		// 3.2.2.5.1. SqlParameterSourceを利用したパラメータの設定
		testSqlParameterSource(namedDao);

		// 3.2.2.6. 1行の検索結果を取得
		testSingleResult(dao);

		// 3.2.2.7. 複数行の検索結果を取得
		testMultipleResult(dao);

		// 3.2.2.9. テーブルを更新する処理(Insert、Update、Delete)
		testInsertUpdateDelete(dao);

		// 3.2.3.1. RowMapperの実装
		testRowMapper(dao);

		// 3.2.3.1.3. ラムダ式を利用したDaoクラスの実装
		testLambdaExpression(dao);

		// 3.2.3.1.4. BeanPropertyRowMapperを利用したDaoクラスの実装
		testBeanPropertyRowMapper(dao);

		// 3.2.3.2. ResultSetExtractorの実装
		testResultSetExtractor(dao);

		// 3.2.3.3. RowCallbackHandlerの実装
		testRowCallbackHandler(dao);
	}

	/**
	 * 3.2.2. JdbcTemplateクラスを利用したCRUD操作
	 * 
	 * @param context
	 */
	private static void testJdbcTemplate(ApplicationContext context) {
		logger.info("3.2.2. JdbcTemplateクラスを利用したCRUD操作");
		JdbcUserDao userDao = context.getBean("jdbcUserDao", JdbcUserDao.class);
		String username = userDao.findUserName("U0001");
		logger.info(String.format("user_name:%s", username));
	}

	/**
	 * 3.2.2.3. Java標準データ型による1項目の取得
	 * 
	 * @param context
	 */
	private static void testPrimitiveType(ApplicationContext context) {
		// 当サンプルではJavaConfigからcontextを生成しているため、本書記載のXMLからcontextを生成するコードは割愛
		logger.info("3.2.2.3. Java標準データ型による1項目の取得");

		// (1)
		JdbcRoomDao dao = context.getBean("jdbcRoomDao", JdbcRoomDao.class);

		// (2)
		int maxCapacity = dao.findMaxCapacity();
		System.out.println(maxCapacity);
	}

	/**
	 * 3.2.2.4. バインド変数を利用したSQL
	 * 
	 * @param dao
	 */
	private static void testBindVariable(JdbcRoomDao dao) {
		logger.info("3.2.2.4. バインド変数を利用したSQL");
		String roomNameByBindVar = dao.findRoomNameById(a001.getRoomId());
		logger.info(String.format("room_name:%s", roomNameByBindVar));
	}

	/**
	 * 3.2.2.5. 名前付きバインド変数を利用したSQL
	 * 
	 * @param namedDao
	 */
	private static void testNamedBindVariable(JdbcRoomNamedDao namedDao) {
		logger.info("3.2.2.5. 名前付きバインド変数を利用したSQL");
		String roomNameGotByNamedDao = namedDao.findRoomNameById(a001.getRoomId());
		logger.info(String.format("room_name:%s", roomNameGotByNamedDao));
	}

	/**
	 * 3.2.2.5.1. SqlParameterSourceを利用したパラメータの設定
	 * 
	 * @param namedDao
	 */
	private static void testSqlParameterSource(JdbcRoomNamedDao namedDao) {
		logger.info("3.2.2.5.1. SqlParameterSourceを利用したパラメータの設定");
		// MapSqlParameterSource
		String roomNameGotByNamedDaoMapSqlParameterSource = namedDao
				.findRoomNameByIdUseSqlParameterSource(a001.getRoomId(), a001.getRoomName(), a001.getCapacity());
		logger.info(String.format("MapSqlParameterSourceの検証:%s", roomNameGotByNamedDaoMapSqlParameterSource));

		// BeanPropertySqlParameterSource
		String roomNameGotByNamedDaoBeanPropertySqlParameterSource = namedDao
				.findRoomNameByIdUseBeanPropertySqlParameterSource(a001.getRoomId(), a001.getRoomName(),
						a001.getCapacity());
		logger.info(String.format("BeanPropertySqlParameterSourceの検証:%s",
				roomNameGotByNamedDaoBeanPropertySqlParameterSource));
	}

	/**
	 * 3.2.2.6. 1行の検索結果を取得
	 * 
	 * @param dao
	 */
	private static void testSingleResult(JdbcRoomDao dao) {
		logger.info("3.2.2.6. 1行の検索結果を取得");
		Room room = dao.getRoomById(c001001.getRoomId());
		logger.info(String.format("room_name:%s capacity:%d", room.getRoomName(), room.getCapacity()));
	}

	/**
	 * 3.2.2.7. 複数行の検索結果を取得
	 * 
	 * @param dao
	 */
	private static void testMultipleResult(JdbcRoomDao dao) {
		logger.info("3.2.2.7. 複数行の検索結果を取得");
		List<Room> rooms = dao.getAllRoom();
		for (Room r : rooms) {
			logger.info(String.format("room_id:%s room_name:%s capacity:%d", r.getRoomId(), r.getRoomName(),
					r.getCapacity()));
		}
	}

	/**
	 * 3.2.2.9. テーブルを更新する処理(Insert、Update、Delete)
	 * 
	 * @param dao
	 */
	private static void testInsertUpdateDelete(JdbcRoomDao dao) {
		logger.info("3.2.2.9. テーブルを更新する処理(Insert、Update、Delete)");
		Room newRoom = new Room("AAA", "BBB", 20);
		// insert
		int insertResult = dao.insertRoom(newRoom);
		logger.info(String.format("insert件数:%d", insertResult));
		logger.info(String.format("insert後room件数:%d", dao.getAllRoom().size()));

		// update
		newRoom.setCapacity(1000);
		int updateResult = dao.updateRoomById(newRoom);
		logger.info(String.format("update件数:%d", updateResult));
		logger.info(String.format("update後capacity:%d", dao.getRoomById(newRoom.getRoomId()).getCapacity()));

		// delete
		int deleteResult = dao.deleteRoomById("AAA");
		logger.info(String.format("delete件数:%d", deleteResult));
		logger.info(String.format("delete後room件数:%d", dao.getAllRoom().size()));
	}

	/**
	 * 3.2.3.1. RowMapperの実装
	 * 
	 * @param dao
	 */
	private static void testRowMapper(JdbcRoomDao dao) {
		logger.info("3.2.3.1. RowMapperの実装");
		Room roomRowMapper = dao.getRoomByIdUseRowMapper(c001001.getRoomId());
		logger.info(
				String.format("room_name:%s capacity:%d", roomRowMapper.getRoomName(), roomRowMapper.getCapacity()));
		List<Room> roomsRowMapper = dao.getAllRoomUseRowMapper();
		for (Room r : roomsRowMapper) {
			logger.info(String.format("room_id:%s room_name:%s capacity:%d", r.getRoomId(), r.getRoomName(),
					r.getCapacity()));
		}
	}

	/**
	 * 3.2.3.1.3. ラムダ式を利用したDaoクラスの実装
	 * 
	 * @param dao
	 */
	private static void testLambdaExpression(JdbcRoomDao dao) {
		logger.info("3.2.3.1.3. ラムダ式を利用したDaoクラスの実装");
		List<Room> roomsLambda = dao.getAllRoomUseLambda();
		for (Room r : roomsLambda) {
			logger.info(String.format("room_id:%s room_name:%s capacity:%d", r.getRoomId(), r.getRoomName(),
					r.getCapacity()));
		}
	}

	/**
	 * 3.2.3.1.4. BeanPropertyRowMapperを利用したDaoクラスの実装
	 * 
	 * @param dao
	 */
	private static void testBeanPropertyRowMapper(JdbcRoomDao dao) {
		logger.info("3.2.3.1.4. BeanPropertyRowMapperを利用したDaoクラスの実装");
		Room roomUseBeanPropertyById = dao.getRoomUseBeanPropertyById(c001001.getRoomId());
		logger.info(String.format("room_name:%s capacity:%d", roomUseBeanPropertyById.getRoomName(),
				roomUseBeanPropertyById.getCapacity()));
	}

	/**
	 * 3.2.3.2. ResultSetExtractorの実装
	 * 
	 * @param dao
	 */
	private static void testResultSetExtractor(JdbcRoomDao dao) {
		logger.info("3.2.3.2. ResultSetExtractorの実装");
		logger.info("getAllRoomWithEquipmentの確認");
		List<Room> roomsWithEquipments = dao.getAllRoomWithEquipment();
		for (Room r : roomsWithEquipments) {
			for (Equipment e : r.getEquipmentList()) {
				logger.info(String.format("%s has %s ", r.getRoomName(), e.getEquipmentName()));
			}
		}
		logger.info("getRoomWithEquipmentByIdの確認");
		Room roomWithEquipmentById = dao.getRoomWithEquipmentById(c001001.getRoomId());
		for (Equipment e : roomWithEquipmentById.getEquipmentList()) {
			logger.info(String.format("%s has %s ", roomWithEquipmentById.getRoomName(), e.getEquipmentName()));
		}
	}

	/**
	 * 3.2.3.3. RowCallbackHandlerの実装
	 * 
	 * @param dao
	 */
	private static void testRowCallbackHandler(JdbcRoomDao dao) {
		logger.info("3.2.3.3. RowCallbackHandlerの実装");
		// CSVファイルを出力します, 出力先のパスはreportRooms()内でSystem.out.printlnで表示させるコードをコメントしてます。
		// 動作確認時は、そこをコメントアウトしてください
		try {
			dao.reportRooms();
		} catch (IOException e) {
			logger.warning(e.toString());
		}
	}
}