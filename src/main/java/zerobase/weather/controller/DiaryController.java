package zerobase.weather.controller;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/create/diary")
    void createDiary(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        @RequestBody String text
    ){
        diaryService.createDiary(date, text);
    }


    @GetMapping("/read/diary")
    List<Diary> readDiary(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date
        ){
        return diaryService.readDiary(date);
    }


    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,
        @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate endDate
    ){
        return diaryService.readDiaries(startDate, endDate);
    }



    @PutMapping("/update/diary")
    void updateDiary(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date,
        @RequestBody String text
    ){
        diaryService.updateDiary(date, text);
    }



    @DeleteMapping("/delete/diary")
    void deleteDiary(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date
    ){
        diaryService.deleteDiary(date);
    }

}
