package com.encuentro.matrimonial.implementation;

import com.encuentro.matrimonial.modelo.Lote;
import com.encuentro.matrimonial.repository.ILoteRepository;
import com.encuentro.matrimonial.service.ILoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteService implements ILoteService {

	@Autowired
	private ILoteRepository loteDao;

	@Override
	public List<Lote> getLotes() {
		return (List<Lote>) loteDao.findAll();
	}

	@Override
	public void createLote(Lote lote) {
		loteDao.save(lote);
	}

	@Override
	public Lote updateLote(Lote lote) {
		return loteDao.save(lote);
	}

	@Override
	public void deleteLote(Long id) {
		loteDao.deleteById(id);

	}

	@Override
	public Optional<Lote> findByIdLote(Long id) {
		return loteDao.findById(id);
	}

	@Override
	public Lote findByLote(Long lote) {
		return loteDao.findByLote(lote);
	}

	@Override
	public Lote findBy(Long lot) {
		return loteDao.findBy(lot);
	}

}
