/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.NhaSanXuatMapper;
import common.validator.MyValidatorFactory;
import dto.NhaSanXuatDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.NhaSanXuat;
import repository.NhaSanXuatRepository;
import service.NhaSanXuatService;

/**
 *
 * @author macbook
 */
public class NhaSanXuatServiceImpl implements NhaSanXuatService{
    private final NhaSanXuatRepository nhaSanXuatRepository;
    
    public NhaSanXuatServiceImpl() {
        this.nhaSanXuatRepository = new NhaSanXuatRepository();
    }

    @Override
    public List<NhaSanXuatDTO> findAll(int position, int pageSize) {
        List<NhaSanXuatDTO> listDTO = new ArrayList<>();
        List<NhaSanXuat> listModel = nhaSanXuatRepository.findAll(position, pageSize);
        for (NhaSanXuat nv : listModel) {
            listDTO.add(NhaSanXuatMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public List<NhaSanXuatDTO> findAll() {
        List<NhaSanXuatDTO> listDTO = new ArrayList<>();
        List<NhaSanXuat> listModel = nhaSanXuatRepository.findAll();
        for (NhaSanXuat nv : listModel) {
            listDTO.add(NhaSanXuatMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public NhaSanXuatDTO findById(UUID id) {
        NhaSanXuat model = nhaSanXuatRepository.findById(id);
        return NhaSanXuatMapper.INSTANCE.toDTO(model);
    }

    @Override
    public NhaSanXuatDTO findByMa(String ma) {
        NhaSanXuat model = nhaSanXuatRepository.findByMa(ma);
        return NhaSanXuatMapper.INSTANCE.toDTO(model);
    }

    @Override
    public String create(NhaSanXuatDTO nhaSanXuatDTO) {
        nhaSanXuatDTO.setId(null);
        NhaSanXuat model = NhaSanXuatMapper.INSTANCE.toModel(nhaSanXuatDTO);
        if (nhaSanXuatRepository.findByMa(nhaSanXuatDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<NhaSanXuat>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<NhaSanXuat> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (nhaSanXuatRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(NhaSanXuatDTO nhaSanXuatDTO) {
        NhaSanXuat model = NhaSanXuatMapper.INSTANCE.toModel(nhaSanXuatDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<NhaSanXuat>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<NhaSanXuat> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (nhaSanXuatRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return nhaSanXuatRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return nhaSanXuatRepository.totalCount();
    }
    
}
