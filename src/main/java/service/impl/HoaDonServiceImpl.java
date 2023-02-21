/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.HoaDonMapper;
import common.validator.MyValidatorFactory;
import dto.HoaDonDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.HoaDon;
import repository.HoaDonRepository;
import service.HoaDonService;

/**
 *
 * @author macbook
 */
public class HoaDonServiceImpl implements HoaDonService{
    private final HoaDonRepository hoaDonRepository;
    
    public HoaDonServiceImpl() {
        this.hoaDonRepository = new HoaDonRepository();
    }

    @Override
    public List<HoaDonDTO> findAll(int position, int pageSize) {
        List<HoaDonDTO> listDTO = new ArrayList<>();
        List<HoaDon> listCuaHang = hoaDonRepository.findAll(position, pageSize);
        for (HoaDon c : listCuaHang) {
            listDTO.add(HoaDonMapper.INSTANCE.toDTO(c));
        }
        return listDTO;
    }

    @Override
    public HoaDonDTO findById(UUID id) {
        HoaDon model = hoaDonRepository.findById(id);
        return HoaDonMapper.INSTANCE.toDTO(model);
    }

    @Override
    public String create(HoaDonDTO hoaDonDTO) {
        hoaDonDTO.setId(null);
        HoaDon model = HoaDonMapper.INSTANCE.toModel(hoaDonDTO);
        if (hoaDonRepository.findByMa(hoaDonDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<HoaDon>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<HoaDon> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (hoaDonRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(HoaDonDTO hoaDonDTO) {
        HoaDon model = HoaDonMapper.INSTANCE.toModel(hoaDonDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<HoaDon>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<HoaDon> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (hoaDonRepository.save(model) != null) {
            result = "Sửa thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return hoaDonRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return hoaDonRepository.totalCount();
    }
    
}
