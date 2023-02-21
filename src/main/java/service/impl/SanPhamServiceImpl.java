/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.SanPhamMapper;
import common.validator.MyValidatorFactory;
import dto.SanPhamDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.SanPham;
import repository.SanPhamRepository;
import service.SanPhamService;

/**
 *
 * @author macbook
 */
public class SanPhamServiceImpl implements SanPhamService{
    
    private final SanPhamRepository sanPhamRepository;
    
    public SanPhamServiceImpl() {
        this.sanPhamRepository = new SanPhamRepository();
    }

    @Override
    public List<SanPhamDTO> findAll(int position, int pageSize) {
        List<SanPhamDTO> listDTO = new ArrayList<>();
        List<SanPham> listModel = sanPhamRepository.findAll(position, pageSize);
        for (SanPham nv : listModel) {
            listDTO.add(SanPhamMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public List<SanPhamDTO> findAll() {
        List<SanPhamDTO> listDTO = new ArrayList<>();
        List<SanPham> listModel = sanPhamRepository.findAll();
        for (SanPham nv : listModel) {
            listDTO.add(SanPhamMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public SanPhamDTO findById(UUID id) {
        SanPham sanPham = sanPhamRepository.findById(id);
        return SanPhamMapper.INSTANCE.toDTO(sanPham);
    }

    @Override
    public SanPhamDTO findByMa(String ma) {
        SanPham sanPham = sanPhamRepository.findByMa(ma);
        return SanPhamMapper.INSTANCE.toDTO(sanPham);
    }

    @Override
    public String create(SanPhamDTO sanPhamDTO) {
        sanPhamDTO.setId(null);
        SanPham model = SanPhamMapper.INSTANCE.toModel(sanPhamDTO);
        if (sanPhamRepository.findByMa(sanPhamDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<SanPham>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<SanPham> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (sanPhamRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(SanPhamDTO sanPhamDTO) {
        SanPham model = SanPhamMapper.INSTANCE.toModel(sanPhamDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<SanPham>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<SanPham> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (sanPhamRepository.save(model) != null) {
            result = "Sửa thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return sanPhamRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return sanPhamRepository.totalCount();
    }
    
}
