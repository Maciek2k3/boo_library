package com.kodillatask.library.controller;

import com.kodillatask.library.domian.Copy;
import com.kodillatask.library.domian.CopyDto;
import com.kodillatask.library.mapper.CopyMapper;
import com.kodillatask.library.service.CopyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1")
@CrossOrigin(origins = "*")
public class CopyController {
    private CopyMapper copyMapper;
    private CopyService copyService;

    public CopyController(CopyMapper copyMapper, CopyService copyService) {
        this.copyMapper = copyMapper;
        this.copyService = copyService;
    }

    @GetMapping("/getCopies")
    public List<CopyDto> getAllCopies() {
        List<Copy> copies = copyService.findAllCopy();
        return copyMapper.mapToCopyList(copies);
    }

    @GetMapping("/getCopy")
    @ResponseBody
    public CopyDto getByIdCopy(@RequestParam long id) throws NotFoundEeption {
        Copy copy = copyService.findCopyById(id)
                .orElseThrow(NotFoundEeption::new);
        return copyMapper.maptoCopyDto(copy);
    }


    @DeleteMapping("/deleteCopy")
    public void deleteByIdCopy(@RequestParam long id) {
        copyService.deleteCopyById(id);
    }

    @PutMapping("/updateCopy")
    public CopyDto udpateOrder(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        Copy savedCopy = copyService.saveCopy(copy);
        return copyMapper.maptoCopyDto(savedCopy);
    }

    @PostMapping("/addCopy")
    public void addCopy(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        copyService.saveCopy(copy);
    }
    @GetMapping("/checkAvailable")
    public Integer getAvailables(@RequestParam String title){
        return copyService.getAvailables(title);
    }

}
