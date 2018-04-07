INSERT INTO BOOK (ID, AUTHOR, DESCRIPTION, ISBN, TITLE, YEAR) VALUES (-1, 'Chaira Goemans', 'Quisque ut neque in libero ultrices porta. Aliquam consequat tincidunt nulla, congue pellentesque nibh mollis non. Quisque ornare luctus nisl ac mollis. Aliquam placerat ornare purus, eget iaculis mauris placerat vel.', '95-9343-451-8', 'Nullam Quis Egestas Ligula', 2004);
INSERT INTO BOOK (ID, AUTHOR, DESCRIPTION, ISBN, TITLE, YEAR) VALUES (-2, 'Timon Zuidweg', 'Suspendisse mollis nisi vel enim ornare ornare. Aliquam erat volutpat. Fusce erat dui, sodales vel nisi a, suscipit efficitur dui. Aenean semper lorem et nunc dictum lacinia.', '99-9237-361-10', 'Ut Molestie', 2018);
INSERT INTO BOOK (ID, AUTHOR, DESCRIPTION, ISBN, TITLE, YEAR) VALUES (-3, 'Violetta Hanssen', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque iaculis interdum ornare. Nullam quis egestas ligula, in tincidunt neque.', '99-9233-766-4', 'Quam ut Urna', 1996);
INSERT INTO BOOK (ID, AUTHOR, DESCRIPTION, ISBN, TITLE, YEAR) VALUES (-4, 'Imran Kuilboer', 'Etiam pharetra lorem at augue pretium, eu fringilla tortor posuere. Nam sem augue, rhoncus id sollicitudin at, viverra nec mauris. Fusce faucibus nulla non erat venenatis mollis. Vivamus ac elit tincidunt, vehicula ligula eu, tristique elit. Ut molestie pretium dui, in porta leo.', '99-9233-766-4', 'Vestibulum', 2010);
INSERT INTO BOOK (ID, AUTHOR, DESCRIPTION, ISBN, TITLE, YEAR) VALUES (-5, 'Serafin Archuleta Arroyo', 'Morbi nec lorem sit amet eros vehicula suscipit ac sed dui.', '99-9230-262-3', 'El Castillo Modelo', 2010);
INSERT INTO BOOK (ID, AUTHOR, DESCRIPTION, ISBN, TITLE, YEAR) VALUES (-6, 'Imran Kuilboer', 'Proin lobortis, eros id luctus pretium, ex ipsum tempus dui, quis fringilla nisi augue in lorem. Nunc augue magna, euismod eget magna non, aliquet dictum erat.', '95-8897-650-2', 'La Mora Ingeniero', 1999);



INSERT INTO USERS (ID, FULL_NAME, EMAIL, PASSWORD, CONFIRMED) VALUES (-1, 'admin', 'admin', STRINGDECODE('x61Ey612Kl2gpFL56FT9weDnpSo4AV8j8+qx2AuTHdRyY036xxzTTrw10Wq3+4qQyB+XURPWx1ON\nxp3Y3pB37A=='), TRUE);

INSERT INTO ROLES (ID, NAME, DESCRIPTION) VALUES (-1, 'admin', 'admin');
INSERT INTO ROLES (ID, NAME, DESCRIPTION) VALUES (-2, 'user', 'user');
INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) VALUES (-1, -1);
INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) VALUES (-1, -2);