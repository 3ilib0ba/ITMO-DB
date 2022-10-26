-- Тестовый запрос
select *
from "Н_ВЕДОМОСТИ";

-- Задание №1
-- Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:
-- Н_ТИПЫ_ВЕДОМОСТЕЙ, Н_ВЕДОМОСТИ.
-- Вывести атрибуты: Н_ТИПЫ_ВЕДОМОСТЕЙ.НАИМЕНОВАНИЕ, Н_ВЕДОМОСТИ.ИД.
-- Фильтры (AND):
-- a) Н_ТИПЫ_ВЕДОМОСТЕЙ.ИД < 3.
-- b) Н_ВЕДОМОСТИ.ДАТА < 2022-06-08.
-- Вид соединения: RIGHT JOIN.
SELECT "НАИМЕНОВАНИЕ", НВ."ИД"
FROM "Н_ТИПЫ_ВЕДОМОСТЕЙ" AS ТВ
         RIGHT OUTER JOIN "Н_ВЕДОМОСТИ" AS НВ ON ТВ."ИД" = НВ."ТВ_ИД"
WHERE ТВ."ИД" < 3
  AND НВ."ДАТА" < DATE '2022-06-08';

-- Задание №2
-- Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:
-- Таблицы: Н_ЛЮДИ, Н_ВЕДОМОСТИ, Н_СЕССИЯ.
-- Вывести атрибуты: Н_ЛЮДИ.ИМЯ, Н_ВЕДОМОСТИ.ЧЛВК_ИД, Н_СЕССИЯ.ДАТА.
-- Фильтры (AND):
-- a) Н_ЛЮДИ.ОТЧЕСТВО < Владимирович.
-- b) Н_ВЕДОМОСТИ.ЧЛВК_ИД > 153285.
-- c) Н_СЕССИЯ.УЧГОД > 2003/2004.
-- Вид соединения: INNER JOIN.
SELECT ЛЮДИ."ИМЯ", НВ."ЧЛВК_ИД", СЕССИЯ."ДАТА", СЕССИЯ."УЧГОД"
FROM "Н_ЛЮДИ" AS ЛЮДИ
         INNER JOIN "Н_ВЕДОМОСТИ" AS НВ ON ЛЮДИ."ИД" = НВ."ЧЛВК_ИД"
         INNER JOIN "Н_СЕССИЯ" AS СЕССИЯ ON ЛЮДИ."ИД" = СЕССИЯ."ЧЛВК_ИД"
WHERE ЛЮДИ."ОТЧЕСТВО" < 'Владимирович' -- сравнение стандартное, посимвольное, не по длине слова.
  AND НВ."ЧЛВК_ИД" > 153285
  AND СЕССИЯ."УЧГОД" > '2003/2004';
-- будет нормально работать, так как сравнивает посимвольно, а года всегда имеют такой формат.
-- ORDER BY НВ."ЧЛВК_ИД" DESC
-- Запрос не даст результатов, так как максимальный ЧЛВК_ИД = 134262, а следует искать > 153285


-- Задание №3
-- Вывести число фамилий и отчеств без учета повторений.
-- При составлении запроса нельзя использовать DISTINCT.
SELECT count(*) AS last_name_count
FROM (SELECT count("ФАМИЛИЯ") AS last_name
      FROM "Н_ЛЮДИ" AS ЛЮДИ
      GROUP BY "ФАМИЛИЯ") AS ЛФ;
SELECT count(*) AS father_name_count
FROM (SELECT count("ОТЧЕСТВО") AS father_name
      FROM "Н_ЛЮДИ" AS ЛЮДИ
      GROUP BY "ОТЧЕСТВО") AS ЛФ;


-- Задание №4
-- Найти группы, в которых в 2011 году было менее 5 обучающихся студентов на кафедре вычислительной техники.
-- Для реализации использовать подзапрос.
SELECT "ГРУППА"
FROM (SELECT count(*) as count_st, "ГРУППА"
      FROM "Н_УЧЕНИКИ" AS ST
      WHERE ST."НАЧАЛО" >= TIMESTAMP '2011-09-01 00:00:00.000000'
        AND ST."КОНЕЦ" < TIMESTAMP '2012-09-01 00:00:00.000000'
      GROUP BY "ГРУППА") AS inner_sql
WHERE count_st < 5;


-- Задание №5
-- Выведите таблицу со средним возрастом студентов во всех группах (Группа, Средний возраст),
-- где средний возраст меньше максимального возраста в группе 1101.
SELECT ST."ГРУППА", AVG(date_part('year', age(PEOP."ДАТА_РОЖДЕНИЯ"))) as avg_age
FROM "Н_УЧЕНИКИ" AS ST
         INNER JOIN "Н_ЛЮДИ" AS PEOP on ST."ЧЛВК_ИД" = PEOP."ИД"
GROUP BY ST."ГРУППА"
HAVING AVG(date_part('year', age(PEOP."ДАТА_РОЖДЕНИЯ"))) <
       (SELECT MAX(date_part('year', age(PEOP."ДАТА_РОЖДЕНИЯ")))
        FROM "Н_УЧЕНИКИ" AS ST
                 INNER JOIN "Н_ЛЮДИ" AS PEOP on ST."ЧЛВК_ИД" = PEOP."ИД"
        WHERE ST."ГРУППА" = '1101');
-- результат данного подзапроса по поиску максимального возраста в группе 1101 = 38





-- Задание №6
-- Получить список студентов, зачисленных до первого сентября 2012 года на первый курс заочной формы обучения (специальность: Программная инженерия). В результат включить:
-- номер группы;
-- номер, фамилию, имя и отчество студента;
-- номер и состояние пункта приказа;
SELECT * FROM "Н_НАПР_СПЕЦ";

SELECT sp_type."НАИМЕНОВАНИЕ", "УЧЕБНЫЙ_ГОД", "КУРС", st."ГРУППА", peop."ФАМИЛИЯ", peop."ИМЯ", peop."ОТЧЕСТВО"
FROM "Н_НАПРАВЛЕНИЯ_СПЕЦИАЛ" as sp
INNER JOIN "Н_НАПР_СПЕЦ" sp_type on sp."НС_ИД" = sp_type."ИД"
INNER JOIN "Н_ПЛАНЫ" as plans on plans."НАПС_ИД" = sp."ИД"
INNER JOIN "Н_УЧЕНИКИ" as st on plans."ИД" = st."ПЛАН_ИД"
INNER JOIN "Н_ЛЮДИ" as peop on peop."ИД" = st."ЧЛВК_ИД"
WHERE sp_type."ИД" = 741            -- Направление программной инженерии
AND plans."КУРС" = 1                -- Курс зачисления

; --


-- Задание №7
-- Сформировать запрос для получения числа на ФКТИУ троечников.