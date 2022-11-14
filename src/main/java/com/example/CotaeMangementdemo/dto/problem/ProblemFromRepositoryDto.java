package com.example.CotaeMangementdemo.dto.problem;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemFromRepositoryDto {
    private Long id;
    private Long problemId;
    private String problemNam;
    private String url;

    public ProblemFromRepositoryDto(Long id, Long problemId, String problemNam, String url) {
        this.id = id;
        this.problemId = problemId;
        this.problemNam = problemNam;
        this.url = url;
    }
}
