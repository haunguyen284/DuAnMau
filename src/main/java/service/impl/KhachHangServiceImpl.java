/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.KhachHangMapper;
import common.validator.MyValidatorFactory;
import dto.KhachHangDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.KhachHang;
import repository.KhachHangRepository;
import service.KhachHangService;

/**
 *
 * @author macbook
 */
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;

    public KhachHangServiceImpl() {
        this.khachHangRepository = new KhachHangRepository();
    }

    @Override
    public List<KhachHangDTO> findAll(int position, int pageSize) {
        List<KhachHangDTO> listDTO = new ArrayList<>();
        List<KhachHang> listCuaHang = khachHangRepository.findAll(position, pageSize);
        for (KhachHang c : listCuaHang) {
            listDTO.add(KhachHangMapper.INSTANCE.toDTO(c));
        }
        return listDTO;
    }
    
    @Override
    public List<KhachHangDTO> findAll() {
        List<KhachHangDTO> listDTO = new ArrayList<>();
        List<KhachHang> listCuaHang = khachHangRepository.findAll();
        for (KhachHang c : listCuaHang) {
            listDTO.add(KhachHangMapper.INSTANCE.toDTO(c));
        }
        return listDTO;
    }

    @Override
    public KhachHangDTO findById(UUID id) {
        KhachHang c = khachHangRepository.findById(id);
        return KhachHangMapper.INSTANCE.toDTO(c);
    }
    
    @Override
    public KhachHangDTO findByMa(String ma) {
        KhachHang c = khachHangRepository.findByMa(ma);
        return KhachHangMapper.INSTANCE.toDTO(c);
    }

    @Override
    public String create(KhachHangDTO khachHangDTO) {
        khachHangDTO.setId(null);
        KhachHang model = KhachHangMapper.INSTANCE.toModel(khachHangDTO);
        if (khachHangRepository.findByMa(khachHangDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<KhachHang>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<KhachHang> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (khachHangRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(KhachHangDTO khachHangDTO) {
        KhachHang model = KhachHangMapper.INSTANCE.toModel(khachHangDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<KhachHang>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<KhachHang> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (khachHangRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return khachHangRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return khachHangRepository.totalCount();
    }

}
