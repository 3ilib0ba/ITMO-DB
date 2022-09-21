/* Вывести список зданий по убыванию в количестве их взаимодействий */

select build.id, build.type, build.address, COUNT(build.id)
from building build
         INNER JOIN object_build ob on build.id = ob.building_id
         LEFT JOIN interactions i on ob.id = i.object_build_id

GROUP BY build.id
ORDER BY COUNT(build.id) desc;











select build.*, COUNT(build.id)
from building build
         INNER JOIN object_build ob on build.id = ob.building_id
         LEFT JOIN interactions i on ob.id = i.object_build_id
GROUP BY build.id
ORDER BY COUNT(build.id) desc;

select a.id, a.building_id, COUNT(a.id)
from object_build as a
         LEFT JOIN interactions as b on b.object_build_id = a.id
GROUP BY a.id
ORDER BY count(a.id) desc;
