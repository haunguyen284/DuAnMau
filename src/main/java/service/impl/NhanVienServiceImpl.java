/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.NhanVienMapper;
import common.validator.MyValidatorFactory;
import dto.NhanVienDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.NhanVien;
import repository.NhanVienRepository;
import service.NhanVienService;

/**
 *
 * @author macbook
 */
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    public NhanVienServiceImpl() {
        this.nhanVienRepository = new NhanVienRepository();
    }

    @Override
    public List<NhanVienDTO> findAll(int position, int pageSize) {
        List<NhanVienDTO> listNVDTO = new ArrayList<>();
        List<NhanVien> listNhanVien = nhanVienRepository.findAll(position, pageSize);
        for (NhanVien nv : listNhanVien) {
            listNVDTO.add(NhanVienMapper.INSTANCE.toDTO(nv));
        }
        return listNVDTO;
    }

    @Override
    public NhanVienDTO findById(UUID id) {
        NhanVien nv = nhanVienRepository.findById(id);
        return NhanVienMapper.INSTANCE.toDTO(nv);
    }

    @Override
    public String create(NhanVienDTO nhanVienDTO) {
        nhanVienDTO.setId(null);
        NhanVien model = NhanVienMapper.INSTANCE.toModel(nhanVienDTO);
        if (nhanVienRepository.findByMa(nhanVienDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<NhanVien>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<NhanVien> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (nhanVienRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(NhanVienDTO nhanVienDTO) {
        NhanVien model = NhanVienMapper.INSTANCE.toModel(nhanVienDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<NhanVien>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<NhanVien> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (nhanVienRepository.save(model) != null) {
            result = "Sửa thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return nhanVienRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return nhanVienRepository.totalCount();
    }

    @Override
    public NhanVienDTO findByMa(String maNVBC) {
        NhanVien nv = nhanVienRepository.findByMa(maNVBC);
        return NhanVienMapper.INSTANCE.toDTO(nv);
    }

    @Override
    public List<NhanVienDTO> findAll() {
        List<NhanVienDTO> listNVDTO = new ArrayList<>();
        List<NhanVien> listNhanVien = nhanVienRepository.findAll();
        for (NhanVien nv : listNhanVien) {
            listNVDTO.add(NhanVienMapper.INSTANCE.toDTO(nv));
        }
        return listNVDTO;
    }

}
