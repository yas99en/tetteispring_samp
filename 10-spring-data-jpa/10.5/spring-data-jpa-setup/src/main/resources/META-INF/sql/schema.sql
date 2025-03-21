CREATE TABLE room (
    room_id INT NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT
);

CREATE TABLE equipment (
    equipment_id INT NOT NULL PRIMARY KEY,
    room_id INT,
    equipment_name VARCHAR(30),
    equipment_count INT,
    equipment_remarks VARCHAR(100),
    foreign key (room_id) references room(room_id)
);