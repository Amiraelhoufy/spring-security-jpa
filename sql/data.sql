insert into user(id,user_name,password,enabled)
VALUES(1,"test","test",true);

insert into authorities(id,user_name,authority)
values(1,"test","ROLE_ADMIN");

insert into authorities(id,user_name,authority)
values(2,"test","ROLE_USER");
