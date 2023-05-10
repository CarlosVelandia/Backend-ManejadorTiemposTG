select count(1)
from etapa
where id <> :id
  and codigo = :codigo