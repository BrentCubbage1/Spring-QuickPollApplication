package Brent_Cubbage.QuickPollApplicationLab.repositories;

import Brent_Cubbage.QuickPollApplicationLab.domain.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {
}
