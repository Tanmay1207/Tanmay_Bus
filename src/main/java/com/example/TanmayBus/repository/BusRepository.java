package com.example.TanmayBus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.TanmayBus.model.Bus;
import org.springframework.stereotype.Repository;




@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
   List<Bus> findByBusType(String busType);


   Bus findByBusName(String busName);
}
