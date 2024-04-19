package uni.miskolc.swgyak.bdsm.service.interfaces;

import uni.miskolc.swgyak.bdsm.model.entities.Dvd;

import java.util.List;

public interface DvdService {
    Long addDvd(Dvd dvd);
    List<Dvd> getAllDvd();
    Dvd getDvd(Long id);
    void deleteDvd(Long id);

}
