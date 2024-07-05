package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MycarDto;
import mycar.repository.MycarDao;
import naver.storage.NcpObjectStorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MycarController {

    private final MycarDao mycarDao;
    private final NcpObjectStorageService storageService;


    //bucket 명
    String bucketName="bitcamp-gawon-136";
    //업로드할 폴더명
    String folderName="mycar";

    @GetMapping("/")
    public String home() {
        return "redirect:./mycar/list";
    }

//    @GetMapping("/mycar/list")
//    public String list(Model model) {
//
//        List<MycarDto> list=mycarDao.getAllCars();
//        model.addAttribute("list",list);
//        model.addAttribute("count",list.size());
//        return "mycar/mycarlist";
//    }

    @GetMapping("/mycar/form")
    public String form() {
        return "mycar/mycarform";
    }

    @PostMapping("/mycar/insert")
    public String insertCar(@ModelAttribute MycarDto dto,
                            @RequestParam("carupload") MultipartFile carupload)
    {

        //사진을 업로두 후 업로드된 파일명 반환
        String carphoto=storageService.uploadFile(bucketName, folderName, carupload);
        dto.setCarphoto(carphoto);
        //db insert
        mycarDao.insertcar(dto);
        return "redirect:./list";

    }

    @GetMapping("/mycar/detail")
    public String detail(Model model , @RequestParam("num") Long num){

        MycarDto dto=mycarDao.getData(num);
        model.addAttribute("dto",dto);

        return "mycar/mycardetail";
    };

    @GetMapping("/mycar/delete")
    public String delete(@RequestParam("num") Long num){
        String photoname=mycarDao.getData(num).getCarphoto();
        storageService.deleteFile(bucketName, folderName, photoname);

        mycarDao.deleteCar(num);

        return "redirect:./list";
    }

    //수정폼에 정보 나르기
    @GetMapping("/mycar/carupdate")
    public String updateForm(@RequestParam("num") Long num,Model model){
        MycarDto dto=mycarDao.getData(num);
        model.addAttribute("dto",dto);
        return "mycar/mycarupdateform";
    }
    //수정
    @PostMapping("/mycar/update")
    public String update(@ModelAttribute MycarDto dto,@RequestParam("carupload") MultipartFile carupload){

        //수정시 사진선택을 안한경우 carphoto에 'no'
        if(carupload.getOriginalFilename().equals("")){
            dto.setCarphoto("no");
        }
        else{
            //사진 수정을 하기전 스토리지의 기존 사진을 지워보자
            String oldPhotoname=mycarDao.getData(dto.getNum()).getCarphoto();//기존 파일명
            storageService.deleteFile(bucketName, folderName, oldPhotoname);
            String photo=storageService.uploadFile(bucketName, folderName, carupload);//storage에 파일 업로드
            dto.setCarphoto(photo);//dto 에 업로드된 파일명 넣기
        }
        mycarDao.updateCar(dto);



        return "redirect:./detail?num="+dto.getNum();
    }


    //페이징 처리
    int pageSize;
    @GetMapping("/mycar/list")
    public String list(Model model ,@RequestParam(value = "more",defaultValue = "0")int more) {

        //more가 0이면 기본 3개만 출력
        //0이 아니면 기본사이즈에 more값을 추가해서 목록을 가져와보자
        if(more==0){
            pageSize=3;
        }
        else {
            pageSize+=more;
        }

        Pageable pageable= PageRequest.of(0,pageSize, Sort.by("num").ascending());

        Page<MycarDto> result=mycarDao.getAllCars(pageable);
//        List<MycarDto> list=mycarDao.getAllCars();

        model.addAttribute("totalCount",result.getTotalElements());//총 갯수
        model.addAttribute("totalPage",result.getTotalPages());//총 페이지 수
        model.addAttribute("pageSize",pageSize);//
        model.addAttribute("list",result.getContent());//페이지에 들어갈 detail


        return "mycar/mycarlist";
    }
}
