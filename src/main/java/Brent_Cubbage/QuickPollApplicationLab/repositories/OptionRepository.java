package Brent_Cubbage.QuickPollApplicationLab.repositories;

import Brent_Cubbage.QuickPollApplicationLab.domain.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {
}
