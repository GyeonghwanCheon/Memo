package com.example.memo.controller;

import com.example.memo.dto.MemoResponseDto;
import com.example.memo.entity.Memo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/memos")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();


    @PostMapping
    public MemoResponseDto createMemo(@RequestBody MemoResponseDto dto) {

        // 식별자가 1씩 증가하도록 만듦
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;

        // 요청받은 데이터로 메모를 생성
        Memo memo = new Memo(memoId, dto.getTitle(), dto.getContents());

        //Inmemory DB에 Memo 메모
        memoList.put(memoId,memo);

        return new MemoResponseDto(memo);
    }

}
