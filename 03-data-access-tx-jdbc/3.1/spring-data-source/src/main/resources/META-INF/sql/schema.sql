CREATE TABLE usr (
    user_id VARCHAR(10) NOT NULL PRIMARY KEY,
    user_name VARCHAR(30) NOT NULL
);
CREATE TABLE room (
    room_id VARCHAR(10) NOT NULL PRIMARY KEY,
    room_name VARCHAR(30) NOT NULL,
    capacity INT NOT NULL
);
CREATE TABLE equipment (
    equipment_id VARCHAR(10) NOT NULL PRIMARY KEY,
    room_id VARCHAR(10) NOT NULL,
    equipment_name VARCHAR(30) NOT NULL,
    equipment_count INT NOT NULL,
    equipment_remarks VARCHAR(100),
    foreign key (room_id) references room(room_id)
);