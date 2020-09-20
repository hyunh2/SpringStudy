<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/layout/adminheader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
 
    .mainShow table{
        margin-top: 30px;
        width:650px;
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
	function updateBoard(f){
		f.action="updateBoard";
		f.submit();
	}

</script>

         
         <h2>게시글 수정</h2>
   
         <form method="post" enctype="multipart/form-data">
             <table>
                 <tr>
                     <td>카테고리</td>
                     <td>
                     <select name="bdCategory">
                         <option value="공지사항" >공지사항</option>
                         <option value="일반">일반</option>
                         <option value="이벤트">이벤트</option>
                     </select>
                     &nbsp;&nbsp; 현재 카테고리: ${bdDto.bdCategory}
                     </td>
                 </tr>
                 <tr>   
                     <td>제목 </td>
                     <td><input type="text" name="bdTitle" id="title" value="${bdDto.bdTitle}"></td>
                 </tr>
                 <tr>
                        <td>이미지 첨부</td>
                        <td>
                            <input type="file" name="bdImg">
                            <c:if test="${bdDto.bdImg ne null }">
                            <br>현재 이미지: ${bdDto.bdImg }
                            </c:if>
                        </td>
                    </tr>             
                    <tr>
                        <td>내용</td>
                        <td>
                            <textarea cols="50" rows="20" name="bdComment" >${bdDto.bdComment }</textarea>
                        </td>
                    </tr>          
               <tr>
                   <td colspan="2" class="btns">
                       <input type="button" value="수정" onclick="updateBoard(this.form)">
                       <input type="reset" value="초기화">
                       <input type="button" value="취소" onclick="history.back()">
                       <input type="hidden" value="${currentPage }" name="currentPage">
                       <input type="hidden" value="${bdDto.bdImg  }" name="oldimg">
                       <input type="hidden" value="${bdDto.bdIdx  }" name="bdIdx">
                   </td>
               </tr>

             </table>
             
         </form>
   
 
        </div>
        
    </div>
    
    
</div>
</body>
</html>