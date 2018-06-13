package trs.repositories;

import trs.data.Poll;
import trs.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface PollRepository extends JpaRepository<Poll, Long> {
    /**
     * Finds all Polls where the user organisator is the organisator
     * @param organisator the user to search
     * @return a set of polls
     */
    Set<Poll> findAllByOrganisator(User organisator);

    /**
     * Returns a poll by it's title
     * @param title the title
     * @return a poll object
     */
    Poll findPollByTitle(String title);
}
