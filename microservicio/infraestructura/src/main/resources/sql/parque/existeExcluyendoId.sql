select count(1)
from parque
where id <> :id
  and codigo = :codigo