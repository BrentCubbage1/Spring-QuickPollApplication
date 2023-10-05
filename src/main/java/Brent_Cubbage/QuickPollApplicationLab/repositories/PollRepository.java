package Brent_Cubbage.QuickPollApplicationLab.repositories;

import Brent_Cubbage.QuickPollApplicationLab.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
}
