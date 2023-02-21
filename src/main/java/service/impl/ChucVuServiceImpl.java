/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.ChucVuMapper;
import common.validator.MyValidatorFactory;
import dto.ChucVuDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.ChucVu;
import repository.ChucVuRepository;
import service.ChucVuService;

/**
 *
 * @author macbook
 */
public class ChucVuServiceImpl implements ChucVuService {

    private final ChucVuRepository chucVuRepository;

    public ChucVuServiceImpl() {
        this.chucVuRepository = new ChucVuRepository();
    }

    @Override
    public List<ChucVuDTO> findAll(int position, int pageSize) {
        List<ChucVuDTO> listChucVuDTO = new ArrayList<>();
        List<ChucVu> listChucVu = chucVuRepository.findAll(position, pageSize);
        for (ChucVu c : listChucVu) {
            listChucVuDTO.add(ChucVuMapper.INSTANCE.toDTO(c));
        }
        return listChucVuDTO;
    }

    @Override
    public ChucVuDTO findById(UUID id) {
        ChucVu c = chucVuRepository.findById(id);
        return ChucVuMapper.INSTANCE.toDTO(c);
    }

    @Override
    public String create(ChucVuDTO chucVuDTO) {
        chucVuDTO.setId(null);
        ChucVu model = ChucVuMapper.INSTANCE.toModel(chucVuDTO);
        if (chucVuRepository.findByMa(chucVuDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<ChucVu>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<ChucVu> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (chucVuRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(ChucVuDTO chucVuDTO) {
        
        ChucVu model = ChucVuMapper.INSTANCE.toModel(chucVuDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<ChucVu>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<ChucVu> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (chucVuRepository.save(model) != null) {
            result = "Sửa thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return chucVuRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return chucVuRepository.totalCount();
    }

    @Override
    public ChucVuDTO findByMa(String ma) {
        ChucVu c = chucVuRepository.findByMa(ma);
        return ChucVuMapper.INSTANCE.toDTO(c);
    }

    @Override
    public List<ChucVuDTO> findAll() {
        List<ChucVuDTO> listChucVuDTO = new ArrayList<>();
        List<ChucVu> listChucVu = chucVuRepository.findAll();
        for (ChucVu c : listChucVu) {
            listChucVuDTO.add(ChucVuMapper.INSTANCE.toDTO(c));
        }
        return listChucVuDTO;
    }

}
