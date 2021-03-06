<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../comm/header.jsp" %>
<%@include file="../comm/side.jsp" %>
      <div id="colorlib-main">
         <section class="ftco-section-no-padding bg-light">
            <div class="hero-wrap">
               <div class="overlay"></div>
               <div class="d-flex">
                  <div class="author-image text img p-md-5" style="background-image: url('resources/upload/${member.user_img}');">
                     
                  </div>
                  <div class="author-info text p-4 p-md-5 mt-5 mb-5">
                     <div class="desc">
                     <input type="hidden" name="user_num" id="user_num"   value="${sessionScope.user_num }">
                        <span class="subheading">Mypage</span>
                        <!-- 활동중 -->
                     <img style="height: 60px;" src="images/offline_big.png" id="indicator" class="indicator">
                        <div style="position: absolute; right: 20px; top: 0;">
                        
                        </div>
                        <h1 class="big-letter"></h1>
                        <h1 class="mb-4"><span>${member.name }님의 마이페이지</span></h1>
                        <p class="mb-4">${member.user_intro }</p>
                        <h3 class="signature h1">${member.nickname }</h3>
                        <img src="resources/img/btn/chat.png" id="chat" style="cursor: pointer; width:40px;" data-toggle="tooltip" data-placement="top" title="chat">채팅확인
                        
<!--                         채팅확인 영역 시작-->
                        <div class="col-md-12 col-md-offset-12 text-center" id="checkset" style="border: 1px solid #240B3B; margin-bottom: 30px; padding: 30px; display:none;">
	                        <div class="widget-content-wrapper">
                        		<div class="col-md-12 col-md-offset-12 text-center">
							    			<div class="col-md-12" id="chatRequestList">
											</div>
												<div class="blog-entry ftco-animate d-md-flex">
												</div>
												<div>
								              		<p class="mb-2"></p>
								           	 			<div class="meta-wrap">
															<p class="meta"></p>
							              				</div>
								            		<p class="mb-4"> </p>
								            		<br>
												</div>
							    		<a href="chat.do">채팅 보러가기</a>
			 					</div>	
                     	   </div>
                  	 	 </div>
            			 </div>
              			 <!-- 채팅확인 영역 끝 -->
              	    </div>
               </div>
            </div>
         </section>
         <section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url(images/bg_1.jpg);">
          <div class="container">
             <div class="row justify-content-start">
                <div class="col-md-10">
                   <div class="row">
                   <div class="col-xl-3 col-md-6 d-flex justify-content-center counter-wrap ftco-animate">
                     <div class="block-18">
                       <div class="text d-flex align-items-center">
                         <span> </span>
                       </div>
                     </div>
                   </div>
                   <div class="col-xl-3 col-md-6 d-flex justify-content-center counter-wrap ftco-animate">
                     <div class="block-18">
                       <a onclick="fillower()" data-target="#followermodal" data-toggle="modal" style="cursor: pointer;">
                       <div class="text d-flex align-items-center">
                         <span>받은 좋아요</span>

                         <strong class="number" data-number=${cnt2 }>0</strong>
                       </div></a>
                     </div>
                   </div>
                    <div class="col-xl-3 col-md-6 d-flex justify-content-center counter-wrap ftco-animate">
                     <div class="block-18">
                     <a onclick="follow()" data-target="#followmodal" data-toggle="modal" style="cursor: pointer;">
                       <div class="text d-flex align-items-center">
                         <span>보낸 좋아요</span>

                         <strong class="number" data-number="${cnt1 }">0</strong>
                       </div></a>
                     </div>
                   </div>
                   <div class="col-xl-3 col-md-6 d-flex justify-content-center counter-wrap ftco-animate">
                     <div class="block-18">
                       <div class="text d-flex align-items-center">
                         <span>게시물</span>
                         <strong class="number" data-number="${maxnum }">0</strong>
                       </div>
                     </div>
                   </div>
                 </div>
              </div>
           </div>
          </div>
       </section>
         <section class="ftco-section-3">
      <div class="photograhy">
         <div class="row">
         <c:forEach var="e" items="${boardlist}">
            <div class="col-md-4 ftco-animate">
               <a href="board?board_num=${e.board_num }">
                  <img src="resources/upload/${e.board_img}" class="photography-entry img d-flex justify-content-start align-items-end" style="width: 420px;">
                  <div class="overlay"></div>
               </a>
            </div>
            </c:forEach>
         </div>
      </div>
   </section>


</div>
<!-- END COLORLIB-MAIN -->
</div>
<!-- END COLORLIB-PAGE -->

<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
	<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
			stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
			stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
</div>

