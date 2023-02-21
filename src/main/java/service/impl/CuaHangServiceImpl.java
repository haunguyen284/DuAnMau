/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.CuaHangMapper;
import common.validator.MyValidatorFactory;
import dto.CuaHangDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.CuaHang;
import repository.CuaHangRepository;
import service.CuaHangService;

/**
 *
 * @author macbook
 */
public class CuaHangServiceImpl implements CuaHangService {

    private final CuaHangRepository cuaHangRepository;

    public CuaHangServiceImpl() {
        this.cuaHangRepository = new CuaHangRepository();
    }

    @Override
    public List<CuaHangDTO> findAll(int position, int pageSize) {
        List<CuaHangDTO> listCuaHangDTO = new ArrayList<>();
        List<CuaHang> listCuaHang = cuaHangRepository.findAll(position, pageSize);
        for (CuaHang c : listCuaHang) {
            listCuaHangDTO.add(CuaHangMapper.INSTANCE.toDTO(c));
        }
        return listCuaHangDTO;
    }

    @Override
    public CuaHangDTO findById(UUID id) {
        CuaHang c = cuaHangRepository.findById(id);
        return CuaHangMapper.INSTANCE.toDTO(c);
    }

    @Override
    public String create(CuaHangDTO cuaHangDTO) {
        cuaHangDTO.setId(null);
        CuaHang model = CuaHangMapper.INSTANCE.toModel(cuaHangDTO);
        if (cuaHangRepository.findByMa(cuaHangDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<CuaHang>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<CuaHang> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (cuaHangRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(CuaHangDTO cuaHangDTO) {
        CuaHang model = CuaHangMapper.INSTANCE.toModel(cuaHangDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<CuaHang>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<CuaHang> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (cuaHangRepository.save(model) != null) {
            result = "Sửa thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return cuaHangRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return cuaHangRepository.totalCount();
    }

    @Override
    public CuaHangDTO findByMa(String ma) {
        CuaHang c = cuaHangRepository.findByMa(ma);
        return CuaHangMapper.INSTANCE.toDTO(c);
    }

    @Override
    public List<CuaHangDTO> findAll() {
        List<CuaHangDTO> listCuaHangDTO = new ArrayList<>();
        List<CuaHang> listCuaHang = cuaHangRepository.findAll();
        for (CuaHang c : listCuaHang) {
            listCuaHangDTO.add(CuaHangMapper.INSTANCE.toDTO(c));
        }
        return listCuaHangDTO;
    }

}
