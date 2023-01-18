package com.example.demo.studio.service;

import com.example.demo.balance.model.Balance;
import com.example.demo.balance.repository.BalanceRepository;
import com.example.demo.client.exceptions.MailIsAlreadyExistException;
import com.example.demo.client.exceptions.MailNotFoundException;
import com.example.demo.client.model.Role;
import com.example.demo.client.repository.RoleRepository;
import com.example.demo.config.RoleConfig;
import com.example.demo.studio.exceptions.StudioNotFoundException;
import com.example.demo.studio.exceptions.TinIsAlreadyExistException;
import com.example.demo.studio.exceptions.TinNotFoundException;
import com.example.demo.studio.model.LegalInfo;
import com.example.demo.studio.model.Position;
import com.example.demo.studio.model.Studio;
import com.example.demo.studio.repository.LegalInfoRepository;
import com.example.demo.studio.repository.PositionRepository;
import com.example.demo.studio.repository.StudioRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {
    @Autowired
    private LegalInfoRepository legalInfoRepository;
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private PositionRepository positionRepository;

    public LegalInfo addLegalInfo(
            String fullDescription,
            @Nullable
            String phone,
            String mail,
            String TIN
    ) {
        LegalInfo legalInfo = new LegalInfo(
                legalInfoRepository.count() + 1,
                fullDescription,
                phone == null ? "" : phone,
                mail,
                TIN
        );
        return legalInfoRepository.save(legalInfo);
    }

    public Studio getStudioById(Long studioId) throws StudioNotFoundException {
        Studio studio = studioRepository.getStudioById(studioId);
        if (studio == null)
            throw new StudioNotFoundException();
        return studio;
    }

    public Studio getStudioByName(String studioName) throws StudioNotFoundException {
        Studio studio = studioRepository.getStudioByName(studioName);
        if (studio == null)
            throw new StudioNotFoundException();
        return studio;
    }

    public Studio addStudioAndLegalInfo(
            String name, String description,
            String fullDescription, String mail, @Nullable String phone, String tin
    ) throws MailNotFoundException, TinNotFoundException, MailIsAlreadyExistException, TinIsAlreadyExistException {
        if (mail == null)
            throw new MailNotFoundException();
        if (tin == null)
            throw new TinNotFoundException();
        LegalInfo legalInfoMail = legalInfoRepository.getLegalInfoByMail(mail);
        if (legalInfoMail != null)
            throw new MailIsAlreadyExistException();
        LegalInfo legalInfoPhone = legalInfoRepository.getLegalInfoByTIN(tin);
        if (legalInfoPhone != null)
            throw new TinIsAlreadyExistException();

        Role role = roleRepository.getRoleByRole(RoleConfig.ROLE_MANAGER.toString());
        LegalInfo legalInfo = addLegalInfo(fullDescription, phone, mail, tin);
        Balance balance = new Balance(balanceRepository.count() + 1, (float) 0, role);
        balance = balanceRepository.save(balance);
        Studio studio = new Studio(studioRepository.count() + 1, name, description, role, legalInfo, balance);
        return studioRepository.save(studio);
    }

    public List<Studio> getAllStudios() {
        return studioRepository.getAllStudios();
    }

    public Position addPositionToStudio(
            Long studioId,
            String address, String hours
    ) throws StudioNotFoundException {
        Studio studio = getStudioById(studioId);
        return positionRepository.save(new Position(positionRepository.count() + 1, address, hours, studio));
    }

}
