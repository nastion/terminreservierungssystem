package trs.repositories;

import trs.data.Poll;
import trs.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface PollRepository extends JpaRepository<Poll, Long> {
    Set<Poll> findAllByOrganisator(User organisator);
    Poll findPollByTitle(String title);
}
