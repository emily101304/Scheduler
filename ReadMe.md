## 프로젝트 소개
[🗓️ CH.3 일정 관리 앱 만들기 🗓️](https://teamsparta.notion.site/Spring-5-CH-3-1832dc3ef51480c38335c8a9ecf707be)
<br><br>
🌑 `Lv.0` API명세서 및 ERD 작성 <br>
🌒 `Lv.1` 일정 생성 및 조회 <br>
🌓 `Lv.2` 일정 수정 및 삭제 <br>
🌔 `Lv.3` `Challenge` 연관 관계 설정<br>
🌕 `Lv.4` `Challenge` 페이지네이션 <br>
🌖 `Lv.5` `Challenge` 예외 발생 처리 <br>
🌗 `Lv.6` `Challenge` null 체크 및 특정 패턴에 대한 검증 수행 <br>

## API 명세서
| Description | Method |          Path          |                              Request                              |                                                 Response                                                  |          StatusCode          |
|:-----------:|:------:|:----------------------:|:-----------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------:|:----------------------------:|
|    일정 등록    |  POST  |     /api/schedules     | [{"user" : String,<br/>"todo" : String,<br/>"password" : String}] | [{"id" : int,<br/>"user" : String,<br/>"todo" : String,<br/>"initDate" : String,<br/>"modDate" : String}] |             201              |
|  일정 전체 조회   |  GET   |     /api/schedules     |              [{"user" : String,<br/>"date": String}]              | [{"id" : int,<br/>"user" : String,<br/>"todo" : String,<br/>"initDate" : String,<br/>"modDate" : String}] |             200              |
|  일정 단건 조회   |  GET   |  /api/schedules/{id}   |                                 -                                 | [{"id" : int,<br/>"user" : String,<br/>"todo" : String,<br/>"initDate" : String,<br/>"modDate" : String}] |     200<br/>400<br/>404      |
|  일정 단건 수정   | PATCH  |  /api/schedules/{id}   |                                 -                                 | [{"id" : int,<br/>"user" : String,<br/>"todo" : String,<br/>"initDate" : String,<br/>"modDate" : String}] |     200<br/>400<br/>404      |
|  일정 단건 삭제   | DELETE |  /api/schedules/{id}   |                                 -                                 |                                                     -                                                     |            200<br/>404            |

## 개발 환경
* ![JAVA](https://camo.githubusercontent.com/457a848193ea3168ad5602c0096e9742da98988e1066f9b3125175a6a0f4f9c7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176612d3030373339363f267374796c653d666f722d7468652d6261646765266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465)
* <img src="https://blog.hyunsub.kim/covers/spring.png" width="57px"></img>