/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import common.mapper.MauSacMapper;
import common.validator.MyValidatorFactory;
import dto.MauSacDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.MauSac;
import repository.MauSacRepository;
import service.MauSacService;

/**
 *
 * @author macbook
 */
public class MauSacServiceImpl implements MauSacService {

    private final MauSacRepository mauSacRepository;

    public MauSacServiceImpl() {
        this.mauSacRepository = new MauSacRepository();
    }

    @Override
    public List<MauSacDTO> findAll(int position, int pageSize) {
        List<MauSacDTO> listDTO = new ArrayList<>();
        List<MauSac> listModel = mauSacRepository.findAll(position, pageSize);
        for (MauSac nv : listModel) {
            listDTO.add(MauSacMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public List<MauSacDTO> findAll() {
        List<MauSacDTO> listDTO = new ArrayList<>();
        List<MauSac> listModel = mauSacRepository.findAll();
        for (MauSac nv : listModel) {
            listDTO.add(MauSacMapper.INSTANCE.toDTO(nv));
        }
        return listDTO;
    }

    @Override
    public MauSacDTO findById(UUID id) {
        MauSac mauSac = mauSacRepository.findById(id);
        return MauSacMapper.INSTANCE.toDTO(mauSac);
    }

    @Override
    public MauSacDTO findByMa(String ma) {
        MauSac mauSac = mauSacRepository.findByMa(ma);
        return MauSacMapper.INSTANCE.toDTO(mauSac);
    }

    @Override
    public String create(MauSacDTO mauSacDTO) {
        mauSacDTO.setId(null);
        MauSac model = MauSacMapper.INSTANCE.toModel(mauSacDTO);
        if (mauSacRepository.findByMa(mauSacDTO.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<MauSac>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<MauSac> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (mauSacRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public String update(MauSacDTO mauSacDTO) {
        MauSac model = MauSacMapper.INSTANCE.toModel(mauSacDTO);
        Validator validator = MyValidatorFactory.getValidator();
        Set<ConstraintViolation<MauSac>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            String errorMessages = "";
            for (ConstraintViolation<MauSac> violation : violations) {
                errorMessages += violation.getMessage() + "\n";
            }
            return errorMessages;
        }
        
        String result;
        if (mauSacRepository.save(model) != null) {
            result = "Thêm thành công";
        }
        else {
            result = "Mã đã tồn tại";
        }
        return result;
    }

    @Override
    public boolean delete(UUID id) {
        return mauSacRepository.delete(id);
    }

    @Override
    public long totalCount() {
        return mauSacRepository.totalCount();
    }

}
