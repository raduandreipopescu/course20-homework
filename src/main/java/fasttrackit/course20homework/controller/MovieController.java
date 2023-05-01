package fasttrackit.course20homework.controller;

import fasttrackit.course20homework.model.dto.MovieDTO;
import fasttrackit.course20homework.model.dto.MovieMapper;
import fasttrackit.course20homework.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService service;

    @GetMapping
    public List<MovieDTO> getAll() {
        return service.getAll().stream()
                .map(MovieMapper::toDto)
                .toList();
    }
}
