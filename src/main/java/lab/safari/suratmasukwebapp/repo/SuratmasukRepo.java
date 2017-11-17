package lab.safari.suratmasukwebapp.repo;

import lab.safari.suratmasukwebapp.entity.Suratmasuk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuratmasukRepo

        extends JpaRepository<Suratmasuk,String> {}