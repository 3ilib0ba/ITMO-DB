package com.example.demo.studio.repository;

import com.example.demo.studio.model.LegalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalInfoRepository extends JpaRepository<LegalInfo, Long> {

    public LegalInfo getLegalInfoByMail(String mail);

    public LegalInfo getLegalInfoByTIN(String tin);

}
