import * as React from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import img1 from '../image/2.jpg'

const ExpandMore = styled((props) => {
    const { expand, ...other } = props;
    return <IconButton {...other} />;
  })(({ theme, expand }) => ({
    transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
      duration: theme.transitions.duration.shortest,
    }),
  }));
  
  export default function RecipeReviewCard() {
    const [expanded, setExpanded] = React.useState(false);
  
    const handleExpandClick = () => {
      setExpanded(!expanded);
    };

    return (
      <Card sx={{ maxWidth: 345 }}>
        <CardHeader
          avatar={
            <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
              R
            </Avatar>
          }
          action={
            <IconButton aria-label="settings">
              <MoreVertIcon />
            </IconButton>
          }
          title="김우빈"
          subheader="September 14, 2016"
        />
        <CardMedia
          component="img"
          height="194"
          image={img1}
          alt="Paella dish"
        />
        <CardContent>
          <Typography variant="body2" color="text.secondary">
          출생
            1989. 7. 16.
            신체
            188cm
            소속사
            에이엠엔터테인먼트
            데뷔
            2008년 김서룡옴므쇼 모델
            수상
            2014년 제35회 청룡영화상 인기스타상
            경력
            2018 평창동계올림픽 홍보대사
            사이트
            인스타그램
            작품
            영화, 방송, 공연, 곡, 앨범, 관련활동
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites">
            <FavoriteIcon />
          </IconButton>
          <IconButton aria-label="share">
            <ShareIcon />
          </IconButton>
          <ExpandMore
            expand={expanded}
            onClick={handleExpandClick}
            aria-expanded={expanded}
            aria-label="show more"
          >
            <ExpandMoreIcon />
          </ExpandMore>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <CardContent>
            <Typography paragraph>작품</Typography>
            <Typography paragraph>
            배우 이전에 2008년 김서룡옴므쇼에서 모델로 데뷔하였다. 이후 부산 프레타포르테 09 S/S 서은길, 서울패션위크 09 F/W 강동준, 김서룡, 이주영, 이영준, 박성철 등 잡지 맥심, W, 보그걸, 엘르걸, 맵스의 모델로 활약하면서 입지를 다져갔다. 큰 키, 늘씬한 몸매와 강렬한 인상과 로우톤의 무게감 있는 목소리가 인상적이다. 본명은 김현중으로 동명의 아이돌과의 혼동을 우려해 김우빈이라는 예명을 사용 중이다. 모델에 대한 열정은 고교생 때 어떤 대학교 게시판에 교수님께 쓴 글들이 이슈되면서 알려졌고 지금까지도 계속 회자되고 있다.
            </Typography>
            <Typography paragraph>
            2011년 《KBS 드라마 스페셜 - 화이트 크리스마스》에서 강미르 역을 맡으면서 연기자로 데뷔했다. 이 때 새빨간 머리와 강한 캐릭터로 시청자들에게 눈도장을 찍었다. 그 후 《KBS 드라마 스페셜 - 큐피드 팩토리》에서는 이희준, 박수진과 MBN 시트콤 《뱀파이어 아이돌》에서 절친으로 알려진 이수혁, 홍종현 등과 함께 호흡을 맞추면서 비교적 많은 시청률을 이끌어내지는 못 했지만 연기자로서의 입지를 다졌다. 2012년 1월경부터는 본명 김현중에서 예명 김우빈으로 활동명을 바꿔 활동하기 시작한다.[7] SBS 드라마 《신사의 품격》에서 주인공 서이수(배우 김하늘)를 짝사랑하는 제자 김동협 역을 맡으면서 이름을 알리기 시작했다. SBS 드라마 《아름다운 그대에게》를 거쳐 같은 해인 2012년 KBS 드라마 《학교 2013》에서 박흥수 역을 맡아 이종석과 브로맨스 호흡을 맞추면서 두터운 팬덤을 확보하기 시작한다. 이 때부터 김우빈이 교복을 입으면 성공한다는 기분 좋은 말도 생겨났다.
            </Typography>
            <Typography paragraph>



2011년 《KBS 드라마 스페셜 - 화이트 크리스마스》에서 강미르 역을 맡으면서 연기자로 데뷔했다. 이 때 새빨간 머리와 강한 캐릭터로 시청자들에게 눈도장을 찍었다. 그 후 《KBS 드라마 스페셜 - 큐피드 팩토리》에서는 이희준, 박수진과 MBN 시트콤 《뱀파이어 아이돌》에서 절친으로 알려진 이수혁, 홍종현 등과 함께 호흡을 맞추면서 비교적 많은 시청률을 이끌어내지는 못 했지만 연기자로서의 입지를 다졌다. 2012년 1월경부터는 본명 김현중에서 예명 김우빈으로 활동명을 바꿔 활동하기 시작한다.[7] SBS 드라마 《신사의 품격》에서 주인공 서이수(배우 김하늘)를 짝사랑하는 제자 김동협 역을 맡으면서 이름을 알리기 시작했다. SBS 드라마 《아름다운 그대에게》를 거쳐 같은 해인 2012년 KBS 드라마 《학교 2013》에서 박흥수 역을 맡아 이종석과 브로맨스 호흡을 맞추면서 두터운 팬덤을 확보하기 시작한다. 이 때부터 김우빈이 교복을 입으면 성공한다는 기분 좋은 말도 생겨났다.

드라마 '상속자들' 출연 中

《학교 2013》에서의 성공 이후 곽경택 감독의 《친구2》를 차기작으로 선택하며 스크린에 데뷔했다. 전작 친구에서 주연이었던 동수(배우 장동건)의 아들인 성훈 역을 맡으면서 대선배인 배우 유오성, 주진모와 견주어도 뒤떨어지지 않는 연기력을 선보였으며 2013년 SBS 드라마 《상속자들》에서 호텔 상속자이자 여주인공을 짝사랑하는 최영도 역을 맡아 많은 여성의 팬심을 얻었다. 이 드라마에서 보여준 연기력을 통해 최고의 기대주로 인정받게 되었다. 이 인기를 이어 2013년 8월 15일부터 2014년 2월 13일까지 많은 신인 배우들이 거쳐가는 MTV 《엠카운트다운》의 MC를 맡았다. 이 때 남다른 어깨너비와 188cm나 되는 키로 이슈화되었다. 이후 2014년 영화 《기술자들》에서 모든 방면에서 다재다능한 금고털이범 지혁 역을 맡으면서 또 다른 매력을 선보인다. 같은 해 강하늘과 이준호와 함께 출연한 영화 《스물》에서는 인기만 많은 치호 역을 맡으면서 스무살 청춘들의 동감을 얻으며 차차 배우로서의 연기 스펙트럼을 넓혀간다.
            </Typography>
            <Typography>
            2016년 KBS 드라마 《함부로 애틋하게》에서 주연인 신준영 역을 맡으면서 시한부 인생을 살게 된 톱스타의 감정선과 수지와의 로맨틱한 호흡으로 매력을 보여준다. 같은 해 출연한 영화 《마스터》에서 박장군 역을 맡으면서 대선배인 이병헌과 강동원과의 호흡으로 사람들의 관심을 이끌어 냈다.

김우빈은 이후 차기작 검토 중 2017년 5월 24일 비인두암 진단을 받고 투병 중이라고 보도되었다. 2017년 말이나 다음 해 초에 입대하려고 했는데, 징병검사에서 항암치료로 민방위 훈련도 받지 않는 6급을 받아[8] 병역면제가 되었다. 암은 증세가 심하지 않아도 대부분 면제 판정이 나온다. 다행히 치료 시기가 늦지 않아서 약물치료와 방사선 치료를 병행하고 있다고 한다. 한국에서 비인두암[9]에 걸리는 경우는 유전적 요인은 거의 없고, 수영을 많이 할 시 수영장에서 소독 처리된 물이 제대로 처리되어 있지 않거나 과도하게 처리된 경우, 수영장의 위생에 의해 발병률이 높다. 공식 입장

2017년 12월 김우빈은 팬카페를 통해 “3번의 항암치료와 35번의 방사선 치료를 무사히 마쳤다. 다시 인사드리기까지 시간이 조금 필요할 것 같다. 다시 건강하게 꼭 인사하겠다”고 전했다.
            </Typography>
          </CardContent>
        </Collapse>
      </Card>
    );
  }
  