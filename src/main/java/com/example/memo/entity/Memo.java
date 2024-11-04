package com.example.memo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Memo {

    private Long id;
    private String title;
    private String contents;

}
