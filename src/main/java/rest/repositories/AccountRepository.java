package rest.repositories;

import org.springframework.data.repository.CrudRepository;
import rest.models.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
