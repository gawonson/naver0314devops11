package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MycarDto;
import mycar.repository.MycarCommentDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mycar")
public class MycarCommentController {

    final private MycarCommentDao mycarCommentDao;

    @GetMapping("/addcomment")
    public void saveComment(@RequestParam String comment, @RequestParam Long num){

        MycarDto dto=MycarDto.builder()
                .num(num)
                .build();

        MyCarCommentDto commentDto=MyCarCommentDto.builder()
                .comment(comment)
                .mycar(dto)
                .build();

        mycarCommentDao.insertComment(commentDto);
    }

    @GetMapping("/commentlist")
    public List<MyCarCommentDto> CommentList(@RequestParam Long num){

        return mycarCommentDao.getAllComments(num);
    }

    @GetMapping("/commentdelete")
    public void deleteComment(@RequestParam("idx") int idx){

        mycarCommentDao.deleteComment(idx);
    }
}
