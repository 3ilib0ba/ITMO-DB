-- роли в системе: юзер, админ, инструктор, студия(менеджер)
insert into role
values (DEFAULT, 'USER');
insert into role
values (DEFAULT, 'ADMIN');
insert into role
values (DEFAULT, 'MASTER');
insert into role
values (DEFAULT, 'STUDIO');

-- дополнительная информация о студии, необходимая для её же регистрации.
insert into legal_info
values (DEFAULT, 'ООО ФИТНЕС КЛУБ "БОГАТЫРИ НЕВСКИЕ"', '+79631234499', 'bogatyri@yandex.ru', '8233-039');
insert into legal_info
values (DEFAULT, 'ООО "ЙОГА ДОМ"', '+75550990770', 'yogadom@mail.ru', '2111-203');
insert into legal_info
values (DEFAULT, 'ПАО "БОЛЬШОЙ ТЕННИС ПРОФИ"', '+79331765588', 'tennisprofi@gmail.com', '3776-603');
insert into legal_info
values (DEFAULT, 'ООО "ФИТЕНС СИЛА И ЗДОРОВЬЕ"', '+79229870020', 'strengthonly@yandex.ru', '8411-419');

-- создание балансов для клиентов
insert into balance
values (1, 1000, 1, 1);
insert into balance
values (2, 1500, 1, 2);
insert into balance
values (3, 4000, 1, 3);
insert into balance
values (4, 12000, 1, 4);
insert into balance
values (5, 100, 2, 5);
insert into balance
values (6, 6000, 3, 306);
-- для студий
insert into balance
values (701, 30000, 4, 501);
insert into balance
values (702, 15000, 4, 502);
insert into balance
values (703, 77000, 4, 503);
insert into balance
values (704, 33000, 4, 504);

-- студии(менеджер) к ним
insert into studio
values (501, 'БОГАТЫРЬ С НЕВЫ', 'ФИТНЕС КЛУБ', 4, 1, 701);
insert into studio
values (502, 'ЙОГА ДОМ', 'ДОМ ЙОГИ', 4, 2, 702);
insert into studio
values (503, 'УДАРНАЯ РАКЕТКА', 'ЦЕНТР БОЛЬШОГО ТЕННИСА', 4, 3, 703);
insert into studio
values (504, 'СИЛА&ЗДОРОВЬЕ', 'ФИТНЕС, ТРЕНАЖЕРНЫЙ ЦЕНТР', 4, 4, 704);

-- создали клиентуру(среди них есть админ и инструктор - одна таблица)
insert into client
values (DEFAULT, 'nickname123', 'oaoaoa@mail.ru', '+79217773388', 'male', 1, 1);
insert into client
values (DEFAULT, 'genvflow', 'needknowit@mail.ru', '+79841065001', 'female', 1, 2);
insert into client
values (DEFAULT, 'Xixix', 'ix_v_Xd@gmail.com', '+79214183940', 'male', 1, 3);
insert into client
values (DEFAULT, 'greg', 'geeergreg@mail.ru', '+79347573217', 'male', 1, 4);
insert into client
values (DEFAULT, 'zoe_tut', 'zoe_tutu@yandex.ru', '+79156447117', 'female', 2, 5);

-- создаем точки студий
insert into pos
values (DEFAULT, 'ADDRESS 1', '10:00-18:00', 501);
insert into pos
values (DEFAULT, 'ADDRESS 2', '14:00-18:00', 501);
insert into pos
values (DEFAULT, 'ADDRESS 3', '08:00-20:00', 502);
insert into pos
values (DEFAULT, 'kort 1', '06:00-22:00', 503);
insert into pos
values (DEFAULT, 'kort 2', '06:00-22:00', 503);
insert into pos
values (DEFAULT, 'kort 3', '06:00-22:00', 503);
insert into pos
values (DEFAULT, 'kort 4', '10:00-22:00', 503);
insert into pos
values (DEFAULT, 'porohovskaya 13', '08:00-22:00', 504);
insert into pos
values (DEFAULT, 'nab. fontanki 11', '08:00-22:00', 504);

