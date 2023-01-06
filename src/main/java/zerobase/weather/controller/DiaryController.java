package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation("API 호출 후 JSON 파싱하여 DB에 저장")
    void createDiary(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "yyyy-MM-dd", example = "2023-01-09") LocalDate date,
        @RequestBody String text
    ){
        diaryService.createDiary(date, text);
    }


    @GetMapping("/read/diary")
    @ApiOperation("DB에 저장된 Diary 엔티티를 리턴")
    List<Diary> readDiary(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "yyyy-MM-dd", example = "2023-01-09") LocalDate date
        ){
        return diaryService.readDiary(date);
    }


    @GetMapping("/read/diaries")
    @ApiOperation("날짜 범위에 맞는 Diary 엔티티를 DB에서 읽은 후 리턴")
    List<Diary> readDiaries(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "yyyy-MM-dd", example = "2023-01-09") LocalDate startDate,
        @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "yyyy-MM-dd", example = "2023-01-11") LocalDate endDate
    ){
        return diaryService.readDiaries(startDate, endDate);
    }



    @PutMapping("/update/diary")
    @ApiOperation("해당 날짜의 첫 번째 날씨 일기 내용을 새로 입력한 텍스트로 수정")
    void updateDiary(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "yyyy-MM-dd", example = "2023-01-09") LocalDate date,
        @RequestBody String text
    ){
        diaryService.updateDiary(date, text);
    }



    @DeleteMapping("/delete/diary")
    @ApiOperation("입력한 날짜에 작성된 모든 날씨 일기 데이터를 DB에서 삭제")
    void deleteDiary(
        @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "yyyy-MM-dd", example = "2023-01-09") LocalDate date
    ){
        diaryService.deleteDiary(date);
    }

}
