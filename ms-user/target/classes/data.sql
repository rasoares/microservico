INSERT INTO tb_user(name,email,password) Values ('Nina Brow', 'nina@gmail.com','$2a$10$5LvIdrp0lu6o36GqBsStGOhFDfqJVTixerKUgJWPVY66gncl7Ruxu');
INSERT INTO tb_user(name,email,password) Values ('Leia Red' , 'leia@gmail.com','$2a$10$5LvIdrp0lu6o36GqBsStGOhFDfqJVTixerKUgJWPVY66gncl7Ruxu');

INSERT INTO tb_role(role_name) Values ('ROLE_OPERATOR');
INSERT INTO tb_role(role_name) Values ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) values (1,1);
INSERT INTO tb_user_role (user_id, role_id) values (2,1);
INSERT INTO tb_user_role (user_id, role_id) values (2,2);
