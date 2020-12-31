package backend.home.challenge.job.schedule.repository;

import backend.home.challenge.job.schedule.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
    @Query(value = "from Message m where m.timing BETWEEN :startDate AND :endDate")
    public List<Message> findByTimingBetween(@Param("startDate") Date start, @Param("endDate") Date end);
}
