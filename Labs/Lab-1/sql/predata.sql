insert into person
values (DEFAULT, 'Ivan', 'MALE', 30);
insert into person
values (DEFAULT, 'Boymen', 'MALE', 39);
insert into person
values (DEFAULT, 'Janna', 'FEMALE', 24);

insert into city
values (DEFAULT, 'Moscow');

insert into atmosphere
values ((SELECT id from city where name='Moscow'), 'air raid alert', 21.4);

insert into building
values (DEFAULT, 'emergency shelter', 'Lenina street, 5', (SELECT id from city where name='Moscow'));
insert into building
values (DEFAULT, 'house', 'Lenina street, 12', (SELECT id from city where name='Moscow'));
insert into building
values (DEFAULT, 'motel', 'Green street, 1', (SELECT id from city where name='Moscow'));

insert into type_obj_build
values (DEFAULT, 'WINDOW');
insert into type_obj_build
values (DEFAULT, 'DOOR');

insert into object_build
values (DEFAULT, 'steel-AX432', 'good steel door', (SELECT id from type_obj_build where type='DOOR'), 1);
insert into object_build
values (DEFAULT, 'PVH-40', 'casual window', (SELECT id from type_obj_build where type='WINDOW'), 2);

insert into interactions
values (DEFAULT, 'open door as fast as he can', 2, 1);
insert into interactions
values (DEFAULT, 'close door behind he', 2, 1);
insert into interactions
values (DEFAULT, 'broke the window', 1, 2);