package com.mashup.luvket.domain.luvket.service;

import com.mashup.luvket.domain.luvket.dto.LuvketDto;
import com.mashup.luvket.domain.luvket.entity.Luvket;
import com.mashup.luvket.domain.luvket.repository.LuvketRepository;
import com.mashup.luvket.model.LuvketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LuvketService {

    private final LuvketRepository luvketRepository;

    public LuvketResponse<List<LuvketDto>> search(Pageable pageable) {
        Page<Luvket> luvkets = luvketRepository.findAll(pageable);
//        System.out.println(pageable);
//        pageable.get

        List<LuvketDto> luvketDtoList = luvkets.stream()
                .map(luvket -> response(luvket))
                .collect(Collectors.toList());

        return LuvketResponse.<List<LuvketDto>>builder()
                .code(HttpStatus.OK.value())
                .message(pageable.getPageNumber()+1 + " 번째 페이지 불러오기 완료")
                .data(luvketDtoList)
                .build();
    }

    private LuvketDto response(Luvket luvket) {
        return LuvketDto.builder()
                .userId(luvket.getUserId())
                .title(luvket.getTitle())
                .categoryId(luvket.getCategoryId())
                .status(luvket.getStatus())
                .publicOpen(luvket.isPublicOpen())
                .scheduleId(luvket.getScheduleId())
                .build();
    }
}
