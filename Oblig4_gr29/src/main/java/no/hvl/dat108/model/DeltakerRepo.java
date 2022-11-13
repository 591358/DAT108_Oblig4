package no.hvl.dat108.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltakerRepo extends JpaRepository<Deltaker, String> {
	Deltaker findByFornavn(String fornavn);

	Deltaker findByMobil(Object object);

	boolean existsByMobil(String mobil);
}