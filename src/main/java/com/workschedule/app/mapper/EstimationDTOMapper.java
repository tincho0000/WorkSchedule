package com.workschedule.app.mapper;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workschedule.app.dto.EstimationDTO;

import java.io.IOException;

public class EstimationDTOMapper {
    public EstimationDTO convert(String source) {
        JsonFactory factory = new JsonFactory();
        ObjectMapper objectMappper = new ObjectMapper();
        EstimationDTO estimation = new EstimationDTO();
        String fixValue = source.replaceAll("\r", "").replaceAll("\n", "");
        try {
            JsonParser parser = factory.createParser(fixValue);
            estimation = objectMappper.readValue(parser, EstimationDTO.class);
            System.out.println("fase:" + estimation.getFase() + "/ version:" + estimation.getVersion() + "/cant hs:" + estimation.getCantidadHoras());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        EstimationDTO estimationDTO = new EstimationDTO();
        estimationDTO.setFase(estimation.getFase());
        estimationDTO.setVersion(estimation.getVersion());
        estimationDTO.setCantidadHoras(estimation.getCantidadHoras());
        estimationDTO.setUsuarioAlta(estimation.getUsuarioAlta());
        estimationDTO.setActivo(estimation.getActivo());
        return estimationDTO;
    }
}

