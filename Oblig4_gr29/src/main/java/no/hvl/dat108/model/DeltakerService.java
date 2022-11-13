package no.hvl.dat108.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeltakerService {
	@Autowired
	private DeltakerRepo deltakerRepo;

	public List<Deltaker> finnAlleDeltakere() {
		return deltakerRepo.findAll();
	}

	public List<Deltaker> sorterNavn() {
		return deltakerRepo.findAll().stream()
				.sorted(Comparator.comparing(Deltaker::getFornavn)
						.thenComparing(Comparator.comparing(Deltaker::getEtternavn).reversed()))
				.collect(Collectors.toList());
	}

	public static List<Deltaker> sorterNavnTest(List<Deltaker> liste) {
		return liste.stream()
				.sorted(Comparator.comparing(Deltaker::getFornavn)
						.thenComparing(Comparator.comparing(Deltaker::getEtternavn).reversed()))
				.collect(Collectors.toList());
	}

}
