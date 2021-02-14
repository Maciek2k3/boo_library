package com.kodillatask.library.service;

import com.kodillatask.library.domian.Copy;
import com.kodillatask.library.domian.CopyDto;
import com.kodillatask.library.repository.CopyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CopyService {

    public final CopyRepository copyRepository;

    public CopyService(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    public List<Copy> findAllCopy() {
        return copyRepository.findAll();

    }

    public void deleteCopyById(Long id) {
        copyRepository.deleteById(id);
    }

    public Optional<Copy> findCopyById(Long id) {
        return copyRepository.findById(id);
    }

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public Integer getAvailables(String title) {
        return copyRepository.countAvailableCopies(title);
    }

}
