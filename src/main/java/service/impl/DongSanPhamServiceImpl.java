/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.DongSanPhamMapper;
import common.mapper.DongSanPhamMapperImpl;
import common.validator.MyValidatorFactory;
import dto.DongSanPhamDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.DongSanPham;
import repository.DongSanPhamRepository;
import service.DongSanPhamService;

/**
 *
 * @author macbook
 */
public class DongSanPhamServiceImpl implements DongSanPhamService {

    private final DongSanPhamRepository dongSPRepository;

    public DongSanPhamServiceImpl() {
        this.dongSPRepository = new DongSanPhamRepository();
    }

    @Override
    public List<DongSanPhamDTO> findAll(int position, int pageSize) {
        List<DongSanPhamDTO> listDTO = new ArrayList<>();
        List<DongSanPham> listModel = dongSPRepository.findAll(position, pageSize);
        for (DongSanPham nv : listModel) {
            listDTO.add(DongSanPhamMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public List<DongSanPhamDTO> findAll() {
        List<DongSanPhamDTO> listDTO = new ArrayList<>();
        List<DongSanPham> listModel = dongSPRepository.findAll();
        for (DongSanPham nv : listModel) {
            listDTO.add(DongSanPhamMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public DongSanPhamDTO findById(UUID id) {
        DongSanPham model = dongSPRepository.findById(id);
        return DongSanPhamMapper.INSTANCE.toDTO(model);
    }

    @Override
    public DongSanPhamDTO findByMa(String ma) {
        DongSanPham model = dongSPRepository.findByMa(ma);
        return DongSanPhamMapper.INSTANCE.toDTO(model);
    }

    @Override
    public String create(DongSanPhamDTO dongSanPhamDTO) {
        dongSanPhamDTO.setId(null);
        DongSanPham model = DongSanPhamMapper.INSTANCE.toModel(dongSanPhamDTO);
        if (dongSPRepository.findByMa(dongSanPhamDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<DongSanPham>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<DongSanPham> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (dongSPRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(DongSanPhamDTO dongSanPhamDTO) {
        DongSanPham model = DongSanPhamMapper.INSTANCE.toModel(dongSanPhamDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<DongSanPham>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<DongSanPham> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (dongSPRepository.save(model) != null) {
            result = "Sửa thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return dongSPRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return dongSPRepository.totalCount();
    }

}