-- создаем занятия в студиях
insert into class
values (DEFAULT, 'ARM', '2022-12-03', '10:00', '12:00', 200, 1);
insert into class
values (DEFAULT, 'ARM', '2012-12-12', '12:00', '14:00', 200, 1);
insert into class
values (DEFAULT, 'LEG', '2023-01-02', '16:00', '18:00', 400, 2);
insert into class
values (DEFAULT, 'YOGA-HATHA', '2022-12-18', '08:00', '10:30', 700, 3);
insert into class
values (DEFAULT, 'FREE TENNIS KORT', '2022-12-14', '08:00', '12:00', 1700, 4);
insert into class
values (DEFAULT, 'FREE TENNIS KORT', '2022-12-14', '08:00', '12:00', 1500, 5);
insert into class
values (DEFAULT, 'FREE TRAINEE', '2022-12-20', '08:00', '17:00', 1000, 8);

-- создаём инструкторов
insert into instructor
values (306, 'ANTON', 'instructor_anton@mail.ru', '+79112273399', 'male');

-- соединяем инструкторов и занятия
insert into instructor_class_relation
values (DEFAULT, 306, 1);
insert into instructor_class_relation
values (DEFAULT, 306, 2);

-- создаём брони на занятия клиентами
insert into booking
values (DEFAULT, 1, 5);
insert into booking
values (DEFAULT, 2, 5);
insert into booking
values (DEFAULT, 3, 6);
insert into booking
values (DEFAULT, 4, 6);
insert into booking
values (DEFAULT, 1, 1);
insert into booking
values (DEFAULT, 2, 3);

-- создаем классификаторы для всего-всего
insert into classifier
values (DEFAULT, 'ЙОГА', 'ОБЩАЯ');
insert into classifier
values (DEFAULT, 'ЙОГА', 'ХАТХА');
insert into classifier
values (DEFAULT, 'СИЛОВАЯ', 'НОГИ');
insert into classifier
values (DEFAULT, 'СИЛОВАЯ', 'РУКИ');
insert into classifier
values (DEFAULT, 'СИЛОВАЯ', 'ТУЛОВИЩЕ');
insert into classifier
values (DEFAULT, 'СИЛОВАЯ', 'ВЫНОСЛИВОСТЬ');
insert into classifier
values (DEFAULT, 'ФУТБОЛ', 'ПРОФЕССИОНАЛЬНЫЙ УРОВЕНЬ');
insert into classifier
values (DEFAULT, 'ФУТБОЛ', 'НАЧАЛЬНЫЙ УРОВЕНЬ');
insert into classifier
values (DEFAULT, 'БОЛЬШОЙ ТЕННИС', 'НАЧАЛЬНЫЙ УРОВЕНЬ');
insert into classifier
values (DEFAULT, 'БОЛЬШОЙ ТЕННИС', 'ПРОДВИНУТЫЙ УРОВЕНЬ');
insert into classifier
values (DEFAULT, 'БОЛЬШОЙ ТЕННИС', 'ПРОФЕССИОНАЛЬНЫЙ УРОВЕНЬ');
insert into classifier
values (DEFAULT, 'ТЕННИСНЫЙ СТОЛ', 'ЕСТЬ');
insert into classifier
values (DEFAULT, 'БАССЕЙН', 'ЕСТЬ');
insert into classifier
values (DEFAULT, 'БАНЯ', 'ЕСТЬ');

-- соединяем их с оставшимися таблицами
insert into instructor_classifier_relation
values (DEFAULT, 306, 4);
insert into instructor_classifier_relation
values (DEFAULT, 306, 6);

insert into pos_classifier_relation
values (DEFAULT, 3, 1);
insert into pos_classifier_relation
values (DEFAULT, 3, 2);
insert into pos_classifier_relation
values (DEFAULT, 1, 3);
insert into pos_classifier_relation
values (DEFAULT, 1, 4);
insert into pos_classifier_relation
values (DEFAULT, 1, 5);
insert into pos_classifier_relation
values (DEFAULT, 1, 6);
insert into pos_classifier_relation
values (DEFAULT, 2, 3);
insert into pos_classifier_relation
values (DEFAULT, 2, 4);
insert into pos_classifier_relation
values (DEFAULT, 2, 5);
insert into pos_classifier_relation
values (DEFAULT, 2, 6);
insert into pos_classifier_relation
values (DEFAULT, 8, 14);

insert into class_classifier_relation
values (DEFAULT, 5, 9);
insert into class_classifier_relation
values (DEFAULT, 5, 10);
insert into class_classifier_relation
values (DEFAULT, 5, 11);
insert into class_classifier_relation
values (DEFAULT, 6, 9);
insert into class_classifier_relation
values (DEFAULT, 6, 10);
insert into class_classifier_relation
values (DEFAULT, 6, 11);

