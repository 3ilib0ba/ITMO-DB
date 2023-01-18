package com.example.demo.studio.service;

import com.example.demo.studio.exceptions.StudioNotFoundException;
import com.example.demo.studio.model.LegalInfo;
import com.example.demo.studio.repository.LegalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegalInfoService {
    @Autowired
    private StudioService studioService;

    @Autowired
    private LegalInfoRepository legalInfoRepository;

    public LegalInfo getInfoByStudioName(
            String studioName
    ) throws StudioNotFoundException {
        return studioService.getStudioByName(studioName).getLegalInfo();
    }


}
