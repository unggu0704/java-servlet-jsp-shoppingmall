# 피드백

- UserRepositoryImpl에서 log.debug와 log.info를 쓰셨는데, 굳이 로그인 정보가 맞는지 아닌지에 대한 정보를 info로 한 이유가 있을까요? 그냥 개발시에 확인할 debuging용이라면 debug단계로 설정하셔도 될것 같습니다. 또한 다른 곳에서 에러가 발생하면 log.error를 쓰시던데, 통일성있게 다른 Exception 발생시에도 적어주셨으면 더 좋았을 것 같습니다.
- LoginPostController에서 틀린건 아니지만 굳이 loginFail이라는 것을 사용해서 구분해야하나요? doLogin하고나서 생긴 user이 not null이라면 session에 ssession.setAttribute(“userId”, user.getUserId()) 이런식으로 하고 login.do로 보내버리면 거기 컨트롤러에서 로그인이 안되면 다시 폼을 보여줄거고 아니면 index로 보여줄것같습니다.
- getSession(), getSession(true), getSession(false)의 차이점에 대해서 공부해보시면 좋을 것 같습니다.

## 상품관리
- 이미지 등록 시 업로드를 하지 않고 링크를 받아서 이미지를 처리하는 것 같습니다. 업로드, 다운로드를 구현해보세요
- 상품 이미지가 없는 경우에 대해 처리가 안되어있는 것 같습니다. 무조건 사진 링크를 첨부해야하네요.
