package com.breakingbad.service;

import com.breakingbad.dto.DeathsDto;

import java.util.List;

public interface DeathsService {

    List<DeathsDto> getAllDeaths();

    void saveDeaths();
}
