package rest.repositories;

import org.springframework.data.repository.CrudRepository;
import rest.transaction.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
