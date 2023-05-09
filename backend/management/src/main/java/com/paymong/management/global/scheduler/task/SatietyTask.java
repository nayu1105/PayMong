package com.paymong.management.global.scheduler.task;

import com.paymong.management.global.exception.NotFoundMongException;
import com.paymong.management.mong.entity.Mong;
import com.paymong.management.mong.repository.MongRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class SatietyTask {
    private final MongRepository mongRepository;
    @Transactional
    public Boolean reduceSatiety(Long mongId) throws NotFoundMongException {
        Mong mong = mongRepository.findByMongIdAndActive(mongId, true)
                .orElseThrow(() -> new NotFoundMongException());

        Integer poop = mong.getPoopCount();
        Integer satiety = mong.getSatiety();
        if(poop == 0){
            satiety = satiety - 1 < 0 ? 0 : satiety - 1;
            mong.setSatiety(satiety);
        }else{
            satiety = satiety - (poop*poop) < 0 ? 0 : satiety - (poop*poop);
            mong.setSatiety(satiety);
        }
        if(satiety == 0){
            log.info("{}의 죽음의 카운트가 시작됩니다.", mongId);
            return false;
        }
        log.info("{}의 포만감이 감소하였습니다.", mongId);
        return true;
    }
}
