package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.util.StringUtils;

// 3.2.3.3.1. RowCallbackHandlerクラスの実装
//(1)
public class RoomRowCallbackHandler implements RowCallbackHandler {
	private final BufferedWriter writer;

	public RoomRowCallbackHandler(BufferedWriter writer) {
		this.writer = writer;
	}

	// (2)
	@Override
	public void processRow(ResultSet rs) throws SQLException {
		// (3)
		Object[] values = new Object[] { rs.getString("room_id"), rs.getString("room_name"), rs.getInt("capacity") };
		String line = StringUtils.arrayToCommaDelimitedString(values);
		try {
			writer.write(line);
			writer.newLine();
		} catch (IOException e) {
			// (4)
			throw new SQLException(e);
		}
	}
}