<!-- Modal -->
   <div class="modal fade" id="followermodal" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog  modal-dialog-centered" role="document" style="max-width: 100%; width: 500px; height:600px; display: table;">
         <div class="modal-content">
            <div class="modal-header">
               <b><h2 class="modal-title" id="myModalLabel">좋아요 받은 LIST</h2></b>
               <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close" style="float: right;">
                  <span aria-hidden="true">&times;</span>
               </button>
            </div>
            <div class="modal-body">
               <!-- <form method="post" id="checked" action="reportBoard"> -->
               				 
                             <c:forEach var="f" items="${follower}" varStatus="r">
                             <input type="hidden" class="user_number" name="user_number" value="${f.LIKER_USER}">  
                             <div>
                              <div style="float: left;">
                               <a href="friend?user_num=${f.LIKER_USER}">
                              <div style="position: absolute;">
                              <div style="position: relative;"><img style="width: 10px;" src="images/offline.png" id="indicato${r.count}"></div>
                              </div>
                              <img style=" width:50px; height:50px; border-radius:50%;display:block;" src="resources/upload/${f.USER_IMG}"></a> 
                              </div>
                              <div style="color: black; font-size: 20px;">&nbsp;${f.NICKNAME}</div><br>
                              </div>
                               <hr style="color: gray;">
                          
                  </c:forEach>
            </div>
            <div class="modal-footer">
               
            </div>
         </div>
      </div>
   </div>
   
      <!-- Modal2 -->
   <div class="modal fade" id="followmodal" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog  modal-dialog-centered" role="document" style="max-width: 100%; width: 500px; height:600px; display: table;">
         <div class="modal-content">
            <div class="modal-header">
               <b><h2 class="modal-title" id="myModalLabel">좋아요 누른 LIST</h2></b>
               <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close" style="float: right;">
                  <span aria-hidden="true">&times;</span>
               </button>
            </div>
           <div class="modal-body">
               				
                             <c:forEach var="f" items="${follow}" varStatus="r">
                             <input type="hidden" class="user_number2" name="user_number2" value="${f.LIKER_USER}">   
                             <div>
                              <div style="float: left;">
                               <a href="friend?user_num=${f.LIKER_USER}">
                              <div style="position: absolute;">
                              <div style="position: relative;"><img style="width: 10px;" src="images/offline.png" id="indicator_rc${r.count}"></div>
                              </div>
                              <img style=" width:50px; height:50px; border-radius:50%;display:block;" src="resources/upload/${f.USER_IMG}"></a> 
                              </div>
                              <div style="color: black; font-size: 20px;">&nbsp;${f.NICKNAME}</div><br>
                              </div>
                               <hr style="color: gray;">
                 			 </c:forEach>
               
               
               
               
               
               
               
               <%-- 
               
                          <c:forEach var="f" items="${follow }" varStatus="r">
                             <div>
                                <div style="float: left;">
                             <a href="friend?user_num=${f.LIKER_USER }">
                             <img style=" width:50px; height:50px; border-radius:50%; display:block;" src="resources/upload/${f.USER_IMG }"> 
                             <input type="hidden" class="user_number2" name="user_number2" value="${f.LIKER_USER }">   
                     <!-- 활동중 -->
                          <img style="width: 10px;" src="images/offline.png" id="indicator_rc${r.count }">
                             </a></div>
                             <div style="color: black; font-size: 20px;">&nbsp;${f.NICKNAME }</div><br>
                             <hr style="color: gray;">
                  </div>
                  </c:forEach> --%>
            </div>
            <div class="modal-footer">
               
            </div>
         </div>
      </div>
   </div>
	<script>
		// 체크박스 슬라이드 토글
		$(document).on('click', '#chat', function(event) {
			$("#checkset").slideToggle();
			var user = ${sessionScope.user_num};
			$.ajax({
				url : "responeChatList",
				type : "GET",
				data : {user : user},
				contentType : "application/json; chatset=utf-8",
				dataType : "json",
				success : function(res){
					console.log(res);
					for(var i = 0; i<res.length; i++){
						var map = res[i];
						console.log(map);
						var	printHTML = '<div class="blog-entry ftco-animate d-md-flex fadeInUp ftco-animated" style="float: left;">';
						printHTML += '<input type="hidden" id="reqChatUser" value='+map["USER_NUM"]+'>';
						printHTML += '<input type="hidden" id="reqChatNum" value='+map["CHATROOM"]+'>';
						printHTML += '<img id="sajutwo" src="resources/upload/'+map["USER_IMG"]+'" alt="iljuanimal" style="margin-top: 10px;" class="col-md-4">';
						printHTML += '<span class="col-md-6">';
						printHTML += '<h4>'+map["NICKNAME"]+'</h4>';
						printHTML += '</span>';
						printHTML += '<button class="border-0 btn-transition btn btn-outline-success col-md-1" onclick="successChat()"> <i class="fa fa-check"></i></button>';
						printHTML += '<button class="border-0 btn-transition btn btn-outline-danger col-md-1" onclick="deleteChat()"> <i class="fa fa-check"></i> </button>'; 
						printHTML += '</div>';
						$("#chatRequestList").append(printHTML);
					}
				},
				error : function(request,status,error){
					alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
				}
			});
		});
		function successChat() {
			var sessionId = ${sessionScope.user_num};
			console.log("수락 펑션  세션아이디 : " + sessionId);
			var param = new Object;
			param.user2 = sessionId;
			param.user1 = $("#reqChatUser").val();
			param.chatroom = $("#reqChatNum").val();
			var paramJson = JSON.stringify(param);
			$.ajax({
				url : "updateRoom",
				data : paramJson,
				contentType : "application/json; charset=utf-8",
				type : "POST",
				success : function (res) {
					if(res == "success"){
						alert("상대방과 채팅을 진행할수있습니다.");
						document.location.href = document.location.href; 
					}
				},
				error : function (request,status,error) {
					console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error);
				}
			});
		}
	</script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.timepicker.min.js"></script>
<script src="js/scrollax.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>