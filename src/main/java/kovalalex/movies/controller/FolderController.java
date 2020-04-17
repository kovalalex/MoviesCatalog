package kovalalex.movies.controller;

import kovalalex.movies.domain.Folder;
import kovalalex.movies.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/folders")
public class FolderController {

    private final FolderRepository folderRepository;

    @Autowired
    public FolderController(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @GetMapping
    public List<Folder> getAll(){
        return folderRepository.findAll();
    }
}
