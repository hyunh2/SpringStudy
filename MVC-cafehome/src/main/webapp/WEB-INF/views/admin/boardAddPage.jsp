<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/layout/adminheader.jsp"/>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-migrate-3.1.0.js"></script>
<style>
 
    .mainShow table{
        margin-top: 30px;
        width:550px;
        border-collapse: collapse;
    }
    .mainShow tr,td{
        padding:10px;
    }
    
    .mainShow input[type="text"]{
    padding:5px;
    }
    
    .mainShow select{
        padding:5px;
    }
    .btns{
        text-align: center;
        margin: auto;
    }
    
    .btns input{
        padding:10px;
        border-radius: 10px;
        border: solid 2px white;
    }
    .btns input:hover{
        border: solid 2px black;
        background-color: floralwhite;
    }
    
</style>
<script>
	function addBoard(f){
		var title = f.title.value;
		var comment = f.comment.value;
		
		if(title =="" || comment == ""){
			alert("모든 항목을 채워주세요.");
			return;
		}else{
			f.action="addBoard";
			f.submit();
		}
	}
	
</script>

         
         <h2>게시글 추가</h2>
         <form method="post" enctype="multipart/form-data">
             <table>
                 <tr>
                     <td>카테고리</td>
                     <td>
                     <select name="bdCategory" id="category" >
                         <option value="공지사항" >공지사항</option>
                         <option value="일반">일반</option>
                         <option value="이벤트">이벤트</option>
                     </select>
                     </td>
                 </tr>
                 <tr>   
                     <td>제목</td>
                     <td>
                         <input type="text" name="bdTitle" id="title" >
                     </td>
                 </tr>
                    <tr>
                        <td>이미지 첨부</td>
                        <td>
                            <input type="file" name="bdImg">
                        </td>
                    </tr>             
                    <tr>
                        <td>내용</td>
                        <td>
                            <textarea cols="50" rows="20" name="bdComment" id="comment"></textarea>
                        </td>
                    </tr>          
               <tr>
                   <td colspan="2" class="btns">
                       <input type="button" value="추가" onclick="addBoard(this.form)">
                       <input type="reset" value="초기화">
                       <input type="button" value="취소" onclick="history.back()">
                   </td>
               </tr>

             </table>
             
         </form>
         
         
         
         
         
         
         
        </div>
        
    </div>
    
    
</div>
</body>
</html>