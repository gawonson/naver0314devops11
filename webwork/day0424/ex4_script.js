$(function () {
    //벽지 이미지 클릭시 이벤트
    $("ul.list img").click(function () {
        //현재 클릭한 이미지의 부모태그인 li에 active 추가
        $(this).parent("li").addClass("active")
        //그 이전에 추가된 active 제거
        $(this).parent("li").siblings("li").removeClass("active")

        //클릭한 이미지의 타이틀 얻기
        let title=$(this).attr("title");

        //위의 title을 h1.title에 적용
        $("h1.title").empty();
        $("h1.title").append(title);

        //클릭한 이미지의 src 얻기
        let imgSrc=$(this).attr("src");

        //위의 src를 div.wall에 넣는데 background-image로 넣기(url이용)
        $("div.wall").css("background-image",`url(${imgSrc})`);
    })
});