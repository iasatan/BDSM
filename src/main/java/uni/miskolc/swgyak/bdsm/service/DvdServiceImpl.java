package uni.miskolc.swgyak.bdsm.service;

import org.springframework.stereotype.Service;
import uni.miskolc.swgyak.bdsm.model.entities.Dvd;
import uni.miskolc.swgyak.bdsm.persist.DvdRepository;
import uni.miskolc.swgyak.bdsm.service.interfaces.DvdService;

import java.util.List;

@Service
public class DvdServiceImpl implements DvdService {

    private DvdRepository dvdRepository;

    public DvdServiceImpl(DvdRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }

    @Override
    public Long addDvd(Dvd dvd) {
        Long id = dvdRepository.save(dvd).getId();
        return id;
    }

    @Override
    public List<Dvd> getAllDvd() {
        List<Dvd> dvds = (List<Dvd>) dvdRepository.findAll();
        return dvds;
    }

    @Override
    public Dvd getDvd(Long id) {
        Dvd dvd = dvdRepository.findById(id).get();
        return dvd;
    }

    @Override
    public void deleteDvd(Long id) {
        dvdRepository.deleteById(id);
    }
}
