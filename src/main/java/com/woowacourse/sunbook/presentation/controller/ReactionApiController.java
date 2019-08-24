package com.woowacourse.sunbook.presentation.controller;

import com.woowacourse.sunbook.application.dto.reaction.ReactionDto;
import com.woowacourse.sunbook.application.service.ReactionArticleService;
import com.woowacourse.sunbook.presentation.support.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles/{articleId}/good")
public class ReactionApiController {
    private ReactionArticleService reactionArticleService;

    @Autowired
    public ReactionApiController(ReactionArticleService reactionArticleService) {
        this.reactionArticleService = reactionArticleService;
    }

    @GetMapping
    public ResponseEntity<ReactionDto> showGood(@PathVariable Long articleId,
                                                LoginUser loginUser) {
        ReactionDto reactionDto = reactionArticleService
                .showCount(loginUser.getId(), articleId);

        return new ResponseEntity<>(reactionDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReactionDto> clickGood(@PathVariable Long articleId,
                                                 LoginUser loginUser) {
        ReactionDto resultReactionDto = reactionArticleService.
                clickGood(loginUser.getId(), articleId);

        return new ResponseEntity<>(resultReactionDto, HttpStatus.OK);
    }
}
